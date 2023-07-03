package designPatterns.composite.uni;

import java.util.ArrayList;
import java.util.List;

public class CompositeTest {

    public static void main(String [] args) {
        Plant p1 = new LeafPlant("P1");Plant p2 = new LeafPlant("P2");Plant p3 = new LeafPlant("P3");Plant p4 = new LeafPlant("P4");Plant p5 = new CompositePlant("P5",2);p5.install(p1); p5.install(p2);Plant p6 = new CompositePlant("P6",2);p6.install(p3); p6.install(p4);Plant p7 = new CompositePlant("P7",2);p7.install(p5)  ;p7.install(p6);p7.report();}
}

abstract  class Plant{
    private  String id;
    Plant( String id ){
        this.id=id;

    }

    public String getId(){
        return  id;
    }

    abstract public void report();

    abstract public boolean install(Plant p);


}

class CompositePlant extends Plant{
    private List<Plant> splist;
    private int spCount ;
    private  int spPtr;
    public CompositePlant(String id,int spCount){
        super(id);
        this.spCount=spCount;
        spPtr=0;
        splist=new ArrayList<>();
    }



    public void report() {
        splist.forEach(sp->{
            sp.report();
        });

        System.out.println("Reporting status of "+ getId());



    }

    public boolean install(Plant p) {
        splist.add(p);
        return false;
    }

}
class LeafPlant extends  Plant{

   public  LeafPlant(String id) {
        super(id);
    }

    @Override
    public void report() {
        System.out.println("reporting status of "+getId());

    }

    @Override
    public boolean install(Plant p) {
        System.out.println("leaf should never call install");
        throw  new UnsupportedOperationException();

    }
}