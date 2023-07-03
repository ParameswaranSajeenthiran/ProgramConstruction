package test;

 public  class Test {

       public String data;

     public Test(String data){
         this.data=data;

    }

    static class StaticClass{

    }

     public String getData() {
         return null;
     }

     public static void main(String[] args) {
         Animal1 a=(Animal1)  new Deer();
         a.eat();




         StaticClass staticClass=new StaticClass();
     }


}

class Deer extends  Animal1{

     public void eat(){
         System.out.println("deer eating ");
     }

}

class Animal1 {

     public void eat(){
         System.out.println("animal eating ");
     }

}
