package seminar5.task2;

public class WaitNotifyApp {
    private final Object mon = new Object();
    private char currentLetter = '{';
    private int PAIR_NUMBER = 7;

    public static void main(String[] args) {
        WaitNotifyApp waitNotifyApp = new WaitNotifyApp();
        new Thread(() -> {
            waitNotifyApp.printA();
        }).start();
        new Thread(() -> {
            waitNotifyApp.printB();
        }).start();
    }

    public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < PAIR_NUMBER; i++) {
                    while (currentLetter != '{') {
                        mon.wait();
                    }
                    System.out.print("{");
                    currentLetter = '}';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < PAIR_NUMBER; i++) {
                    while (currentLetter != '}') {
                        mon.wait();
                    }
                    System.out.print("}");
                    currentLetter = '{';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}