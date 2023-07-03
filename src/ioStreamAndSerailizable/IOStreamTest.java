package ioStreamAndSerailizable;

import java.io.*;

public class IOStreamTest {
    public static void main(String[] args) {
        try{
            FileWriter writer =new FileWriter("Foo.txt");
            BufferedWriter bufferedWriter =new BufferedWriter(writer);
            bufferedWriter.write("testing file writer");
            bufferedWriter.close();
            writer.close();
            FileOutputStream fileOutputStream= new FileOutputStream( "MyGame.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            Weapon weapon= new Weapon("test weapon");
            Weapon[] weapons={weapon};
            GameCharacter character0=new GameCharacter( 3,"small",weapons);
            GameCharacter character1=new GameCharacter(4,"large",weapons);
            objectOutputStream.writeObject(character1);
            objectOutputStream.writeObject(character0);
            objectOutputStream.close();

            FileInputStream fileInputStream= new FileInputStream( "MyGame.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            GameCharacter elf=(GameCharacter) objectInputStream.readObject();
            System.out.println( elf.getPower() +" "+ elf.getType());
            GameCharacter troll = (GameCharacter)  objectInputStream.readObject();
            System.out.println(troll.getPower() + " " +troll.getType());

            objectOutputStream.close();

        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}


class GameCharacter  implements  Serializable{
    int power ;
    String type;

     transient Weapon[] weapons;


    public GameCharacter(int power, String type, Weapon[] weapons) {
        this.power = power;
        this.type = type;
        this.weapons = weapons;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapon[] weapons) {
        this.weapons = weapons;
    }
}
class Weapon {
    String name ;

    public Weapon(String name) {
        this.name = name;
    }
}