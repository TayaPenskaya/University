package ru.ifmo.rain.penskaya.concurrent;

import info.kgeorgiy.java.advanced.concurrent.ListIP;
import info.kgeorgiy.java.advanced.concurrent.ScalarIP;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IterativeParallelism implements ScalarIP, ListIP {

    private <T> List<Stream<? extends T>> partition(int i, List<? extends T> list){
        if(i <= 0) throw new IllegalArgumentException("Illegal threads number!");
        int threadsNumber = Math.max(1, Math.min(list.size(), i));
        int eachCount = list.size() / threadsNumber ;
        int remainder = list.size() % threadsNumber;
        int l, r  = 0;
        List<Stream<? extends T>> parts = new ArrayList<>();
        for (int j = 0; j < threadsNumber; j++){
            l = r;
            r += eachCount + (remainder-- > 0 ? 1 : 0);
            parts.add(list.subList(l, r).stream());
        }
        return parts;
    }

    @Override
    public String join(int i, List<?> list) throws InterruptedException {
        return null;
    }

    @Override
    public <T> List<T> filter(int i, List<? extends T> list, Predicate<? super T> predicate) throws InterruptedException {
        return null;
    }

    @Override
    public <T, U> List<U> map(int i, List<? extends T> list, Function<? super T, ? extends U> function) throws InterruptedException {
        return null;
    }

    private abstract class Worker<R> implements Runnable {
        private R result;
        void countResult(R result){
            this.result = result;
        }
        R getResult(){
            return result;
        }
    }

    private <T, R> R result(int i, List<? extends T> list, Function<Stream<? extends T>, R> function, Function<? super Stream<R>, R> resultFunc) throws InterruptedException {
        List<Stream<? extends T>> parts = partition(i, list);
        List<Thread> threads = new ArrayList<>();
        List<Worker<R>> workers = new ArrayList<>();
        for(Stream<? extends T> part : parts){
            Worker<R> worker = new Worker<>() {
                @Override
                public void run() {
                    countResult(function.apply(part));
                }
            };
            workers.add(worker);
            Thread thread = new Thread(worker);
            threads.add(thread);
            thread.start();
        }
        for(Thread thread : threads){
            thread.join();
        }
        return resultFunc.apply(workers.stream().map(Worker::getResult));
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
}
