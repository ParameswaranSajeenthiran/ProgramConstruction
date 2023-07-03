package designPatterns.visitor.refractoringGuru;

import java.awt.*;

public class Demo {
}




interface  Visitor {

    public String visitCircle(Circle circle);

    public String visitRectangle ( Rectangle shape);


}


class XMLExportVisitor implements  Visitor {

    @Override
    public String visitCircle(Circle circle) {
        return null;
    }

    @Override
    public String visitRectangle(Rectangle shape) {
        return null;
    }
}
 interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}

class Circle implements  Shape{

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {


    }

    @Override
    public String accept(Visitor visitor) {


        return visitor.visitCircle(this);
    }
}