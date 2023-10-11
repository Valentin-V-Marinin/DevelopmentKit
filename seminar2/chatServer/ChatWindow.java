package seminar2.chatServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame implements iSocketThreadListener{
    private static final int WINDOW_HEIGHT  = 100;
    private static final int WINDOW_WIDTH   = 400;
    private static final int WINDOW_POSX    = 400;
    private static final int WINDOW_POSY    = 200;

    iServerListener listener;

    JButton btnStart = new JButton("start");
    JButton btnStop = new JButton("stop");
    JPanel grid = new JPanel(new GridLayout(1,2));

    Server server;

    ChatWindow(Server server, iServerListener listener){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(WINDOW_POSX, WINDOW_POSY, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server");

        this.server = server;
        this.listener = listener;

        grid.add(btnStart); grid.add(btnStop);
        add(grid);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.start();
                generateMessage("нажата кнопка btnStart");
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.stop();
                generateMessage("нажата кнопка btnStop");
            }
        });

        setVisible(true);
    }

    @Override
    public void generateMessage(String msg){
        System.out.println(msg);
    }
}
