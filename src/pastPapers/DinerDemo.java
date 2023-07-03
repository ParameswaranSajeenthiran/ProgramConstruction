package pastPapers;

public class DinerDemo {
    public static void main(String[] args) {
        Chopstick chopstick1=new Chopstick();
        Chopstick chopstick2= new Chopstick();
        Diner ying= new Diner("ying",chopstick1,chopstick2);
        Diner yang = new Diner( "yang",chopstick2,chopstick1);
        ying.start();
        yang.start();

    }
}



class Diner extends Thread {
    private  String name;
    private Chopstick left,right;

    Diner (String name, Chopstick left ,Chopstick right){
        this.name=name;this.left=left;this.right=right;
    }
    public void eat(){

        if( left.pick(name,"left")){
            if(right.pick(name, "right")){
                for ( int i=0; i<10;i++){
                    System.out.println(name +" is eating ");
                }

            }
//            else{
////                left.drop(name,"left");
//            }
        }

      }



    public void run() {
        while(true){
            eat();
        }
    }
}

class Chopstick {
    private boolean picked;


    Chopstick (){
        picked=false ;
    }
    public synchronized void drop(String name , String id){
        System.out.println(name +" droped chopStick "+ id  );
        picked=false;


    }

    public synchronized boolean pick(String name ,String id){
        if( picked==true){

            return false;
        }
        System.out.println(name +" pinked up chopStick "+ id  );

        picked=true;
        return  true;
    }

}



