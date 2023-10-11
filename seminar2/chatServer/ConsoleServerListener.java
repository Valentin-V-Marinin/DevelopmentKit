package seminar2.chatServer;

public class ConsoleServerListener implements iServerListener{
    @Override
    public void generateMessage(String msg) {
        System.out.println(msg);
    }
}
