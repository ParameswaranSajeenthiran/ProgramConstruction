package revisingConcurrency;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        CubbyHole c = new CubbyHole();
        Producer p1 = new Producer(c, 1);
        Consumer c1 = new Consumer(c, 1);
        p1.start();
        c1.start();
    } }

    class CubbyHole {
        private int content;
        private boolean available ;

        public synchronized void put ( int value ){
            while ( available == true ){
                try {
                    wait();
                } catch (InterruptedException e) { throw new RuntimeException(e);
                }
            }
//            System.out.printf(" putting value = %d", value);

            content= value ;
            available =true;
            notifyAll();
        }

        public synchronized  int  get ( ){
            while ( available == false){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            available=false ;
            notifyAll();
            return content;
        }

    }

    class Producer extends  Thread {


        private int id;
        private CubbyHole cubbyHole;
        public Producer ( CubbyHole cubbyHole , int id){
            this.id=id;
            this.cubbyHole=cubbyHole;
        }
        public void run ( ){
            for ( int i =0 ; i < 10; i++){
                System.out.printf("producer # %d is putting content %d \n", id , i );
                cubbyHole.put(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class Consumer extends Thread {
        private int id;
        private CubbyHole cubbyHole;

        public Consumer(CubbyHole cubbyHole, int id) {
            this.id = id;
            this.cubbyHole = cubbyHole;
        }

        public void run() {
            int value = 0;
            for (int i = 0; i < 10; i++) {
                value = cubbyHole.get();
                System.out.println("Consumer #" + this.id
                        + " got: " + value ) ;

            }

        }

}
