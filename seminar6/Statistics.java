package seminar6;

/*
Создать свой Java Maven/Gradle проект;
Реализовать прикладную задачу - приложение для демонстрации парадокса Монти Холла;
Можно добавить любые библиотеки которые считают необходимыми
Результаты должны быть сохранены в HashMap (шаг цикла -> результат)
Необходимо вывести статистику по результату - количество позитивных и негативных результатов, процент от общего количества шагов цикла.
 */

import java.util.*;

public class Statistics {

    private final int DOORS_NUMBER = 3;
    private int[] doors = new int[3];  // массив с тремя дверями, за которыми 0-коза или 1-автомобиль
    private Random rnd = new Random();
    HashMap<Integer, Integer> hashResult = new HashMap<>();  // ключ-шаг цикла, значение-результат выбора(1 - успех(авто),  0-коза)

    public HashMap<Integer, Integer> getHashResult() {
        return hashResult;
    }

    //раскладываем подарки
    public void setGifts(){
        doors[0] = rnd.nextInt(0,2);
        if (doors[0] == 1) {
            doors[1] = 0;
            doors[2] = 0;
        } else {
            doors[1] = rnd.nextInt(0, 2);
            if (doors[1] == 1) {
                doors[2] = 0;
            } else {
                doors[2] = 1;
            };
        }
        System.out.println(Arrays.toString(doors) + " - двери с авто и двумя козами");
    }

    public int userChoice(int changeChoice){
        int userDoor = 0;
        Set<Integer> fullSet = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> subSet = new HashSet<>();
        System.out.println("Введите номер выбранной двери - 1,2 или 3: ");
        userDoor = rnd.nextInt(1,4);
        System.out.println("Выбор игрока: " + userDoor);
        subSet.add(userDoor);
        int showmenDoor = showmenChoice(userDoor);
        subSet.add(showmenDoor);
        System.out.println("Ведущий открыл дверь № " + showmenDoor);
        int freeDoor = 0;
        for (Integer item: fullSet) {
            if (!subSet.contains(item)) {
                freeDoor = item;
                break;
            }
        }
        if (changeChoice == 1) {
            userDoor = freeDoor;
            System.out.println("Игрок изменил свой выбор в пользу двери №" + userDoor);
        } else {
            System.out.println("Игрок сохранил свой выбор в пользу двери №" + userDoor);
        }
        if (doors[userDoor-1] == 1) return 1; else return 0;
    }

    private int showmenChoice(int selectedDoor){
        if (doors[selectedDoor-1] == 1) {
            int choice = rnd.nextInt(0,2); // выбор одной из двух дверей с козами
            switch (selectedDoor){
                case 1: if (choice == 0) {
                            return 2;
                        } else {
                            return 3;
                        }
                case 2: if (choice == 0) {
                            return 1;
                        } else {
                            return 3;
                        }
                case 3: if (choice == 0) {
                            return 1;
                        } else {
                            return 2;
                        }
            }
        } else {
            switch (selectedDoor){
                case 1: if (doors[1] == 0) {
                            return 2;
                        } else {
                            return 3;
                        }
                        case 2: if (doors[0] == 0) {
                            return 1;
                        } else {
                            return 3;
                        }
                        case 3: if (doors[0] == 0) {
                            return 1;
                        } else {
                            return 2;
                        }
            }
        }
        return 0;
    }

    public void showStatistics(){
        int negativeResultsNumber = 0;
        int positiveResultsNumber = 0;
        double numberCycles = 0;

        for (Integer item: hashResult.values()) {
            if (item ==1) positiveResultsNumber++;
            if (item ==0) negativeResultsNumber++;
        }
        numberCycles = hashResult.size();
        System.out.println("Количество циклов(игр): " + numberCycles);
        System.out.println("Выигрышей  всего: " + positiveResultsNumber);
        System.out.println("Проигрышей всего: " + negativeResultsNumber);
        System.out.println("Процент  выигрышей: " + positiveResultsNumber/numberCycles*100 + "%");
        System.out.println("Процент проигрышей: " + negativeResultsNumber/numberCycles*100 + "%");

    }

}

