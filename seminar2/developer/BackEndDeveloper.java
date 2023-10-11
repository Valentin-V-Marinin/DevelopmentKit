package seminar2.developer;

public class BackEndDeveloper extends Developer implements iBackEndDeveloper{
    @Override
    public void writeBackEndCode() {
        System.out.println("Пишет бэкенд.");
    }

    @Override
    void doSomethingUseful() {
        System.out.println("do something useful");
    }
}
