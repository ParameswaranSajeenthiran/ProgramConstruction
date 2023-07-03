package designPatterns.visitor.uni;



public class VisitorPattern {

    public static void main( String [] args){
        Visitor visitor=new Visitor();
    }
}

interface  AbstractVisitor{
    public void doSpecialOP(AbstractElement ae);
}

class Visitor implements  AbstractVisitor{
    public void doSpecialOP(AbstractElement ae){
        System.out.println("Visitor is doing the special operation on");
        System.out.println(((Element)ae ).getData());

    }
}
interface AbstractElement{
    public void accept(AbstractVisitor av);

}

class Element implements  AbstractElement{
    private String data;

    public  Element (String  data){
        this.data=data;
    }

    public String getData(){
        return data;
    }



    public void accept(AbstractVisitor av ){
        av.doSpecialOP(this);

    };

}

