package Concurrency.uni;



public class SynchronizedStatementExample {
    private int criticalCounter = 0;
    private int nonCriticalCounter = 0;

    public static void main(String[] args) {
        SynchronizedStatementExample example = new SynchronizedStatementExample();

        Thread thread1 = new IncrementThread(example);
        Thread thread2 = new IncrementThread(example);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Critical Counter Value: " + example.getCriticalCounter());
        System.out.println("Final Non Critical Counter Value: " + example.getNonCriticalCounter());
    }

    public int getCriticalCounter() {
        return criticalCounter;
    }

    public int getNonCriticalCounter() {
        return nonCriticalCounter;
    }

    public void incrementCounters() {

        synchronized (this) {
            criticalCounter++;
        }

        nonCriticalCounter++;
        System.out.println("Critical Counter: " + criticalCounter);
        System.out.println("Non-Critical Counter: " + nonCriticalCounter);
    }

    static class IncrementThread extends Thread {
        private SynchronizedStatementExample example;

        public IncrementThread(SynchronizedStatementExample example) {
            this.example = example;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                example.incrementCounters();
            }
        }
    }
}
