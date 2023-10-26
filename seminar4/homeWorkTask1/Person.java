package seminar4.homeWorkTask1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Person {
    private int personId;
    private String phone;
    private String name;
    private int experience;

    public Person(int personId, String phone, String name, int experience) {
        this.personId = personId;
        this.phone = phone;
        this.name = name;
        this.experience = experience;
    }

    public Person() {
        this.personId = -1;
        this.phone = "";
        this.name = "";
        this.experience = -1;
    }

    public int getPersonId() {
        return personId;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return String.format("Табельный номер: %d, Имя: %s, Телефон: %s, Стаж: %d", personId, name, phone, experience);
    }

    public Person findByExperience(List<Person> list, int experience) {
        assert list != null : "LIST";
        var opt = list.stream().filter(p -> p.getExperience() == experience).findAny();
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    public List<String> findPhonesByName(List<Person> list, String name) {
        return list.stream().filter(p -> p.getName().equalsIgnoreCase(name))
                .map(p -> p.getPhone()).toList();
    }

    public  <R> List<R> findSomething(List<Person> list, Predicate<Person> filter, Function<Person, R> mapper) {
        return list.stream().filter(filter).map(mapper).toList();
    }

    public void add(ArrayList<Person> list, String phone, String name, int experience) {
        int lastId = list.stream().mapToInt(Person::getPersonId).max().getAsInt();
        list.add(new Person(lastId + 1, phone, name, experience));
    }
}
