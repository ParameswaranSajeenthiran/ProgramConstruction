package  Concurrency;


public class DeadLockDemo{

    public static void main(String[] args) {

        BankAccount foo = new BankAccount(2000);
        BankAccount too = new BankAccount(4000);



        new Thread(){
            public  void run(){
                BankAccount.transfer(foo,too,200);
            }

        }.start();

       Thread t2= new Thread(){
            public void run(){
                BankAccount.transfer(too,foo,400.0);
            }
        };
       t2.start();
       try{
           t2.join();
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }


    };


}
class  BankAccount {
    private double balance ;
    private int id;

    public BankAccount (double amount ){
        this.balance=amount;
    }


    public void withdraw( double amount ){
        try {Thread.sleep(10l);} catch (InterruptedException e) {

        }

        System.out.println("withdraw" +Thread.currentThread().getName());
        if( balance<=amount){
            throw new InsufficientBalance("Insufficient Balance ");
        }
        balance-=amount;


    }

    public void deposit(double amount ){
        try {Thread.sleep(10l);} catch (InterruptedException e) {

        }
        System.out.println("deposit" +Thread.currentThread().getName());

        balance+=amount;

    }

    public static  void transfer ( BankAccount from ,BankAccount to ,double amount){
        System.out.println("transfer money " + Thread.currentThread().getName());
        synchronized (from){
            synchronized (to){
                from.withdraw(amount);

                to.deposit(amount);
            }

        }
    }



}


class InsufficientBalance extends RuntimeException{
    public  InsufficientBalance(String message){
        super(message);
    }
}