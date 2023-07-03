package revisingSerializationAndIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationTest {

    public static void main(String[] args) {
        try{
            ObjectOutputStream outputStream = new ObjectOutputStream( new FileOutputStream("student.ser"));
            Student student= new Student(0, "Sajeenthiran");

            outputStream.writeObject(student);
            outputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("student.ser"));
            Student student1= (Student)  objectInputStream.readObject();

            System.out.println("student "+ student1.getName());
            student1.test.forEach(i-> System.out.println(i.id));
        }catch (IOException e ){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }


}


class Student implements Serializable {
     private int id;

     public List<Weapon> test =new ArrayList<>();
     private String name ;

    public Student ( int id ,String name ){
        this.id=id;
        this.name=name ;
        test.add(new Weapon(9));
        test.add(new Weapon(22));


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Weapon implements  Serializable{

    public int id;
    public  Weapon ( int id ){
        this.id=id;
    }
}