package designPatterns.decorator.uni;

public class SamrtCarTest {
    public static void main(String[] args) {
        SimpleSmartCard simpleSmartCard =new SimpleSmartCard();
        OTPSmartCard otpSmartCard = new OTPSmartCard(simpleSmartCard);
        otpSmartCard.authenticate();
    }
}


interface SmartCard{

    public boolean authenticate();
}

class SimpleSmartCard implements  SmartCard{


    @Override
    public boolean authenticate() {
        System.out.println("simple authentication");
        return false;
    }


}

abstract class SmartCardDecorator implements SmartCard{
    private SmartCard smartCardToBeDecorated;
    public SmartCardDecorator (SmartCard smartCardToBeDecorated){
        this.smartCardToBeDecorated=smartCardToBeDecorated;
    }

    @Override
    public boolean authenticate() {
        smartCardToBeDecorated.authenticate();
        return true;
    }
}

class OTPSmartCard extends SmartCardDecorator{



    public OTPSmartCard(SmartCard smartCardToBeDecorated) {
        super(smartCardToBeDecorated);
    }

    public boolean authenticate(){        super.authenticate();
        System.out.println("OTP request sent");
        return true;

    };
}