package designPatterns.structural.decorator.uni;

public class SmartCardTest {
}

interface SmartCard{
    public boolean authenticate(String pin);


}

class SimpleSmartCard implements SmartCard{



    public boolean authenticate(String pin) {
        System.out.println("sedning encrypted value [ "+pin+"] to server to verify");
        return  true;
    }
}

abstract class SmartCardDecorator implements SmartCard{
    private  final SmartCard smartCardTobeDecorated;

    public SmartCardDecorator (SmartCard smartCardTobeDecorated){
        this.smartCardTobeDecorated=smartCardTobeDecorated;
    }


    @Override
    public boolean authenticate(String pin) {

        smartCardTobeDecorated.authenticate(pin);
        return true;
    }


}

class OPTSmartCardDecorator extends  SmartCardDecorator{
    public OPTSmartCardDecorator(SmartCardDecorator smartCardDecorator){
        super(smartCardDecorator);
    }

    public boolean authenticate(String id){
        System.out.println("sending ID ["+id+"] to server t get the opt to moblie ");
        super.authenticate("opt at mobile of the ID "+id);
        return true;
    }
}

class TFASmartCardDecorator extends SmartCardDecorator{

    public TFASmartCardDecorator(SmartCardDecorator smartCardDecorator){
        super(smartCardDecorator);
    }

    public  boolean authenticate(String id){
        System.out.println("sending ID ["+id+"] to server get the TFA to moblie ");
        super.authenticate(id);
        return true;
    }


}