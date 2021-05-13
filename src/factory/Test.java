package factory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<Employee> list= Arrays.asList(new Employee("john",20));

        list.stream().collect(Collectors.groupingBy(employee -> emplo))
    }
}