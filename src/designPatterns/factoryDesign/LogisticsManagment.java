package designPatterns.factoryDesign;

public class LogisticsManagment {
    public static void main(String[] args) {

        String type="truck";
        if(type=="truck"){
            Mode truck = new Truck();

        }else if( type=="Ship"){
            Mode ship = new Ship();
        }
        else if( type=="airBus"){
            Mode airBus= new AirBus();
        }
    }
}

class Mode {

}

class Truck extends Mode {

}
class Ship extends  Mode{

}

class AirBus extends  Mode{

}

abstract class Logistics{

}