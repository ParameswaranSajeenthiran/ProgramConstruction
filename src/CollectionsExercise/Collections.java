package CollectionsExercise;

import test.Test;

import java.util.*;

public class Collections {
    public static void main(String[] args) {

        double value;
        Test test=new Test("**");

        List<Double> integerList=new ArrayList<>();
        List<Integer> linkedList=new LinkedList<>();
        Set<Integer> hashSet=new HashSet<>();
        List<Integer> stack=new Stack<>();
        List<Test> tests=new ArrayList<>();
        Map<String,Integer > map=new HashMap<>();
        tests.add(test);
        System.out.println(tests);
hashSet.add( new Integer(Integer.valueOf( "40")));
hashSet.add(50);
hashSet.add(60);
ArrayList <Integer> arrayList=new ArrayList<>(map.values());
System.out.println(arrayList);

System.out.println(hashSet);



//        Map<Double,Double> map=new HashMap<>();
         HashSet<Double> list=new HashSet<>(integerList);

        list.add(4.0);
        list.add(4.0);
        list.add(3.6);
//        System.out.println("Capacity "+map.entrySet());

        for (Double e : list){
            value=e;

            System.out.println(" value : "+value);


        }



    }


}
class CollectionsTest{
    public static void main(String[] args) {
        Set<Integer> hs= new HashSet<>();
        List<String > list= new LinkedList<>();
        list.add("hi");
        String s= "ss";
        s.trim();
        System.out.println(s);
        byte [] bytes = s.getBytes();
        System.out.println(bytes);
        list.add("sajeenthiran");
        hs.add(8);
        hs.add(2);
        hs.add(3);
        System.out.println(list);
        System.out.println(hs);
        hs.remove(8);
        list.remove(0);
        System.out.println(hs);

        System.out.println(list);

    }
}


class StackTest{
    public static void main(String[] args) {
        List<Integer > list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(13);
        System.out.println(list.get(0));
    }
}

class IteratorTest1{
    public static void main(String[] args) {
        Queue<Integer> stack = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1>o2?o1:o2;
            }
        });
        stack.add(10);
        stack.add(4);
        stack.add(5);
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}