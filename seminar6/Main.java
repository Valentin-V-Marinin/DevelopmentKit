package seminar6;

public class Main {
    public static void main(String[] args) {
        Statistics stat = new Statistics();
        int idx = 0;
        int result = 0;
        //while (idx < Integer.parseInt(args[1])){                 // вариант для jar-версии
        while (idx < 1000){                                        // вариант для IDEA
            stat.setGifts();
            // передаём 1 - это значит игрок меняет свой выбор
            // 0 - выбор остаётся прежним
            //result = stat.userChoice(Integer.parseInt(args[0])); // вариант для jar-версии
            result = stat.userChoice(1);               // вариант для IDEA
            switch (result){
                case 1: System.out.println("Выигрыш"); break;
                case 0: System.out.println("Проигрыш"); break;
            }
            System.out.println();
            stat.getHashResult().put(idx++, result);
        }
        stat.showStatistics();
    }
}
