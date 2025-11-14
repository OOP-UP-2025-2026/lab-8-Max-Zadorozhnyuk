package ua.opnu;

public class Main {
    public static void main(String[] args) {

        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse: " + middleName.orElse("немає"));

        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username);
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("get(): " + username.get());
        System.out.println("orElse: " + username.orElse("guest"));

        try {
            String test = middleName.get();
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        try {
            MyOptional<String> broken = new MyOptional<>(null);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }

        BookData b1 = new BookData("Java", "Bloch", 100, 450);
        BookData b2 = new BookData("C++", "Stroustrup", 50, 250);
        System.out.println("Compare: " + b1.compareTo(b2));

        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        String[] arr = {"A", "B", "C"};
        System.out.println("contains B: " + Utils.contains(arr, "B"));

        Integer[] nums = {1, 2, 3, 4, 5};
        Integer[] filtered = Utils.filter(nums, n -> n > 2);
        for (Integer n : filtered) System.out.println("filtered: " + n);

        GenericTwoTuple<String, Integer> t1 = new GenericTwoTuple<>("Age", 20);
        System.out.println(t1);

        GenericThreeTuple<String, Integer, Double> t2 =
                new GenericThreeTuple<>("Student", 95, 4.8);
        System.out.println(t2);
    }
}