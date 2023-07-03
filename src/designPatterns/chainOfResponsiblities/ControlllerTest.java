package designPatterns.chainOfResponsiblities;

public class ControlllerTest {
    public static void main (String [] args){
        Controller controller =new Controller();
        controller.control(50);
        controller .control(10);
        controller.control(400);

    }
}




class Controller {
    private BoilingController boilingController;
    private LiquidController  liquidCOntroller;

    private FreezingController freezingController ;

    public Controller (){
        boilingController=new BoilingController(null);
        liquidCOntroller =new LiquidController(boilingController);

        freezingController =new FreezingController(liquidCOntroller);
    }

    public  boolean control (  double t){
        return freezingController.control(t);

    }




}
abstract  class TemperatureController {
    private TemperatureController next;
     public TemperatureController( TemperatureController next ){
         this.next =next ;

     }

    public TemperatureController getNext() {
        return next;
    }

    abstract public boolean control(double t);

}

class FreezingController extends  TemperatureController {
    public FreezingController (  TemperatureController next){
        super(next);
    }

    public boolean control(double t) {
        System.out.println("control of freezing ");
        if(t<=0){
            System.out.println("Handling freezing conditions");
            return true;
        }
        else if (getNext()==null){
            return false ;
        }
        else {
            return getNext().control(t);
        }

    }
}

class  BoilingController extends  TemperatureController {
    public BoilingController (TemperatureController next ){
        super(next);
    }

    public boolean control(double t) {
        System.out.println("controll of boiling");
       if(t>=100){
           System.out.println("Handling boiling conditions ");
           return  true;
       }
       else if(getNext()==null)
           return false;
       else
           return  getNext().control(t);
    }
}

class LiquidController extends  TemperatureController{
    public LiquidController( TemperatureController next){
        super(next);

    }

    public boolean control (double t){
        System.out.println("control of liquid ");
        if((t<100) && (t>0)){
            System.out.println("handling Liquid conditions ");
            return true;
        }
        else if(getNext()==null)
            return  false ;
        else
            return  getNext().control(t);




    }


}
