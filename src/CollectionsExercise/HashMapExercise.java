package CollectionsExercise;

import java.util.*;

public class HashMapExercise {

    public static void main(String[] args) {




       int hashCode;
       String key;
       double value;
       int index ,capacity=16;
       float loadFactor= 0.5F;

        HashMap<String ,Double> map=new HashMap<>(16, loadFactor);

        map.put("chemical",4.0);
        map.put("cse",4.0);
        map.put("civil",3.6);
//        System.out.println("Capacity "+map.entrySet());

        for (Map.Entry<String,Double>  e : map.entrySet()){
            key=e.getKey();
            value=e.getValue();
            hashCode=e.hashCode();
            index=hashCode & (capacity-1);

            System.out.println("Key :"+key+ " value : "+value+"  HashCode: "+hashCode+" Index ="+index);


        }



    }
}
