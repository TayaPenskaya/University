package ru.ifmo.rain.penskaya.mapper;

import info.kgeorgiy.java.advanced.mapper.ParallelMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

public class ParallelMapperImpl implements ParallelMapper {
    ReentrantLock locker;
    Condition queueNotEmpty;
    Condition queueNotFull;
    int threadsNumber;
    LinkedList<Runnable> queue;
    ArrayList<Thread> threadsList;

    public ParallelMapperImpl(int threads) throws InterruptedException {
        threadsNumber = threads;
        locker = new ReentrantLock();
        queueNotEmpty = locker.newCondition();
        queueNotFull = locker.newCondition();
        queue = new LinkedList();
        threadsList = new ArrayList<>(Collections.nCopies(threadsNumber, null));
        work();
    }

    public <T, R> void addTask(Function<? super T, ? extends R> function, int index, T arg, CountDownLatch count, List<R> res) throws InterruptedException {
        locker.lock();
        try {
            while (queue.size() == 100000) {
                queueNotFull.await();
            }
            queue.add(() -> {
                R re = function.apply(arg);
                locker.lock();

                res.set(index, re);
                locker.unlock();
                count.countDown();
            });
            queueNotEmpty.signalAll();
        } finally {
            locker.unlock();
        }
    }

    public void work() {
        for (var i = 0; i < threadsNumber; ++i) {
            Thread thread = new Thread(() -> {
                while (!Thread.interrupted()) {
                    Runnable task;
                    try {
                        locker.lock();
                        while (queue.isEmpty()) {
                            try {
                                queueNotEmpty.await();
                            } catch (InterruptedException e) {
                                return;
                            }
                        }
                        task = queue.poll();
                        queueNotFull.signalAll();
                    } finally {
                        locker.unlock();
                    }
                    task.run();
                }
            });
            thread.start();
            threadsList.set(i, thread);
        }
    }

    @Override
    public <T, R> List<R> map(Function<? super T, ? extends R> function, List<? extends T> list) throws InterruptedException {
        List<R> results = new ArrayList<>(Collections.nCopies(list.size(), null));
        CountDownLatch count = new CountDownLatch(list.size());
        for (var i = 0; i < list.size(); ++i) {
            addTask(function, i, list.get(i), count, results);
        }
        count.await();
        return results;
    }

    @Override
    public void close() {
        for (Thread thread : threadsList) {
            thread.interrupt();
        }
        for (Thread thread : threadsList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
    }
}
