package designPatterns.abstractFactory.uni;

public class AbstractFactory {

    public static void main(String[] args) {
        Company asusGPUfactory=new Asus();
        asusGPUfactory.createGpu();

        Company msiFactory =new MSI();
        msiFactory.createGpu();


    }
}
interface GPU{


}

class ASUSGpu implements GPU{

}


class MSISpu implements  GPU{

}

abstract class  Company{

    // other business logic
     abstract void createGpu();
     abstract  void createMonitor();

}

class Asus extends  Company{


    void createGpu() {
        System.out.println("creating asus gpu");

    }

    @Override
    void createMonitor() {

    }


}

class MSI extends Company {
    void createGpu() {
        System.out.println("creating msi gpu");

    }

    @Override
    void createMonitor() {

    }
}

