package CollectionsExercise;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class IteratorTest {
    public static void main(String[] args) {
        List<String > stack= new Stack<>();
        stack.add("hi");
        stack.add(" cse");
        stack.add(" sajeenthiran");
        Iterator it= stack.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
