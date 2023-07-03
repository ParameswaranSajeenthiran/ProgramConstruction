package designPatterns.bulider.grecfic;

public class BuilderTest {
    public static void main(String[] args) {
        CarBuilder bugartiCarBuilder=new BugartiCarBuilder();
        Director director=new Director(bugartiCarBuilder);
          director.construct();


//
//         Car bugartiCar1= carBuilder.build();
//        carBuilder.setColor("blue").setEngineModel("model").setId(2).setWeight("3kg").setModel("bugarti");
//        Car bugartiCar2= carBuilder.build();
//        carBuilder.setColor("black").setEngineModel("model").setId(2).setWeight("3kg").setModel("lambogini");
//        Car lamb1= carBuilder.build();
//        carBuilder.setColor("red").setEngineModel("model").setId(2).setWeight("3kg").setModel("lambogini");
//        Car lamb2= carBuilder.build();
//        carBuilder.setColor("yellow").setEngineModel("model").setId(2).setWeight("3kg").setModel("lambogini");
//        Car lamb3= carBuilder.build();

//        System.out.println(bugartiCar1.toString() + bugartiCar2.toString()+lamb3.toString());



    }

}


class Car{
    String model;
    private static int count =0;

    int id;
    String engineModel;
    boolean FrontWheelOrBackWheelDriven;
    String weight;
    String color;

    public Car( String model, int id, String engineModel ){
        
    }

    public Car(String model, int id, String engineModel, boolean frontWheelOrBackWheelDriven, String weight, String color) {
        this.model = model;
        this.id = id;
        this.engineModel = engineModel;
        FrontWheelOrBackWheelDriven = frontWheelOrBackWheelDriven;
        this.weight = weight;
        this.color = color;
        count++;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", id=" + id +
                ", engineModel='" + engineModel + '\'' +
                ", FrontWheelOrBackWheelDriven=" + FrontWheelOrBackWheelDriven +
                ", weight='" + weight + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

class BugartiCarBuilder implements  CarBuilder {

    String model;
    private static int count =0;


    int id;
    String engineModel;
    boolean frontWheelOrBackWheelDriven;
    String weight;
    String color;

    public BugartiCarBuilder(){
        count++;
    }


    public CarBuilder setId() {
        this.id = count;
        return this;
    }

    @Override
    public CarBuilder setId(int id) {
        return null;
    }

    public CarBuilder setModel(String model) {
        this.model = model;
        return this;

    }

    public CarBuilder setEngineModel(String engineModel) {
        this.engineModel = engineModel;
        return this;

    }

    public CarBuilder setFrontWheelOrBackWheelDriven(boolean frontWheelOrBackWheelDriven) {
        this.frontWheelOrBackWheelDriven = frontWheelOrBackWheelDriven;
        return this;

    }

    public CarBuilder setWeight(String weight) {
        this.weight = weight;
        return this;

    }

    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public Car build() {
        return new Car(model, id, engineModel, frontWheelOrBackWheelDriven, weight, color);


    }

}
class Director{
    private CarBuilder builder;

    public Director(CarBuilder builder) {
        this.builder = builder;
    }


    public  Car construct(){
        return builder.build();
    }

    public void buildBugarti( CarBuilder builder, String color){
        builder.setColor(color).setEngineModel("model").setId(2).setWeight("3kg").setModel("bugarti");

    }

    public void buildLambogini( CarBuilder builder, String color){
        builder.setColor(color).setEngineModel("model").setId(2).setWeight("3kg").setModel("bugarti");

    }
}

interface CarBuilder {
    CarBuilder setId(int id);
    CarBuilder setModel(String model);
    CarBuilder setEngineModel(String engineModel);
    CarBuilder setFrontWheelOrBackWheelDriven(boolean frontWheelOrBackWheelDriven);
    CarBuilder setWeight(String weight);
    CarBuilder setColor(String color);
    Car build();
}

