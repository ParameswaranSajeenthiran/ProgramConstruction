package revisingDesignPatterns;

public class SmartCardTest {
}

interface SmartCard{
    public boolean authenticate ( String pin);

}
class SimpleSmartCard implements  SmartCard{
    public boolean authenticate( String pin  ){
        System.out.println(" Sending encrypted value [\"+pin+\"] to server to verify ");
        return true;
    }

}

abstract class SmartCardDecorator implements  SmartCard {
    private final SmartCard  smartCardToBeDecorated;

    public SmartCardDecorator ( SmartCard smartCardToBeDecorated){
        this.smartCardToBeDecorated=smartCardToBeDecorated;
    }
    public boolean authenticate( String pin  ) {
        //other operations .
        smartCardToBeDecorated.authenticate(pin);
        return true;
    }
}

class OPTSmartCard extends SmartCardDecorator {
    public OPTSmartCard (SmartCard smartCardToBeDecorated){
        super(smartCardToBeDecorated);

    }
    public boolean authenticate ( String id ){
        System.out.println("Sending ID [" + id +" ] to the server to get OPT");
        super.authenticate( "opt");
        return  true;// example

    };

}
