package seminar3.task4;

public class Workplace <T extends iPerson>{
    T[] arr;

    Workplace(T[] arr){
        this.arr = arr;

        for (T person: arr) {
            person.doWork();
        }
    }
}
