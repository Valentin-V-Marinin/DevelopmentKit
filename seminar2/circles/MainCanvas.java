package seminar2.circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCanvas extends JPanel {

    private final MainWindow controller;
    private long lastFrameTime;

    MainCanvas(MainWindow controller){
        this.controller = controller;
        setBackground(Color.BLUE);
        lastFrameTime = System.nanoTime();
        int lowBorder = 0;
        int highBorder = 15;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (e.getButton() == MouseEvent.BUTTON3) {
                    try {
                        if (controller.getSpritesLength() == highBorder) {
                            throw new eBorderExceedingException();
                        } else {
                            controller.setSpritesLength(controller.getSpritesLength() + 1);
                            controller.setSprites(controller.getSprites().size() + 1);
                        }
                    } catch (eBorderExceedingException ex) {
                        JOptionPane.showMessageDialog(controller, ex.getMessage());
                    }
                }
                if (e.getButton() == MouseEvent.BUTTON1){
                    try {
                        if (controller.getSpritesLength() == lowBorder) {
                            throw new eBorderExceedingException();
                        } else {
                            controller.setSpritesLength(controller.getSpritesLength() - 1);
                            controller.setSprites(controller.getSprites().size() - 1);
                        }
                    } catch (eBorderExceedingException ex) {
                        JOptionPane.showMessageDialog(controller, ex.getMessage());
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        try{
            Thread.sleep(16);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        float deltaTime = (System.nanoTime() - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = System.nanoTime();
        repaint();
    }

    public int getLeft() {return 0;}
    public int getRight() {return getWidth() - 1;}
    public int getTop() {return 0;}
    public int getBottom() {return getHeight() - 1;}
}
