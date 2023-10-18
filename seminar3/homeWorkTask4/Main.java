package seminar3.homeWorkTask4;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Иван Петров", 22);
        System.out.println(pair);

        Pair<String, Boolean>[] pairDetail = new Pair[4];
        pairDetail[0] = new Pair<>("Высшее образование?", true);
        pairDetail[1] = new Pair<>("Cемейное положение (женат)?", false);
        pairDetail[2] = new Pair<>("Трудоустроен?", true);
        pairDetail[3] = new Pair<>("Автолюбитель?", false);

        for (Pair item: pairDetail) {
            System.out.println(item);
        }

        System.out.print(pair.getFirst());
        System.out.print(" " + pairDetail[2].getFirst());
        System.out.print(" " + pairDetail[2].getSecond());
    }
}
