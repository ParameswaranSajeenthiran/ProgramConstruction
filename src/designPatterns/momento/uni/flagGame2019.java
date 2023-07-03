package designPatterns.momento.uni;

public class flagGame2019 {
}


class GameManager{

    private  Flag flag;



    public Flag createFlag( String x,String y  ){
        return  new Flag(x,y);

    }





   static class Flag{
        private String  position_x;
        private  String position_y;

       public Flag(String position_x, String position_y) {
           this.position_x = position_x;
           this.position_y = position_y;
       }

       public String getPosition_x() {
           return position_x;
       }

       public void setPosition_x(String position_x) {
           this.position_x = position_x;
       }

       public String getPosition_y() {
           return position_y;
       }

       public void setPosition_y(String position_y) {
           this.position_y = position_y;
       }
   }
}

