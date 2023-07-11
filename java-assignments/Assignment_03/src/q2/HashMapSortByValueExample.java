package q2;

import java.util.*;

public class HashMapSortByValueExample {
    public static void main(String[] args) {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Maaz", 25);
        hashMap.put("Bhushan", 30);
        hashMap.put("Shubham", 20);
        hashMap.put("Harshal", 35);

        hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(entry->{
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });

    }
}
