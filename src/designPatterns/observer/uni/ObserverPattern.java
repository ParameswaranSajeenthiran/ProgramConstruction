package designPatterns.observer.uni;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class ObserverPattern {

    public static void main(String[] args) {
        ImageProcessor imgImageProcessor=new ImageProcessor();
        int cameraCount=5;
        Camera [] cameras= new Camera[cameraCount];
        for (int i=0;i<cameraCount;i++)
            cameras[i]=new Camera(("CAM"+i));
        for (int i =0;i<cameraCount ;i++)
            imgImageProcessor.addObserver(cameras[i]);
        for (int i =0;i<cameraCount ;i++)
            cameras[i].start();
        for (int i=0;i<10;i ++){
            imgImageProcessor.process();
        }


    }
}




class Image {
    private String metadata;

    public Image(String metadata){
        this.metadata=metadata;
    }

    public void show(){
        System.out.println(metadata);
    }

}
class Camera extends Thread implements Observer{

    private String id;
    private int seqNo;

    public Camera(String id){
        this.id=id; seqNo=0;
    }



    public void update(Observable obs, Object arg) {
        System.out.println("updating obs");
        if(((ImageProcessor)obs).capture()){
            seqNo++;
            ((ImageProcessor) obs).load(new Image(id +" "+seqNo));
            ((ImageProcessor)obs).release();
        }


    }

    public void run(){


    }
}



class ImageProcessor extends   Observable{

    private Random random;
    private boolean available;

    public ImageProcessor(){
        this.random=new Random();
        available =true;
    }

    public void load(Image img){
        img.show();
        System.out.println("#");
    }

    public  void process(){
        if(random.nextInt(10)<5){
            setChanged();
            notifyObservers();
        }
    }

    public  synchronized  boolean capture(){
        if(available) {
            available = false;
            return true;
        }else{
            return  false;
        }
    }

    public void release(){
        if(!available){
            available=true;
        }else{
            System.out.println("fatal error");
        }
    }




}
