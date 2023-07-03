package revisingDesignPatterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MomentoTest {
}




class GameManger {
    private Flag currentFlag;


    public GameManger(float x,float y){
        currentFlag=new Flag(0,0);

    }

    public  Flag save (float x, float y){
        return new Flag(x,y);


    }

    public void restore( Flag newFlag ){
        this.currentFlag=newFlag;


    }



    class Flag {
        private float position_x;
        private float position_y;

        public Flag(float position_x, float position_y) {
            this.position_x = position_x;
            this.position_y = position_y;
        }

        public float getPosition_x() {
            return position_x;
        }

        public void setPosition_x(float position_x) {
            this.position_x = position_x;
        }

        public float getPosition_y() {
            return position_y;
        }

        public void setPosition_y(float position_y) {
            this.position_y = position_y;
        }
    }




}