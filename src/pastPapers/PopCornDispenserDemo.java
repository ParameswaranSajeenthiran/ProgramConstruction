package pastPapers;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopCornDispenserDemo {

    public static void main(String[] args) {
        OutPutBin outPutBin = new OutPutBin();
        Cooker cooker = new Cooker(outPutBin, "1");
        Cooker cooker1 = new Cooker( outPutBin ,"2");
        RobotArm robotArm = new RobotArm(outPutBin ,"1");
        RobotArm robotArm1 = new RobotArm(outPutBin , "2");
        new Thread( cooker1).start();
        new Thread(cooker).start();
        new Thread(robotArm).start();
        new Thread(robotArm1).start();
    }
}



class Bag{
    private String  id;

    public Bag(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }
}



class OutPutBin {
    private static final int MAX=10;


    private Queue<Bag> bags= new LinkedList<>();

    public synchronized void put (Bag bag){
        while (bags.size()==MAX){
            try {
                wait();
            }catch (InterruptedException e){

            }

        }
        bags.add(bag);
        notifyAll();

    }

    public synchronized Bag get(){
        while (bags.size()==0){
            try{
                wait();
            }catch (InterruptedException e){

            }
        }

        Bag bag = bags.poll();
//        bags.remove(bags.size()-1);
        notify();
        return bag;

    }


}

class RobotArm implements Runnable {
    private OutPutBin outPutBin ;
    private String id ;


    public RobotArm ( OutPutBin outPutBin , String id ){
        this.outPutBin = outPutBin; this.id =id;
    }

    public void run() {

        while(true){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){

            }
            Bag bag=  outPutBin.get();
            System.out.println("robot arm "+ id +" got bag "+bag.getId());
        }

    }
}
class Cooker implements   Runnable {
    private OutPutBin outPutBin;
    private  String id;

    private int count ;





    public Cooker( OutPutBin outPutBin ,String id ){
        this.id=id;this.outPutBin=outPutBin;
    }

    public void run(){

        while(true){

            Bag bag = new Bag(id+"_"+count );
             outPutBin.put(bag);
             count++;
            System.out.println("cooker "+ id + "put bag with id "+ bag.getId());

            try {
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}