package pastPapers;

import java.util.ArrayList;
import java.util.List;

public class AutomationDemo {
    public static void main(String[] args) {
        LightSensor lightSensor = new LightSensor();
        lightSensor.registerObserver(new Light());
        lightSensor.registerObserver(new Window());
        lightSensor.setReadings(4);
        lightSensor.setReadings(1);

        lightSensor.setReadings(2);

        lightSensor.setReadings(10);


    }
}

abstract  class Observable {
    private List<Observer> observerList;

    public Observable (){
        observerList=new ArrayList<>();
    }
    public void registerObserver(Observer observer){
        observerList.add(observer);
    }

    public void unRegisterObserver(Observer observer ){
        observerList.remove(observer);
    }

    public void notifyObservers(){
        for (Observer observer : observerList) {
            observer.update(this);
        }

    }
}

class LightSensor extends  Observable{

    private  int readings;
    public  LightSensor (){
        super();
    }

    public int getReadings() {
        return readings;
    }

    public void setReadings(int readings) {

        this.readings = readings;
        notifyObservers();
    }
}


interface  Observer {
    public void update(Observable observable);
}

class TestThread extends  Thread{
    @Override
    public void run() {
        System.out.println("ran");
    }
}
class Light implements  Observer {

    @Override
    public void update(Observable observable) {

        new TestThread().start();
        if( observable instanceof  LightSensor){
           if (((LightSensor)observable).getReadings()<3){
               System.out.println("turning ON lights");
           }else{
               System.out.println("turing off lights");
           }
        }
    }
}


class Window implements  Observer {

    @Override
    public void update(Observable observable) {
        if( observable instanceof  LightSensor){
            if (((LightSensor)observable).getReadings()<3){
                System.out.println("opening shades");
            }else{
                System.out.println("closing shades");
            }
        }
    }
}