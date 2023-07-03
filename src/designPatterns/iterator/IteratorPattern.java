package designPatterns.iterator;

public class IteratorPattern {
}
interface Iterator{
    public boolean hasNext();
    public  Object next();

}

interface  Container {
    public Iterator getIterator();
}

class NumberBox implements Container{
private int[] data;
private  int size;

private int count;

public NumberBox(int size){
    this.size=size;
    data=new int[size];
    count=0;


}

public class BoxIterator implements  Iterator{

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
public Iterator getIterator(){
    return  new BoxIterator();
}


public boolean store(int value){
return  false;

}


}