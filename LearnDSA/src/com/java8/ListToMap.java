package com.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Emplyee{
    String name;
    Integer salery;
    String gender;
    public Emplyee(String name, Integer salery,String gender) {
        this.name = name;;
        this.salery = salery;
        this.gender = gender;
    }

    public Integer getSalery() {
        return salery;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
}

public class ListToMap {

    public static void main(String[] args) {

        List<Emplyee> empList = new ArrayList<>();
        empList.add(new Emplyee("pramod",2000,"Male"));
        empList.add(new Emplyee("sameer",1000,"Male"));
        empList.add(new Emplyee("radha",3000,"Femail"));


        Map<Emplyee, Integer> map = empList.
                stream().
                sorted(Comparator.comparing(Emplyee::getSalery)
                        .reversed())
                .collect(Collectors.
                        toMap(Function.identity(), Emplyee::getSalery,
                                (e1, e2) -> e1, LinkedHashMap::new));

    map.forEach((k,v) -> System.out.println(k.getName() + ": " + v));

    // Geder wise counting
        Map<String, Long> empMap = empList.stream().collect(Collectors.groupingBy(Emplyee::getGender, Collectors.counting()));
        System.out.println(empMap);
    }
}
