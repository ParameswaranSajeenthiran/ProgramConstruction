package Concurrency.uni;


import java.util.concurrent.atomic.AtomicInteger;

public class MemoryInconsistencyExample {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread thread1 = new IncrementThread();
        Thread thread2 = new ReadThread();

        thread1.start();
        thread2.start();
    }

    static class IncrementThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                synchronized (counter) {
                    counter.getAndIncrement();
                }
            }
        }
    }

    static class ReadThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                synchronized (counter) {
                    if (counter.get() % 2 == 1) {
                        System.out.println("Counter is odd: " + counter);
                    }
                }
            }
        }
    }
}