package DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class WeightExample {

    public static void main(String[] args) {

        List<Integer> a=new ArrayList<>();
        List<List<Integer>> b=new ArrayList<>();
        a.add(10);
        a.add(9);
        a.add(10);
        a.add(20);
        a.add(40);
        a.add(100);

        System.out.println(weight(a));

    }

    public static int weight(List<Integer> a) {
        int weight = 0;
        int n = a.size();
        while (a.size() > 0) {
            if (a.size() == n || weight == 0) {
                int b = firstLargest(a);
                int firstWeight = a.get(b);
                a.remove(b);
                int c = firstLargest(a);
                int secondweight = a.get(c);
                a.remove(c);
                weight = Math.abs(firstWeight - secondweight);

            } else {
                int b = firstLargest(a);
                int firstWeight = a.get(b);
                a.remove(b);
                weight = Math.abs(firstWeight - weight);
            }
        }
        return weight;
    }

    public static int firstLargest(List<Integer> a) {
        int largest = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > a.get(largest)) {
                largest = i;
            }
        }
        return largest;
    }


}
