package arraysandstrings;

import java.util.HashMap;
import java.util.Map;

public class TimeComparator {

    // this compares the time of using my hash table
    // and the java built in
    public static void main(String[] args){

        long startTime = System.nanoTime();

        HashTable<String, Integer> map = new HashTable<>();
        map.put("hello world", 1);

        System.out.println(map.get("hello world").value);
        System.out.println(map);

        map.put("hello world", 3);

        System.out.println(map.get("hello world").value);
        System.out.println(map);

        map.put("pretty cool", 5);

        System.out.println(map);

        for(int i = 'a'; i < 'z'; i++){

            map.put("" + i, 30);
        }

        System.out.println(map);

        // removal

        for(int i = 'a'; i < 'z'; i++){
            map.remove("" + i);

        }

        System.out.println(map);

        long endTime = System.nanoTime();

        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.

        System.out.println("My map took: " + duration);

        startTime = System.nanoTime();

        Map<String, Integer> javaMap = new HashMap<>();
        javaMap.put("hello world", 1);

        System.out.println(javaMap.get("hello world"));
        System.out.println(javaMap);

        javaMap.put("hello world", 3);

        System.out.println(javaMap.get("hello world"));
        System.out.println(javaMap);

        javaMap.put("pretty cool", 5);

        System.out.println(javaMap);

        for(int i = 'a'; i < 'z'; i++){
            javaMap.put("" + i, 30);
        }

        System.out.println(javaMap);

        // removal

        for(int i = 'a'; i < 'z'; i++){

            javaMap.remove("" + i);

        }

        System.out.println(javaMap);

        endTime = System.nanoTime();

        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.

        System.out.println("Java's map took: " + duration);

    }


}
