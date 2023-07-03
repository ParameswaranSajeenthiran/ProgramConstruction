package designPatterns.adpatee.uni;

public class AdapterTest {
    public static void main(String[] args) {
        PIRDistanceSensor pir=new PIRDistanceSensor();
        pir.getDistance();

    }
}

class PIR{ //adaptee
    private double vout;
    public PIR(){
        vout=2.0;
    }

    public double getVoltage(){
        return vout;
    }

}

interface DistanceSensor { //Target
    public double getDistance();


}

class PIRDistanceSensor implements DistanceSensor{  //adapter
    private PIR sensor;
    PIRDistanceSensor(){
        sensor=new PIR();
    }

    public  double getDistance (){
        double v= sensor.getVoltage();
        double d=0.0;
        d=12.34;
        return d;
    }


}


