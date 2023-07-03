package designPatterns.structural.decorator.greekfic;

public class MessengerNotifier {
}

class DatabaseService{

}

interface  iNotifier{
    void send();
    String getUserName();
}

class Notifier {
    private final String username;
    private final DatabaseService databaseService;
    public Notifier(String username , DatabaseService databaseService){
        this.databaseService=databaseService;
        this.username=username;

    }

    public void send(String username){
        System.out.println("sending mail");
    }

    public String getUserName (){
        return  username;
    }


}

 abstract class BaseNorifierDecorator{
    private final Notifier wrapped;
    protected  final DatabaseService databaseService;

    BaseNorifierDecorator( Notifier wrapped){
        this.wrapped=wrapped;
        databaseService=new DatabaseService();
    }

    public  void send(String msg){
        wrapped.send(msg);
    }

}