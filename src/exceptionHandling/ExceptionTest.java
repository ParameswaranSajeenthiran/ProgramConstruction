package exceptionHandling;

public class ExceptionTest {
    public static void main(String[] args) throws  BalanceExceedExpection {
        int amount =300;
        int balance =200;
        try{
            System.out.println("j");
            if( amount>balance)throw new BalanceExceedExpection("insuffeicient balance");
        } catch (BalanceExceedExpection e) {
//            throw new RuntimeException(e);
        } finally {
            System.out.println("finally");
        }

        balance=balance-amount;
        System.out.println("balance "+ balance);
    }
}


class BalanceExceedExpection extends  Exception{
    BalanceExceedExpection(){

    };

    public  BalanceExceedExpection(String message ){
        super(message);
    }
}
