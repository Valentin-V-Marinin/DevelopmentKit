package seminar2.developer;

public class FrontEndDeveloper extends Developer implements iFrontEnddeveloper{
    @Override
    public void writeFrontEndCode() {
        System.out.println("i'm doing my job!");
    }

    public void developGUI(){
        System.out.println("Developing GUI");
    }

    @Override
    void doSomethingUseful() {
        System.out.println("do something useful");
    }
}
