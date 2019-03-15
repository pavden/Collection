package ua.training.task1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(4, 5, -6, 4, 5, 3, 4, 2, 4, 5, 7));
        Map<Integer, Integer> map = new TreeMap<>();

        arrayList.stream().forEach(k -> map.put(k, map.getOrDefault(k, 0) + 1));

        System.out.println("For array " + arrayList.toString() + " the number of repetitions of each element is:");
        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

}
