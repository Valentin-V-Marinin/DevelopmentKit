package seminar2.developer;

public class FullStackDeveloper extends Developer implements iBackEndDeveloper, iFrontEnddeveloper{
    @Override
    public void writeBackEndCode() {
        System.out.println("Пишет бэкенд.");
    }

    @Override
    public void writeFrontEndCode() {
        System.out.println("Пишет фронтенд.");
    }

    @Override
    void doSomethingUseful() {
        System.out.println("do something useful.");
    }
}
