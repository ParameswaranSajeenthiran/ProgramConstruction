package OOP;

import java.util.*;



public class Casting{
    public int test;
    public  Casting(int i ){
        this.test=i;
    }


    public static void main(String[] args) {
       Dog dog= new Dog("name");

        System.out.println(dog.getName());
        Hashtable<String ,Dog> hashtable =new Hashtable();
        Map<String ,Dog >map= new HashMap<>(hashtable);
        map.put("test", new Dog("ff"));
        System.out.println(map);










    }



}

class  Monster extends Casting {

    public Monster(int i) {
        super(i);
    }
}

class Animal {
    protected String name;
    public Animal( String name){
    this.name=name;
    }
    public String  getName(){
        return this.name;
    }

    public static void sleep(){
        System.out.println("sleeoing ");
    }
}

class Dog extends  Animal{

    public Dog(String name) {
        super(name);
    }

    public static void sleep(){
        System.out.println("static method");
    }
    public void bark(){
        System.out.println("bark");
    }





}