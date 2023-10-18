package seminar3.homeWorkTask2;

public class Main {
    public static void main(String[] args) {
        int arg1 = 5;
        float arg2 = 7.07f;
        byte arg3 = 15;
        double arg4 = 820.269d;

        //SUM (addition)
        System.out.println(Calculator.sum(arg1, arg4));

        //MULT (multiplication)
        System.out.println(Calculator.mult(arg2, arg3));

        //SUB (subtraction)
        System.out.println(Calculator.sub(arg4, Calculator.mult(arg2, arg3)));

        //DIV (division)
        System.out.println(Calculator.div(arg2, 0));
        System.out.println(Calculator.div(arg4, arg3));
    }
}
