package seminar3.homeWorkTask2;

public class Calculator {
    public static <N extends Number, V extends Number> double sum(N arg1, V arg2){
        return arg1.doubleValue() + arg2.doubleValue();
    }

    public static <N extends Number, V extends Number> double div(N arg1, V arg2){
        double result = 0;
        try {
            if (arg2.doubleValue() != 0) {
                result = arg1.doubleValue() / arg2.doubleValue();
            } else {
                throw new RuntimeException("Деление на ноль!");
            }
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return round(result);
    }

    public static <N extends Number, V extends Number> double mult(N arg1, V arg2){
        return round(arg1.doubleValue() * arg2.doubleValue());
    }

    public static <N extends Number, V extends Number> double sub(N arg1, V arg2){
        return round(arg1.doubleValue() - arg2.doubleValue());
    }

    private static double round(double arg){
        double i = Math.round(arg * 10000);
        i = i / 10000;
        return i;
    }

}