package seminar3.task4;

public class Slacker implements iPerson{
    @Override
    public void doWork() {
        System.out.println(this.getClass().getName() +  "   doWork - the impossible command!");
    }

    @Override
    public void haveRest() {
        System.out.println(this.getClass().getName() + "   I'm ready to chill!");
    }
}
