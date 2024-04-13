package org.example.empStream.map;

import java.util.*;
import java.util.stream.Collectors;

public class MapFilterUsingStream {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"Java");
        map.put(2,"C");
        map.put(3,"aws");
        map.put(4,"Azure");

        System.out.println("\n=== Course to search based on key ====");
         map.entrySet().stream()
                .filter(m -> m.getKey()==1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                        .forEach((k,v)->{
                            System.out.println("k:"+k +" v:"+v);
                        });

        System.out.println("\n=== Course to search based on value ====");
        Map<Integer, String> collect = map.entrySet().stream()
                .filter(entry -> entry.getValue() == "Java")
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(collect);


        System.out.println("\n=== course id > 2 collect values as list ====");
        map.entrySet().stream().filter(e->e.getKey()>2)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList())
                .forEach(System.out::println);


         System.out.println("\n=== printing map key,values as list ====");
         map.entrySet().stream().map(entry -> entry.getKey() + " " + entry.getValue())
                .collect(Collectors.toList())
                 .forEach(System.out::println);
    }
}
