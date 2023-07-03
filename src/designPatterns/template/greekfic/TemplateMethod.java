package designPatterns.template.greekfic;

import java.util.ArrayList;
import java.util.List;

public class TemplateMethod {

    public static void main(String[] args) {
        BaseGameLoader game1=new Game1Loader();
        BaseGameLoader game2=new GamesLoader2();

        List<BaseGameLoader> baseGameLoaders=new ArrayList<>();

        game1.load();
        game2.load();




    }
}

abstract  class   BaseGameLoader{
    void loadFilesFromDisk(){
        System.out.println("loading files from the  disk ");
    };

   abstract void createObjects();


   abstract void connectOnline();

   abstract void loadProfiles();


   void cleanUp(){
       System.out.println("cleaning ");
   }


   void load(){
       loadFilesFromDisk();
       createObjects();
       connectOnline();
       cleanUp();
   }


}

class Game1Loader extends BaseGameLoader{


    void createObjects() {
        System.out.println(Game1Loader.class+ "creating objects");

    }


    void connectOnline() {

        System.out.println(Game1Loader.class +" connecting online ...");

    }


    void loadProfiles() {
        System.out.println(Game1Loader.class + " loading Profiels..");

    }
}



class GamesLoader2 extends BaseGameLoader{


    void createObjects() {
        System.out.println(GamesLoader2.class+ "creating objects");

    }


    void connectOnline() {

        System.out.println(GamesLoader2.class +" connecting online ...");

    }


    void loadProfiles() {
        System.out.println(GamesLoader2.class + " loading Profiels..");

    }
}