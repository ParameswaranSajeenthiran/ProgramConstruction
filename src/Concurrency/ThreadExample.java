package Concurrency;

import java.util.concurrent.atomic.AtomicInteger;
public class ThreadExample {
    private static Object mutex = new Object();
    private static volatile boolean isActive = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(), "Thread_1_P10");
        Thread t2 = new Thread(new Worker(), "Thread_2_P8");

        // Priorities only serve as hints to scheduler, it is
//        up to OS implementation to decide
        t1.setPriority(10);
        t2.setPriority(2);

        t1.start();
        t2.start();

        // Make the Main Thread sleep for 5 seconds
        // then set isActive to false to stop all threads
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isActive = false;

    }

    private static class Worker implements Runnable {
//        Page 1
//        starvation
        private AtomicInteger runCount = new AtomicInteger();

        public void run() {
            // tight loop using volatile variable as active
//            flag for proper shutdown
            while (isActive) {
                synchronized (mutex) {
                    try {
                        doWork();
                    } catch (Exception e) {
                        System.out.format("%s was interrupted...\n",
                                Thread.currentThread().getName());
                        e.printStackTrace();
                    }
                }
            }
            System.out.format("DONE===> %s: Current runCount is %d...\n", Thread.currentThread().getName(),
            runCount.get());
        }

        private void doWork() {
            System.out.format("%s: Current runCount is %d...\n", Thread.currentThread().getName(),
            runCount.getAndIncrement());
        }
    }
}