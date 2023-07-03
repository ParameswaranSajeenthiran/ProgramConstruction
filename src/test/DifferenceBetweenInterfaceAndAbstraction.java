package test;


interface Animal{
     void sound();

     default void walk() {
        System.out.println(" animal walking");

    }
}
class Dog implements  Animal{


    public void sound() {
        System.out.println("Dog barking ");

    }
    public void walk(){
        System.out.println("Dog walking");
    }
}
public class DifferenceBetweenInterfaceAndAbstraction {
    public static void main(String[] args) {
        Animal dog =new Dog();
        dog.sound();
        dog.walk();

    }

}
