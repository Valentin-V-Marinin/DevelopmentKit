package seminar4.task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
/*
        //Task1
        List<String> names = new ArrayList<>(List.of("Sam","Nick","John","Samuel","Ben","Dick","Harry","Tom", "Richard"));
        Collections.sort(names);
        System.out.println(names);
        Collections.reverse(names);
        System.out.println(names);

        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return -1;
                } else if (o1.length() < o2.length()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println(names);
  */
        // Task2
        List<String> newNamesList = new ArrayList<>(List.of("Andrew","Sam","Harry","Nick","John", "Sam","Samuel","Ben","Dick","Harry","Tom", "Richard"));
        Set<String> newNamesSet = new HashSet<>(newNamesList);
        System.out.println(newNamesSet);

        // по алфавиту
        newNamesList.sort(new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(0) > o2.charAt(0)) {
                    return 1;
                } else if (o1.charAt(0) < o2.charAt(0)) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        System.out.print(newNamesList + "  ");
        System.out.print(newNamesList.get(0) + "  "); System.out.println(newNamesList.get(newNamesList.size()-1));

        // по длине
        newNamesList.sort(new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return -1;
                } else if (o1.length() < o2.length()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(newNamesList);

        //удаление всех слов с литерой "A"
        newNamesList.removeIf(item -> (item.contains("a") || item.contains("A")));
        System.out.println(newNamesList);

    }

}
