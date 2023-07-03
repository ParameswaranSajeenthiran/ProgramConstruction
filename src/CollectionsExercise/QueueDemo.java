package CollectionsExercise;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue= new LinkedList<>();
        queue.add(2);
        queue.add(4);
        queue.add(1);
        queue.add(0);
         int x= queue.poll();
         queue.poll();
        System.out.println(x);
        System.out.println(queue);
    }
}
