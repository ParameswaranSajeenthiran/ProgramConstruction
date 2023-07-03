package designPatterns;

import test.Test;

public class TestAccessModifier extends  Test{

    public TestAccessModifier(  String data){
        super(data);
    }

    @Override
    public String getData() {
        return data;
    }


}

 class Test1 {

     public static void main(String[] args) {
         TestAccessModifier test = new TestAccessModifier("data");
//         System.out.println(test.data);

     }


}