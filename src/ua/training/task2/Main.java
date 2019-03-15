package ua.training.task2;

public class Main {

    public static void main(String[] args) {
        MyList<String> myArrayListString = new MyArrayList<>();
        myArrayListString.add("first");
        myArrayListString.add("second");
        myArrayListString.add("third");

        myArrayListString.forEach(System.out::println); // first second third

        System.out.println(myArrayListString.get(1)); // second

        myArrayListString.update(1, "updated second");
        System.out.println(myArrayListString.get(1)); // updated second

        System.out.println(myArrayListString.size()); // 3
    }

}
