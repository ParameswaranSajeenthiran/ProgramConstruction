package pastPapers;

import java.util.ArrayList;
import java.util.List;

public class WebPageHTMLDemo {

    public static void main(String[] args) {
        TagComponent tagComponent = new CompositeTag("<document>");
        TagComponent title = new Leaf("<title>Design Patterns</title>");
        TagComponent body = new CompositeTag("<body>");
        TagComponent section = new CompositeTag("<section>");
        TagComponent heading = new CompositeTag("<heading>Structural Design Patterns</heading>");
        TagComponent paragraph = new Leaf("<p>Structural design patterns are those.......</p>");
        TagComponent paragraph1 = new Leaf("There are many structural design patterns.........</p>");
        tagComponent.addTag(title);
        tagComponent.addTag(body);

        body.addTag(section);
        section.addTag(heading);
        heading.addTag(paragraph);
        heading.addTag(paragraph1);
        tagComponent.print();


    }
}


abstract  class TagComponent {
    protected String tagHeading;

    public TagComponent (String tagHeading){
        this.tagHeading=tagHeading;

    }


    public void print(){
        throw new UnsupportedOperationException();
    }
    public void addTag(TagComponent tagComponent){
        throw new UnsupportedOperationException();
    }

    public void removeTag(){
        throw  new UnsupportedOperationException();
    }



}


class CompositeTag extends  TagComponent{


    private List<TagComponent> tagComponentList;

    public CompositeTag (String tagHeading){
        super(tagHeading);
        tagComponentList=new ArrayList<>();
    }
    public void addTag(TagComponent tagComponent){
        tagComponentList.add(tagComponent);

    }

    public void print (){
        System.out.println(tagHeading);

        tagComponentList.forEach((tagComponent -> {

            tagComponent.print();
        }));
        System.out.println(tagHeading);
    }
}

class Leaf extends  TagComponent {
    public Leaf(String tagHeading) {
        super(tagHeading);
    }

    public void print (){
        System.out.println(tagHeading);

    }
}