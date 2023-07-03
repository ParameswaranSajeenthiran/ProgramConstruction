package pastPapers;

import java.util.ArrayList;
import java.util.List;

public class AssemblyLineDemo {

    public static void main(String[] args) {
        StorageBin storageBin = new StorageBin(2);
        DropRobot dropRobot = new DropRobot(storageBin,1);
        PickRobot pickRobot = new PickRobot(storageBin ,2);
        dropRobot.start();
        pickRobot.start();
    }
}



class StorageBin{
    private int MAX_SIZE;
    private List<Product> contents = new ArrayList<>();

    public StorageBin (int size){
        this.MAX_SIZE=size;
    }

    public List<Product> getContents() {

        return contents;
    }

    public void setContents(List<Product> contents) {
        this.contents = contents;
    }

    public synchronized Product get (){
        while (contents.size()==0){

           try{
               wait();

           }catch (InterruptedException e){
               e.printStackTrace();
           }
        }
        Product product=  contents.get(contents.size()-1);
        contents.remove(contents.size()-1);
        notify();
        return product ;
    }
    public synchronized void put( Product newProduct){
        while ( contents.size()==MAX_SIZE){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        contents.add(newProduct);
        notify();

    }

}

class PickRobot extends  Thread{
    private StorageBin storageBin;
    private int id;

    public PickRobot ( StorageBin storageBin, int id){
        this.storageBin=storageBin;this.id=id;
    }
    public void run (){
        while(true){
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            pick();
        }

    }

    public void pick(){
         Product product= storageBin.get();
        System.out.println("pick robot "+id +"got "+storageBin.getContents().size());

    }


}

class DropRobot extends  Thread{
    private StorageBin storageBin;
    private int id ;

    private int count ;

    public DropRobot ( StorageBin storageBin ,int id){
        this.storageBin=storageBin;this.id=id;this.count=0;
    }

    public void run(){
        while(true){
            drop();
        }

    }
    public void drop(){
        storageBin.put(new Product( count++));
        System.out.println("drop robot dropped "+ storageBin.getContents().size());

    }
}
class Product {
    private int id;

    public Product(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}