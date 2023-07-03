package revisingDesignPatterns;

import java.util.ArrayList;
import java.util.List;

public class StockGrabberDemo {
}


class Observer {
    private int id ;

    public Observer (int id ){
        this.id=id;

    }
    public void  update( double googlePrice ,double ibmPRice ,double applePrice){
        System.out.println("updating prices to observer id :"+ "google price :"+ googlePrice + "applePrice :"+ applePrice + "ibmPrice :"+ ibmPRice);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class StockGrabber {
    private List<Observer> observers= new ArrayList<>();
    private double applePrice ;
    private double imbPrice;
    private double googlePrice ;
    private  static int  observerIdTracker;


    public StockGrabber(){
        observerIdTracker=0;


    }

    public  void registerObservers(Observer observer){
        observer.setId(observerIdTracker);
        observerIdTracker++;

        observers.add(observer);

    }

    public void  update( double googlePrice ,double ibmPRice ,double applePrice){
        observers.forEach(observer -> {
            observer.update(googlePrice,ibmPRice,applePrice);
        });
    }

    public double getApplePrice() {

        return applePrice;
    }

    public void setApplePrice(double applePrice) {
        update(googlePrice,imbPrice,applePrice);
        this.applePrice = applePrice;
    }

    public double getImbPrice() {
        return imbPrice;
    }

    public void setImbPrice(double imbPrice) {
        update(googlePrice,imbPrice,applePrice);

        this.imbPrice = imbPrice;
    }

    public double getGooglePrice() {
        return googlePrice;
    }

    public void setGooglePrice(double googlePrice) {
        this.googlePrice = googlePrice;
    }
}