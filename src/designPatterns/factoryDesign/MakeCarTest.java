package designPatterns.factoryDesign;

public class MakeCarTest {

    public static void main(String[] args) {
        String type= "car";
        if(type=="car"){
            CarABSSensor car= new CarABSSensor();
        }else if(type=="truck"){
            TruckABSSensor truckABSSensor= new TruckABSSensor();
        }




//        CarABSController carabsc = new CarABSController();
//        carabsc.install();
//        TruckABSController truckabsc = new TruckABSController();
//        truckabsc.install();


    }
}





 interface  ABSSensor{
    void install() ;




}
 class CarABSSensor implements ABSSensor {


    public void install() {
        System.out.println("");
    }
}

class TruckABSSensor implements ABSSensor{
    public void install() {
        System.out.println("");
    }
}


//abstract  class  ABSSensorFactory{
//
//    void unPack(){
//        System.out.println("un packing compoenents");
//    }
//
//    abstract  void makeABSSensor();
//    void install(){
//        System.out.println("installing sensor");
//        unPack();
//        makeABSSensor();
//
//    }
//
//
//
//}


//class TruckABSSensorFactory extends   ABSSensorFactory{
//
//    @Override
//    void makeABSSensor() {
//        System.out.println("making truck ABSSensor");
//    }
//}
//
//class CarABSSensorFactory extends ABSSensorFactory{
//
//    @Override
//    void makeABSSensor() {
//        System.out.println("making car ABSensor");
//    }
//
//
//}

abstract class ABSController {
    private ABSSensor abss;
    // Factory Method
    public abstract ABSSensor makeABSSensor();
    public void log(String s) { System.out.println(s); }
    public void install() {
        log("Making an ABS Controller");
        abss = makeABSSensor();
        abss.install();
    }
}

class CarABSController extends ABSController {
    public ABSSensor makeABSSensor() {
        System.out.println("Making a Car ABS Sensor");
        return new CarABSSensor();
    }
}
class TruckABSController extends ABSController {
    public ABSSensor makeABSSensor() {
        log("Making a Truck ABS Sensor");
        return new TruckABSSensor(); }
}
