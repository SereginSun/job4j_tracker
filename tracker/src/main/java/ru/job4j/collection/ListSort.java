package ru.job4j.collection;

import java.util.*;

public class ListSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
//        Integer first = 1;
//        Integer second = 2;
//        int result = first.compareTo(second);
//        System.out.println(result);
//        String petr = "Petr";
//        String ivan = "Ivan";
//        int result2 = petr.compareTo(ivan);
//        System.out.println(result2);
        list.sort(Collections.reverseOrder());
        System.out.println(list);
    }
}
