package designPatterns.singleton.uni;

public class Lecture {
    private  static   Lecture lecture ;

    private Lecture(){

    };

    public static Lecture getInstance(){
        System.out.println("calling get Instance method");
        if(lecture==null){
            System.out.println("creating new lecture");
            lecture=new Lecture();
        }
        return lecture;
    }


    public static void main(String[] args) {
        Lecture lecture1=Lecture.getInstance();

       lecture1= Lecture.getInstance();
        System.out.println();
    }
}
