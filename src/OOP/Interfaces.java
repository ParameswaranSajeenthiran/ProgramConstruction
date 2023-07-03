package OOP;

public class Interfaces {
    public static void main(String[] args) {
        Test testChild = new Student();
        testChild.run();
    }

}

interface  Test{
     default void run(){
        System.out.println("running run method");

    }

    static void test(){
        System.out.println("running test");

    }

//    public void impl();

}
interface TestChild extends  Test {

}

class Student implements  Test{

}