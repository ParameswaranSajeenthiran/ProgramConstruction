package CollectionsExercise.HashSet;

import java.util.*;

public class HashSetTest {
    public static void main(String[] args) {

        Iterable<Integer> iterable=new ArrayList<>();
        iterable.iterator();
        HashSet<Integer> hashSet=new HashSet<Integer>((Collection<? extends Integer>) iterable);
        hashSet.add(Integer.valueOf(2));
        System.out.println(hashSet);
    }
}
