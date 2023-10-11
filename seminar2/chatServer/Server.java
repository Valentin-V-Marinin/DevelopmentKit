package seminar2.chatServer;

import java.util.Random;

public class Server implements iServerSocketThreadListener{

    private boolean status;
    private iServerListener serverListener;

    private Random rnd = new Random();

    public Server(iServerListener serverListener) {
        this.status = false;
        this.serverListener = serverListener;
    }

    public void start(){
        String message;
        if (status) {
            message = "Server is already running.";
        } else {
            status = true;
            message = "Server started.";
        }
        serverListener.generateMessage(message);
    }

    public void stop(){
        String message;
        if (status) {
            status = false;
            message = "Server was stopped.";
        } else {
            message = "Server doesn't work.";
        }
        serverListener.generateMessage(message);
    }
}
