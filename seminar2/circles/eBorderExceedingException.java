package seminar2.circles;

public class eBorderExceedingException extends Exception{
    public  eBorderExceedingException(){
       super("Выход за пределы установленных границ!");
    }
}
