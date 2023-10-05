package seminar1.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatWindow extends JFrame {
    private static final int WINDOW_HEIGHT  = 300;
    private static final int WINDOW_WIDTH   = 400;
    private static final int WINDOW_POSX    = 500;
    private static final int WINDOW_POSY    = 200;

    private final String LOGIN_NAME;
    private final String SERVER_PATH;

    JTextArea txtOut = new JTextArea();
    JTextField txtIn = new JTextField();
    JButton btnSend = new JButton("send msg");
    JScrollPane scrollPane = new JScrollPane(txtOut);

    JPanel grid = new JPanel(new GridLayout(3,1));

    Logger log = new Logger();

    JFrame chatWnd;

    ChatWindow(String login_name, String server_path){
        LOGIN_NAME = login_name;
        SERVER_PATH = server_path;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Чат");
        setResizable(false);

        log.setFileName(server_path);
        log.loadLog(txtOut);
        txtOut.setEditable(false);

        txtOut.setBackground(new Color(0xFDEFA7));


        grid.add(scrollPane); grid.add(txtIn); grid.add(btnSend);
        add(grid);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeMessage();
            }
        });

        txtIn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER ) {
                    shapeMessage();
                }
            }
        });

        chatWnd = this;
        chatWnd.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                closeMethod();
            }
        });

        setVisible(true);
    }

    private void shapeMessage(){
        txtOut.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd hh:mm:ss")) +
                " - " + LOGIN_NAME + ": " + txtIn.getText() + "\n");
        txtIn.setText("");
    }

    private void closeMethod(){
        log.setFileName(SERVER_PATH);

        try {
            log.savelog(txtOut);
        } catch (RuntimeException e){
            JOptionPane.showMessageDialog(chatWnd, e.getMessage());
        }

        chatWnd.dispose();
        System.exit(0);
    }
}
