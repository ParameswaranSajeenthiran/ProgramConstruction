package Concurrency;

import java.util.LinkedList;

public class LiveLock {
    public static void main(String[] args) {
        LinkedList<Equation> queue = new
                LinkedList<LiveLock.Equation>();

        Thread t1 = new Thread(new Reader(queue),
                "Thread_1_P10");
        Thread t2 = new Thread(new Reader(queue),
                "Thread_2_P10");
        Thread t3 = new Thread(new Reader(queue),
                "Thread_3_P10");
        Thread t4 = new Thread(new Reader(queue),
                "Thread_4_P10");
        Thread t5 = new Thread(new Reader(queue),
                "Thread_5_P1");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        queue.add(new Equation(100,5));
        queue.add(new Equation(120,6));
        queue.add(new Equation(101,3));
        queue.add(new Equation(1024,62));
        queue.add(new Equation(1892090,53));
        queue.add(new Equation(72,8));
        queue.add(new Equation(198,0)); // Will cause
//        Divide by Zero ArithmeticException !!!
        queue.add(new Equation(123,23));
        queue.add(new Equation(98495,876));


    }

    private static class Reader implements Runnable {
        LinkedList<Equation> queue = null;

        public Reader(LinkedList<Equation> queue) {
            this.queue = queue;
        }

        public void run() {
            while (true) {
                synchronized (queue) {
                    System.out.format("%s Checking elements in the queue...\n", Thread.currentThread().getName());
                    try {
                        if (queue.size() > 0) {
                            Equation eq = queue.remove(0);
                            doWork(eq);
                            queue.wait(200);
                        }
                        Thread.sleep(1000);
                        queue.notifyAll();
                    } catch (InterruptedException e) {
                        System.out.format("%s was interrupted...\n",
                                Thread.currentThread().getName());
                        e.printStackTrace();
                    }
                }
            }
        }

        private void doWork(Equation eq) {
            double val = 0;

            try {
                val = (eq.getDividend() / eq.getDivisor());
                System.out.format("%s: Equation %d / %d = %f\n",
                        Thread.currentThread().getName(), eq.getDividend(),
                        eq.getDivisor(), val);
            } catch (ArithmeticException ex) {
                System.out.println("cannot divide by zero");
                //ex.printStackTrace();
                // Try to recover from error --- Incorrect Logic
                // put equation back into queue as the first
//                element
//                queue.addFirst(eq);
            }
        }
    }

    private static class Equation {
        private int dividend;
        private int divisor;

        public Equation(int dividend, int divisor) {
            setDividend(dividend);
            setDivisor(divisor);
        }
        public int getDividend() {
            return dividend;
        }
        public void setDividend(int dividend) {
            this.dividend = dividend;

        }
        public int getDivisor() {
            return divisor;
        }
        public void setDivisor(int divisor) {
            this.divisor = divisor;
        }
    }
}
