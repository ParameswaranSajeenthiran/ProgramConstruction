package CollectionsExercise;

import java.util.*;

public class JavaCollections {
    public static void main(String[] args) {
        HashMap1 hashMap1 = new HashMap1();
        hashMap1.test();
    }

    /**
     * why java collections ?
     * 1 . To have a common interface for ADTs.
     *      stack - pop , push , top
     *      queue - insert , remove , peek
     *      hashtable - lookup ,
     * **/

}

class HashMap1{
    /**
     * overhead - 48 bytes
     *
     * default capacity 16, load factor -.075
     * default capacity 16 ,hence an array of size 16 , each slot has a overhead of 4 bytes , therefore a overhead of 16 *4 + 48 = 128 bytes
     *
     *
     * * **/
    public void test (){
        Map <String , String > hashtable=  new Hashtable();
        hashtable.put("test2", "test2");


        Map< String ,HashMap1 > testMap= new HashMap<>(17, (float)0.5);
        Map< String ,String > testMap2= new HashMap<>(hashtable);


        testMap.put("test1",new HashMap1());
        testMap2.put("test3","test3" );
        System.out.println(testMap2);

        testMap2.remove("test3");

        System.out.println(testMap);
        System.out.println(hashtable);
    }
}


class LinkedList1 {

}
