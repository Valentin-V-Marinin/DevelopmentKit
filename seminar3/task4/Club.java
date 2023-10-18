package seminar3.task4;

public class Club<T extends iPerson>{
    T[] arr;

    Club(T[] arr){
        this.arr = arr;

        for (T person: arr) {
            person.haveRest();
        }
    }

}
