package seminar5.homeWorkTask1;

import java.util.Random;

public class Philosopher extends Thread{

    private int dinner_counter = 0;  // разрешенное количество обедов = 3

    private final int MAX_ALLOWED_DINNER_NUMBER = 3;
    final DinnerPlace dinnerPlace;
    private Random rnd = new Random();





    public Philosopher(DinnerPlace dinnerPlace) {
        this.dinnerPlace = dinnerPlace;
    }

    @Override
    public void run() {
        while (dinner_counter < MAX_ALLOWED_DINNER_NUMBER) {
            System.out.println("Философ " + this.getName() + " размышляет...");
            try {
                Thread.sleep(rnd.nextInt(100, 300));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            eatDinner();
        }
    }

    public void eatDinner(){
        synchronized (dinnerPlace) {
            if (dinnerPlace.addGuests(this)) {
                dinner_counter++;
                System.out.println("-------  Философ " + this.getName() + " трапезничает. Обед № " + dinner_counter);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
