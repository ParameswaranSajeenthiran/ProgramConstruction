package designPatterns.command.uni;
// example for non design pattern

 class Remote {
    private boolean buttonOn;
    private LightBulb lightBulb;
    private Television tv;


    public Remote (){
        buttonOn=false;
        lightBulb=null;
        tv=null;
    }


}


interface Device{
     public void on();
     public void off();

}

class Television implements  Device{
     public void on(){
         System.out.println("television On");
     }

     public  void off(){
         System.out.println("Television off");
     }

     public int  getStoredPreference(int param){
         System.out.println("retreiving parameters for "+param);
         return 1;
     }

     public void setChannel(int channel){

     }
     public  void setVolume(int volume){

     }
}

class LightBulb implements Device{
     public void on(){
         System.out.println("Light bulb on");
     }


    public void off() {
        System.out.println("Light bulb off");
    }
}


interface  Command {

     public  void execute();

}

class TVOnCommand implements  Command{

     Television tv;

     public  TVOnCommand(Television tv){
         this.tv=tv;

     }
     public  void execute (){
         tv.on();

     }
}

class TVofCommand implements  Command {
     private Television tv;


     public TVofCommand(Television tv) {
         this.tv = tv;
     }
     public void execute(){
         tv.off();
     }

}
