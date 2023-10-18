package seminar3.task3;

public class Main {
    public static void main(String[] args) {
        GenericIterator<Integer> gi = new GenericIterator<>(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        while (gi.hasNext()) {
            System.out.println(gi.next());
        }

        for (Integer item: gi) {
            System.out.println(item);
        }
    }
    

}
