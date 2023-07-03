package exceptionHandling;

public class ExceptionhandinlingTest {
    public static void main(String[] args) {
        try{
            Exceptio1 exceptio1 = new Exceptio1();

            exceptio1.handle(10,0);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("error");
        }
    }
}


class Exceptio1{
    public  int handle  (int a, int b) {
        try{
            return a/b;
        }finally {
            System.out.println("finally ");
        }
    }

}