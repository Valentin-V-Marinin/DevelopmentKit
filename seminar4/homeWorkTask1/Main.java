package seminar4.homeWorkTask1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Person> persons = new ArrayList<Person>(
                List.of(
                        new Person(0, "222333222", "Сидор", 10),
                        new Person(1, "33333333", "Александра", 12),
                        new Person(2, "12575756", "Василий", 8),
                        new Person(3, "32565647", "Михаил", 9),
                        new Person(4, "1248960028", "Анфиса", 12),
                        new Person(5, "1248960228", "Анфиса", 12),
                        new Person(6, "7178459000", "Анжелика", 11),
                        new Person(7, "89132258974", "Александра", 15)));

        Person psn = new Person();

        // поиск по стажу
        System.out.println("Сотрудник со стажем 8:" + psn.findByExperience(persons, 8));
        Person pp = psn.findByExperience(persons, 20);
        if (pp == null) {
            System.out.println("Таких нет");
        } else {
            System.out.println("Сотрудник со стажем 20:" + pp);
        }

        // добавление нового сотрудника методом
        psn.add(persons, "12456456", "Петя", 5);
        psn.add(persons, "88845756", "Маша", 10);
        psn.add(persons, "56767657", "Коля", 20);

        persons.forEach(System.out::println);

        // поиск телефона по имени
        List<String> phonesByName = psn.findPhonesByName(persons, "Анфиса");
        System.out.println("Сотрудники по имени Анфиса : " + phonesByName);

        // ищем сотрудника по табельному номеру
        var idsByName = psn.findSomething(persons, p -> p.getName() == "Александра", p -> p.getPersonId());
        System.out.println("ID'шники Александра: " + idsByName);
    }

}


