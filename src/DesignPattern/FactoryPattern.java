package DesignPattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FactoryPattern {

    public static void main(String[] args) {
        Strudent s = new Strudent(100, "Govind");
        HashMap<Strudent, Integer> map = new HashMap<>();
        map.put(s, 100);
        System.out.println(map);
        s.setId(200);
        s.setName("nimmi");
        System.out.println(map);
        s.setId(100);
        s.setName("anjali");
        System.out.println(map);

        HashMap<String, Integer> map1 = new HashMap<>();
        String s1 = "abbbbcadrfre";
        String[] s2 = s1.trim().split("");
       Arrays.stream(s2).forEach(s3 -> {
               if(map1.containsKey(s3)){
                       map1.put(s3,map1.get(s3)+1);
               }
               else {
                       map1.put(s3, 1);
               }});

//            System.out.println(map1.entrySet().stream().sorted((o1, o2) -> {
//                    return -(o1.getValue().compareTo(o2.getValue()));
//            }).collect(Collectors.));

//        String[] result = {"up_10", "mp_30", "hp_50"};
//        HashMap<String, Integer> map1 = new HashMap<>();
//
//        map1=(HashMap<String, Integer>) Arrays.stream(result).collect(Collectors.toMap(string -> string.substring(0, string.indexOf("_")), string ->Integer.parseInt(string.substring(string.indexOf("_") + 1)) ));
//        System.out.println(map1);
    }
}

