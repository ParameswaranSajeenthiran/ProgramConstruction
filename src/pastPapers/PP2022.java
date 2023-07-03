package pastPapers;

public class PP2022 {



    public static void main(String[] args) {

        int i=1040;
        Integer intOBj =new Integer(1040);
        LongInteger longInteger=new LongInteger(1040);    }


}


class LongInteger{

    private static  int test =10;
    private  long l;
    public LongInteger (long l){
        this.l=l;

    }

    public long value (){
        return  l;
    }
}

class  StringTester{

    public static   void   test(){
        String s1= new String("happy ");
        String s2= "coding ";

        String s3 =s1+s2;

        String s4 =new StringBuilder(String.valueOf(s1)).append(s2).toString();

        String  s5 =new String (s1+s2);
        String s6=new String ("happy "+ s2);
        String s7=new String(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);

    }




}

