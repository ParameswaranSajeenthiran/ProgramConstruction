package Concurrency.uni;

public class CubbyHoleTest {

    public static void main(String[] args) {
        CubbyHole cubbyHole =new CubbyHole();
        Producer producer0=new Producer(cubbyHole,0);
//        Producer producer1=new Producer(cubbyHole,1);
        Consumer consumer0=new Consumer(cubbyHole,0);
//        Consumer consumer1=new Consumer(cubbyHole,1);

        producer0.start();
//        producer1.start();
        consumer0.start();
//        consumer1.start();

    }

}

class CubbyHole {
    private int contents;
    private boolean available = false;
    public synchronized int get(int id) {
        while(available == false) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }

                    System.out.println("Consumer #" +id
                    + " got: " + contents);

        available = false;
        notifyAll();
        return contents;
    }
    public synchronized void put(int value, int id) {
        while (available == true) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        System.out.println("Producer #" + id + " put: " + value);

        contents = value;
        available = true;
        notifyAll();
    }}
class Producer extends Thread {
    private CubbyHole cubbyhole;
    private int number;
    public Producer(CubbyHole c, int number) {
        cubbyhole = c;
        this.number = number;
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
            cubbyhole.put(i,this.number);
//            System.out.println("Producer #" + this.number + " put: " + i);
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) { }
        }}}
class Consumer extends Thread {
    private CubbyHole cubbyhole;
    private int number;
    public Consumer(CubbyHole c, int number) {
        cubbyhole = c;
        this.number = number;
    }
    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            value = cubbyhole.get(this.number);
//            System.out.println("Consumer #" + this.number
//                    + " got: " + value);
        }
    }
}