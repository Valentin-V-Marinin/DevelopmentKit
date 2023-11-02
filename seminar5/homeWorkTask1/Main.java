package seminar5.homeWorkTask1;

/*
    Есть пять философов (потоки), которые могут либо обедать, либо размышлять.
    Каждый философ должен пообедать три раза. Каждый прием пищи длится 500 миллисекунд
    После каждого приема пищи философ должен размышлять
    Не должно возникнуть общей блокировки
    Философы не должны есть больше одного раза подряд
*/

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // общий ресурс - помещение общепита на одно место
        DinnerPlace dinnerPlace = new DinnerPlace();

        // 5 философов
        for (int i = 0; i < 5; i++) {
            Philosopher ph = new Philosopher(dinnerPlace);
            ph.setDaemon(true);
            ph.start();
        }

        // график посещения общепита
        Thread thread = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (dinnerPlace.getDinnerPlaceGuests().size() == 15) {
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("Журнал посещения философами общепита: ");
                    int idx = 0;
                    for (String item: dinnerPlace.getDinnerPlaceGuests() ) {
                        System.out.println(++idx + ":  " + item);
                    }
                    return;
                }
            }
        });
        thread.start();


    }
}
