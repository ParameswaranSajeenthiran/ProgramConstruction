package designPatterns.momento.greeckfic;

import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

public class MomentoTest {
}

class TextArea{
     private String text;

    public void set(String text) {
        this.text = text;
    }

    public Memento takeSnapShot(){
        return new Memento(this.text);
    }

    public void restore(Memento memento){

        this.text=memento.getSavedText();

    }




    public static class Memento{
        private final  String text;
        private Memento(String textToSave ){
            text=textToSave;
        }



        private  String getSavedText(){
            return text;
        }

    }

}

class Editor{
    private Deque<TextArea.Memento>stateHistroy;
    private TextArea textArea;

    public Editor(){
        stateHistroy=new LinkedList<>();
        textArea=new TextArea();

    }

    public void write(String text){
        textArea.set(text);
        stateHistroy.add(textArea.takeSnapShot());

    }


    public void  undo(){
        textArea.restore(stateHistroy.pop());

    }

}

interface DrawAPI{
    public void draw();

}