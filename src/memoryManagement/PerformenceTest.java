package memoryManagement;

import java.util.HashMap;
import java.util.Map;


// note mister sajeenthiran there is a tool called memeoryyMeter in githu : //reitten by sajeenthiran
public class PerformenceTest {




    public static void main(String[] args) {
      Runtime rt=  Runtime.getRuntime();
      rt.gc();
      long before=rt.freeMemory();

        Map<String,PerformenceTest>map=new HashMap<>();
        map.put("rrr",new PerformenceTest());

      long   after=rt.freeMemory();
        System.out.println((after-before));
    }


    class StudentRecord{

        public String name;
        public  int age ;

        StudentRecord(String name ,int  age){

        }



    }

}
