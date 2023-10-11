package seminar2.circles;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    private static final int WINDOW_HEIGHT  = 400;
    private static final int WINDOW_WIDTH   = 400;
    private static final int WINDOW_POSX    = 400;
    private static final int WINDOW_POSY    = 200;

    private ArrayList<Sprite> sprites = new ArrayList<>();
    private int spritesLength = 10;
    private MainWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(WINDOW_POSX, WINDOW_POSY, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);

        for (int i = 0; i < spritesLength; i++) {
            sprites.add(new Ball());
        }

        setVisible(true);
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime){
        update(canvas, deltaTime);
        render(canvas, g);
    }

    public void update(MainCanvas canvas, float deltaTime){
        for (int i = 0; i < spritesLength; i++) {
            sprites.get(i).update(canvas, deltaTime);
        }
    }
    public void render(MainCanvas canvas, Graphics g){
        for (int i = 0; i < spritesLength; i++) {
            sprites.get(i).render(canvas, g);
        }
    }

    public void setSprites(int change) {
        if (this.sprites.size() > change){
            this.sprites.remove(0);
        }
        if (this.sprites.size() < change){
            this.sprites.add(new Ball());
        }
    }

    public ArrayList<Sprite> getSprites() {
        return sprites;
    }

    public int getSpritesLength() {
        return spritesLength;
    }

    public void setSpritesLength(int spritesLength) {
        this.spritesLength = spritesLength;
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
