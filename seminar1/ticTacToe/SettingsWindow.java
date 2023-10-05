package seminar1.ticTacToe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT  = 230;
    private static final int WINDOW_WIDTH   = 450;

    private int winSliderMaxValue;
    JButton btnStatrt = new JButton("Start new game");

    JLabel labelMode = new JLabel("Выберите режим игры:");
    JRadioButton HumanVsHumanButton = new JRadioButton("Человек против человека", true);
    JRadioButton HumanVsCPUButton = new JRadioButton("Человек против машины");
    JLabel labelSize = new JLabel("Установите размер поля:");
    JSlider sliderSize = new JSlider(3,10,3);
    JLabel labelWin = new JLabel("Длина ряда для победы:");
    JSlider sliderWin = new JSlider(3,10,3);

    JPanel grid = new JPanel(new GridLayout(4,1));
    JPanel top = new JPanel(new GridLayout(2,1));
    JPanel middle = new JPanel(new GridLayout(1,2));
    JPanel bottom = new JPanel(new GridLayout(1,2));
    JPanel topButtons = new JPanel(new GridLayout(1,2));

    ButtonGroup buttonGroup = new ButtonGroup();


    SettingsWindow(GameWindow gameWindow){
        setTitle("Окно  настроек");
        setLocation(gameWindow.getLocation());
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        top.add(labelMode); top.add(topButtons);
        buttonGroup.add(HumanVsHumanButton); buttonGroup.add(HumanVsCPUButton);
        topButtons.add(HumanVsHumanButton); topButtons.add(HumanVsCPUButton);

        middle.add(labelSize); middle.add(sliderSize);
        bottom.add(labelWin); bottom.add(sliderWin);
        grid.add(top); grid.add(middle); grid.add(bottom); grid.add(btnStatrt);

        add(grid);

        btnStatrt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame((HumanVsHumanButton.isSelected() ? 1 : 0),sliderSize.getValue(),
                        sliderSize.getValue(),sliderWin.getValue());
                gameWindow.settings.setVisible(false);
            }
        });

        sliderSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int curValue = sliderSize.getValue();
                winSliderMaxValue = curValue;
                sliderWin.setValue(sliderWin.getMinimum());
                labelSize.setText("Размер игрового поля: " + curValue );
            }
        });

        sliderWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderWin.setMinimum(3);
                sliderWin.setMaximum(winSliderMaxValue);
                int curValue = sliderWin.getValue();
                labelWin.setText("Длина победного ряда: " + curValue );
            }
        });

    }
}
