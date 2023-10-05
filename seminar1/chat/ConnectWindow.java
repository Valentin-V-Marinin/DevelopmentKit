package seminar1.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectWindow extends JFrame{
    private static final int WINDOW_HEIGHT  = 300;
    private static final int WINDOW_WIDTH   = 400;
    private static final int WINDOW_POSX    = 500;
    private static final int WINDOW_POSY    = 200;

    JTextArea login = new JTextArea("Введите логин");
    JTextArea password = new JTextArea("Введите пароль");
    JTextArea server = new JTextArea("Введите сервер");

    JButton btnConnect = new JButton("connect");
    JPanel grid = new JPanel(new GridLayout(4, 1));

    Logger log = new Logger();



    ConnectWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Подключение к чату");
        setResizable(false);

        grid.add(login); grid.add(password); grid.add(server);grid.add(btnConnect);
        add(grid);

        JFrame connectWindow = this;
        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (log.checkPath(server.getText()) || server.getText().equals("Введите сервер")) {
                    new ChatWindow(login.getText(), server.getText());
                    setVisible(false);
                } else {
                    try{
                        if (log.createLogFile(server.getText())) {
                            JOptionPane.showMessageDialog(connectWindow, "Создан новый log-файл. Повторите попытку подключения.");
                        }
                    } catch (RuntimeException er){
                        JOptionPane.showMessageDialog(connectWindow,  er.getMessage() + "\nВведите корректный путь!");
                    }
                }
            }
        });

        setVisible(true);

    }

}
