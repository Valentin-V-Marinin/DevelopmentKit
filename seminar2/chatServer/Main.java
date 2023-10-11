package seminar2.chatServer;

public class Main {
    public static void main(String[] args) {
        //new chatServerWindow(new Server(new ConsoleServerListener()));
        try{
            new ChatWindow(new Server(new LogServerListener("LogServerListener.txt")), new ConsoleServerListener());
        } catch (RuntimeException e){
            e.getStackTrace();
        }

    }
}
