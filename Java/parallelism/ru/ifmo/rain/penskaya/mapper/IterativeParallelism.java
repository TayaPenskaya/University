package ru.ifmo.rain.penskaya.mapper;

import info.kgeorgiy.java.advanced.concurrent.ListIP;
import info.kgeorgiy.java.advanced.concurrent.ScalarIP;
import info.kgeorgiy.java.advanced.mapper.ParallelMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IterativeParallelism implements ScalarIP, ListIP {
    ParallelMapper parallelMapper;
    int threadsNumber;
    int eachCount;
    int remainder;

    public IterativeParallelism(ParallelMapper parallelMapper){
        this.parallelMapper = parallelMapper;
    }

    private <T> void partition(int i, List<? extends T> list) {
        if (i <= 0) throw new IllegalArgumentException("Illegal threads number!");
        int threadsNumber = Math.max(1, Math.min(list.size(), i));
        int eachCount = list.size() / threadsNumber;
        int remainder = list.size() % threadsNumber;
    }

    public <T> void addTask(List<Stream<? extends T>> tasks, List<? extends T> list){
        int l, r = 0;
        for (int j = 0; j < threadsNumber; j++) {
            l = r;
            r += eachCount + (remainder-- > 0 ? 1 : 0);
            tasks.add(list.subList(l, r).stream());
        }
    }

    public <T, R> void addThreads(List<R> values, List<? extends T> list, Function<Stream<? extends T>, R> function, List<Thread> threads){
        for (int j = 0, l, r = 0; j < threadsNumber; j++) {
            l = r;
            r = l + eachCount + (remainder-- > 0 ? 1 : 0);
            int finalL = l;
            int finalR = r;
            int finalJ = j;
            var thread = new Thread(() -> values.set(finalJ, function.apply(list.subList(finalL, finalR).stream())));
            thread.start();
            threads.set(j, thread);
        }
    }

    private <T, R> R result(int i, List<? extends T> list, Function<Stream<? extends T>, R> function, Function<? super Stream<R>, R> resultFunc) throws InterruptedException {
        partition(i, list);
        List<R> values = new ArrayList<>(Collections.nCopies(threadsNumber, null));
        List<Thread> threadList = new ArrayList<>(Collections.nCopies(threadsNumber, null));
        if (parallelMapper != null) {
            var tasks = new ArrayList<Stream<? extends T>>();
            for (int j = 0, l, r = 0; j < threadsNumber; j++) {
                l = r;
                r = l + eachCount + (remainder-- > 0 ? 1 : 0);
                tasks.add(list.subList(l, r).stream());
            }
            values = parallelMapper.map(function, tasks);
        } else {
            addThreads(values, list, function, threadList);
        }
        return resultFunc.apply(values.stream());
    }

    @Override
    public <T> T maximum(int i, List<? extends T> list, Comparator<? super T> comparator) throws InterruptedException {
        Function<Stream<? extends T>, T> max = j -> j.max(comparator).orElse(null);
        return result(i, list, max, max);
    }

    @Override
    public <T> T minimum(int i, List<? extends T> list, Comparator<? super T> comparator) throws InterruptedException {
        Function<Stream<? extends T>, T> min = j -> j.min(comparator).orElse(null);
        return result(i, list, min, min);
    }

    @Override
    public <T> boolean all(int i, List<? extends T> list, Predicate<? super T> predicate) throws InterruptedException {
        return result(i, list, j -> j.allMatch(predicate), j -> j.allMatch(Predicate.isEqual(true)));
    }

    @Override
    public <T> boolean any(int i, List<? extends T> list, Predicate<? super T> predicate) throws InterruptedException {
        return result(i, list, j -> j.anyMatch(predicate), j -> j.anyMatch(Predicate.isEqual(true)));
    }

    @Override
    public String join(int i, List<?> list) throws InterruptedException {
        StringBuilder concat = new StringBuilder();
        map(i, list, Object::toString).forEach(concat::append);
        return concat.toString();
    }

    @Override
    public <T> List<T> filter(int i, List<? extends T> list, Predicate<? super T> predicate) throws InterruptedException {
        return result(i, list, j -> j.filter(predicate).collect(Collectors.toList()), j -> j.reduce(new ArrayList<>(), (k, l) -> {
            k.addAll(l);
            return k;
        }));
    }

    @Override
    public <T, U> List<U> map(int i, List<? extends T> list, Function<? super T, ? extends U> function) throws InterruptedException {
        return result(i, list, j -> j.map(function).collect(Collectors.toList()), j -> j.reduce(new ArrayList<>(), (k, l) -> {
            k.addAll(l);
            return k;
        }));
    }
}
