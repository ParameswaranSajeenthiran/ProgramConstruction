package CollectionsExercise;


import java.util.HashMap;
        import java.util.Map;

class HashMapTest {

    public static void main(String [] args) {

        // elements of HashMap$Entry
        int hashcode;
        String key;
        double value;

        int index;
        int capacity = 16;

        // initialize a HashMap
        HashMap<String, Double> map = new HashMap<>();

        // add entries
        map.put("cse",4.0);
        map.put("mech",3.5);
        map.put("civil",3.8);
        map.put("electrical",3.4);
        map.put("chemical",3.1);
        map.put("entc",4.0);
        map.put("material",3.2);
        map.put("textile",3.3);

  /*
  map.put("a",1.0);
  map.put("b",1.0);
  map.put("c",1.0);
  map.put("d",1.0);
  map.put("e",1.0);
  map.put("f",1.0);
  map.put("g",1.0);
  map.put("h",1.0);
  map.put("i",1.0);
  map.put("j",1.0);
  map.put("k",1.0);
  map.put("l",1.0);
  map.put("m",1.0);
  map.put("n",1.0);
  map.put("o",1.0);
  map.put("p",1.0);
  map.put("q",1.0);
  */

        // for-loop to enumerate all the items in the HashMap
        for (Map.Entry<String, Double> e : map.entrySet()) {
            key = e.getKey();
            value = e.getValue();

            hashcode = e.hashCode();
            index = hashcode & (capacity-1);

            System.out.println("Key: "+key+" Value: "+value
                    +" HashCode: "+hashcode+" Index: "+index);
        }
    }
}