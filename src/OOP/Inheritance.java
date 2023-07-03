package OOP;

public class Inheritance {
    public static void main(String[] args) {
        Child parent = new Child();
        ;
    }
}

class Parent{
    int id;
    int name ;

    public  void get(){
        System.out.println("get method parent");
    }
    public void test(){
        System.out.println("printing parent");

    }
}

class Child  extends Parent{
    public void test(){
        System.out.println("printing child");
    }


    public  void get() {
        System.out.println("get in child ");
    }
}