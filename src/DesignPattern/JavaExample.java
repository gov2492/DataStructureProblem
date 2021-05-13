package DesignPattern;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class JavaExample {

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();
        int count=0;
        List<Employee> employees = Arrays.asList(new Employee("Govind", 40), new Employee("Govind", 40), new Employee("Nimmi", 20));
        List<String> list= employees.stream().filter(employee -> employee.getAge() > 30).map(employee -> employee.getName()).collect(Collectors.toList());
        System.out.println(list.stream().filter(s ->Collections.frequency(list,s)>1).count());
    }
}

class Employee {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}