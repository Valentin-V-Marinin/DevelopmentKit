package seminar3.task2;

public class Main {
    public static void main(String[] args) {
        GenericCollection<Integer> gc = new GenericCollection<>();
        gc.add(11);
        gc.add(12);
        gc.add(30);
        gc.add(48);
        System.out.println(gc.info());
        gc.remove(30);
        System.out.println(gc.info());


        GenericCollection<String> fruits = new GenericCollection<>();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("strawberry");
        fruits.add("lime");
        System.out.println(fruits.info());
        fruits.remove("orange");
        System.out.println(fruits.info());



    }
}
