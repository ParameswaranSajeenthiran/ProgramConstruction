package designPatterns.observer.derek;

import java.util.ArrayList;
import java.util.List;

public class  ObserverTest{


        public static void main(String[] args) throws InterruptedException {
                Subject subject= new Subject();
                Observer observer0 =new Observer(subject);
                Observer observer1 =new Observer(subject);
                Observer observer2 =new Observer(subject);
                Observer observer3 =new Observer(subject);

                subject.setApplePrice(10.00);
                Thread.sleep(1000);
                subject.setGooglePrice(33.00);
        }






}


class Subject {
        private List<Observer> observers=new ArrayList<>();
        private double applePrice ;
        private double imbPrice ;

        private double googlePrice;

        public Subject(){
                this.applePrice=220.0;
                this.googlePrice=400.0;
                this.imbPrice=22.00;
        }


        public double getApplePrice() {
                return applePrice;
        }

        public void setApplePrice(double applePrice) {
                this.applePrice = applePrice;
                update();
        }

        public double getImbPrice() {
                return imbPrice;
        }

        public void setImbPrice(double imbPrice) {
                this.imbPrice = imbPrice;
                update();

        }

        public double getGooglePrice() {
                return googlePrice;
        }

        public void setGooglePrice(double googlePrice) {
                this.googlePrice = googlePrice;
                update();

        }

        public void subscribe(Observer observer){
                observers.add(observer);
        }

        public void update (){
                observers.forEach(observer -> observer.update()
                );
        }


}

class Observer {

        private int  id;
        private  static  int observerTracker=0 ;

        private Subject subject;

        public Observer ( Subject subject  ){
                this.subject=subject;
                subject.subscribe(this);
                this.id =observerTracker;
                observerTracker++;


        }

        public void update( ){
                System.out.println(" Updating observer # " + "with ibm = "+ subject.getImbPrice() + " google = " +subject.getGooglePrice() + " apple = "+ subject.getApplePrice()    );

        }


}