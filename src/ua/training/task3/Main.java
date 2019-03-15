package ua.training.task3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> arrayListInt = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        System.out.println(arrayListInt.add(8));                                                     // true
        System.out.println(arrayListInt.add("abc"));                                                 // compilation error
        System.out.println(arrayListInt.contains(8));                                                // true
        System.out.println(arrayListInt.contains(10));                                               // false
        System.out.println(arrayListInt.contains("abc"));                                            // false
        System.out.println(arrayListInt.containsAll(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)))); // true
        System.out.println(arrayListInt.containsAll(new ArrayList<>(Arrays.asList("a", "b", "c")))); // false
        System.out.println(arrayListInt.remove(new Integer(8)));                               // true
        System.out.println(arrayListInt.remove(new Integer(10)));                              // false
        System.out.println(arrayListInt.remove("abc"));                                           // false
        System.out.println(arrayListInt.remove(8.0));                                             // false

        // output works
        for (Integer element : arrayListInt) {
            System.out.println(element); // 1 2 3 4 5 6 7 8
        }

        // output works
        arrayListInt.forEach(System.out::println); // 1 2 3 4 5 6 7 8

        List arrayList = new ArrayList();

        System.out.println(arrayList.add(7));                                                  // true
        System.out.println(arrayList.add(8));                                                  // true
        System.out.println(arrayList.add("abc"));                                              // true
        System.out.println(arrayList.add("xyz"));                                              // true
        System.out.println(arrayList.contains(8));                                             // true
        System.out.println(arrayList.contains(10));                                            // false
        System.out.println(arrayList.contains("abc"));                                         // true
        System.out.println(arrayList.containsAll(new ArrayList<>(Arrays.asList(8, "abc"))));   // true
        System.out.println(arrayList.containsAll(new ArrayList<>(Arrays.asList(8.0, "cde")))); // false
        System.out.println(arrayList.remove(new Integer(8)));                            // true
        System.out.println(arrayList.remove(new Integer(10)));                           // false
        System.out.println(arrayList.remove("abc"));                                        // true
        System.out.println(arrayList.remove(8.0));                                          // false

        // output works
        for (Object element : arrayList) {
            System.out.println(element); // 7 xyz
        }

        // output works
        arrayList.forEach(System.out::println); // 7 xyz

        // output works
        System.out.println(arrayList.get(0)); // 7
        System.out.println(arrayList.get(1)); // xyz

        // compilation error
        for (Integer element : arrayList) {
            System.out.println(element);
        }

        // output works but we should know the type of each element
        System.out.println((int) arrayList.get(0));    // 7
        System.out.println((String) arrayList.get(1)); // xyz

        // ConcurrentModificationException if implicitly using iterator
        for (Integer element : arrayListInt) {
            arrayListInt.remove(element);
        }

        // ConcurrentModificationException if implicitly using iterator
        arrayListInt.forEach(arrayListInt::remove);

        // but works if explicitly using iterator
        Iterator iterator = arrayListInt.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(arrayListInt.toString()); // []

        // working wit Set
        Set<Integer> hashSetInt = new HashSet<>(Arrays.asList(1, 2, 3, 4, 4, 3, 2, 1));
        System.out.println(hashSetInt.toString()); // [1, 2, 3, 4]

        hashSetInt.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.println(hashSetInt.toString()); // [1, 2, 3, 4, 5, 6, 7, 8]

        System.out.println(hashSetInt.remove(9)); // false

        // UnsupportedOperationException example
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8).remove(0));
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8).add(9));

        // UnsupportedOperationException example
        List<Integer> unmodifiableListInt = Collections.unmodifiableList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        unmodifiableListInt.add(9);
    }

}
