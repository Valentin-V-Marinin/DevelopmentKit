package seminar3.task4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        iPerson[] person = new iPerson[rnd.nextInt(12)];
        for (int i = 0; i < person.length; i++) {
            switch (rnd.nextInt(1,3)){
                case 1 -> person[i] = new Worker();
                case 2 -> person[i] = new Slacker();
            }
        }

//        for (iPerson item: person) {
//            item.doWork();
//        }

        Workplace wp = new Workplace(person);
        Club club = new Club(person);


    }
}
