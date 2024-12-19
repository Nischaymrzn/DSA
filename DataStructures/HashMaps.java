package dataStructures;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMaps {
    public static void main(String[] args) {
        HashMap<String, Integer> map=new HashMap<>();


        //Insertion
        map.put("Nepal",70);
        map.put("USA",130);
        map.put("China",150);
        System.out.println(map);

        map.put("China", 180);
        System.out.println(map);
 
 
 
 
        //Searching
        if(map.containsKey("Indonesia")) {
            System.out.println("key is present in the map");
        } else {
            System.out.println("key is not present in the map");
        }
 
 
        System.out.println(map.get("China")); //key exists
        System.out.println(map.get("Indonesia")); //key doesn't exist
        

        //Iteration
        // for(int i: arr) in array
        for (Map.Entry<String,Integer>e:map.entrySet()){
            System.out.println(e);
        }

        //Iteration 2
        Set<String> keys=map.keySet();
        for(String key:keys){
            System.out.println("key : "+map.get(key));
        }

    }
    
}
