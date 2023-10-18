package seminar3.task4;

public class Worker  implements iPerson{

    @Override
    public void doWork() {
        System.out.println(this.getClass().getName() + "  start doing my job");
    }

    @Override
    public void haveRest() {
        System.out.println(this.getClass().getName() + "  relax is impossible action!");
    }
}
