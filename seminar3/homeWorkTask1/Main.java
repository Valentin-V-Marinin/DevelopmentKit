package seminar3.homeWorkTask1;

public class Main {
    public static void main(String[] args) {
        GenericCollection<Integer> numbers = new GenericCollection<>();
        numbers.add(11);
        numbers.add(12);
        numbers.add(30);
        numbers.add(48);
        System.out.println(numbers.info());
        numbers.remove(30);
        System.out.println(numbers.info());


        GenericCollection<String> fruits = new GenericCollection<>();
        fruits.add("apple");
        fruits.add("melon");
        fruits.add("orange");
        fruits.add("strawberry");
        fruits.add("lime");
        System.out.println(fruits.info());
        fruits.remove("orange");
        System.out.println(fruits.info());

        System.out.println("_____________________________________   iterator   _________________________________________________");
        fruits.ownIterator = fruits.getIterator();
        while (fruits.ownIterator.hasNext()) {
            System.out.println(fruits.ownIterator.next());
        }

        fruits.ownIterator = fruits.getIterator();
        String str = "";
        while (fruits.ownIterator.hasNext()) {
            str += fruits.ownIterator.next() + ", ";
        }
        str = str.substring(0, str.length()-2);
        System.out.println(str);
        System.out.println("____________________________________________________________________________________________________");

        numbers.ownIterator = numbers.getIterator();
        while (numbers.ownIterator.hasNext()){
            System.out.println(numbers.ownIterator.next());
        }

        numbers.ownIterator = numbers.getIterator();
        int sum = 0;
        while (numbers.ownIterator.hasNext()){
            sum += numbers.ownIterator.next();
        }
        System.out.println("Сумма элементов равна " + sum);

    }
}
