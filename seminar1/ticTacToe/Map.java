package seminar1.ticTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {

    private int panelWidth;
    private int panelHeight;
    private int cellWidth;
    private int cellHeight;

    private static final Random RANDOM = new Random();
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;
    private int fieldSizeY = 3;
    private int fieldSizeX = 3;
    private int winLength  = 3;
    private char [][] field;

    private final int DOT_PADDING = 12;


    private int gameOverType;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAH = 1;
    private static final int STATE_WIN_AI = 2;

    private static final String MSG_WIN_HUMAH = "Победил игрок!";
    private static final String MSG_WIN_AI = "Победил компьютер!";
    private static final String MSG_DRAW = "Ничья!";


    private boolean isGameOver;
    private boolean isInitialized;


    Map(){
        setBackground(Color.DARK_GRAY);
        isInitialized = false;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }

    private void update(MouseEvent e){
        if (isGameOver || !isInitialized) return;

        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellX][cellY] = HUMAN_DOT;
        //System.out.printf("x=%d, y=%d\n",cellX, cellY);
        repaint();
        if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAH)) return;

        aiTurn();
        repaint();

        if (checkEndGame(AI_DOT, STATE_WIN_AI)) return;
        repaint();
    }

    private boolean checkEndGame(int dot, int gameOverType){
        if (checkWin((char) dot)) {
            this.gameOverType = gameOverType;
            isGameOver = true;
            repaint();
            return true;
        }
        if (isMapFull()) {
            this.gameOverType = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }

    public void startNewGame(int mode, int fSzX, int fSzY, int wLen){
        fieldSizeX = fSzX;
        fieldSizeY = fSzY;
        winLength = wLen;
        isGameOver = false;
        isInitialized = true;
        initMap();
        repaint();
        //System.out.printf("Mode: %d;\nSize: x=%d; y=%d;\nWin Length: %d", mode, fSzX, fSzY, wLen);
    }

    public void render(Graphics g){
        if (!isInitialized) return;

        panelWidth = getWidth();
        panelHeight = getHeight();
        cellWidth = panelWidth / fieldSizeX;
        cellHeight = panelHeight / fieldSizeY;

        g.setColor(Color.yellow);
        for (int h = 1; h < fieldSizeY; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int w = 1; w < fieldSizeX; w++) {
            int x = w * cellWidth;
            g.drawLine(x,0, x, panelHeight);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[x][y] == EMPTY_DOT) continue;
                if (field[x][y] == HUMAN_DOT){
                    g.setColor(Color.BLUE);
                    g.fillOval(x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);
                } else if (field[x][y] == AI_DOT) {
                    g.setColor(Color.RED);
                    g.fillOval(x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException("Unexpected value " + field[x][y] +
                            " in cell: x=" + x + " y=" + y);
                }
            }
        }

        if (isGameOver) showMessageGameOver(g);
        repaint();
    }

    private void showMessageGameOver(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.yellow);
        g.setFont(new Font("Times New Roman", Font.BOLD, 48));
        switch (gameOverType){
            case STATE_DRAW -> g.drawString(MSG_DRAW, 180, getHeight()/2);
            case STATE_WIN_HUMAH -> g.drawString(MSG_WIN_HUMAH, 70, getHeight()/2);
            case STATE_WIN_AI -> g.drawString(MSG_WIN_AI, 20, getHeight()/2);
            default -> throw new RuntimeException("Unexpected gameover state: " + gameOverType);
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        render(g);
    }

    private void initMap(){
        field = new char[fieldSizeY][fieldSizeX];

        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private boolean isValidCell(int x, int y){
        return x>=0 && x<fieldSizeX && y>=0 && y<fieldSizeY;
    }

    private boolean isEmptyCell(int x, int y){
        return field[x][y] == EMPTY_DOT;
    }

    private void aiTurn(){
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[x][y] = AI_DOT;
    }

    private boolean checkWin(char c){
        boolean result = false;
        int counterRow = 0;
        int counterCol = 0;

        // вертикаль и горизонталь
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == c) {
                    counterCol++;
                } else {
                    counterCol = 0;
                }
                if (field[j][i] == c) {
                    counterRow++;
                } else {
                    counterRow = 0;
                }
            }
            if (counterCol == winLength) return true;
            counterCol = 0;
            if (counterRow == winLength) return true;
            counterRow = 0;
        }

        // диагонали
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == c) {
                    if (rightDownDiagonalCheck(i, j, c)) return true;
                    if (rightUpDiagonalCheck(i, j, c)) return true;
                }
            }
        }

        return result;
    }

    private boolean rightDownDiagonalCheck(int x, int y, char c){
        boolean result = false;
        int counterDiag = 0;

        if ( x + winLength > fieldSizeX) return result;
        if ( y + winLength > fieldSizeY) return result;

        for (int i = 0; i < winLength; i++) {
            if (field[x][y] == c) {
                counterDiag++;
                x++; y++;
            } else {
                break;
            }
            if (counterDiag == winLength) return true;
        }
        return result;
    }

    private boolean rightUpDiagonalCheck(int x, int y, char c){
        boolean result = false;
        int counterDiag = 0;

        if ( x + winLength > fieldSizeX) return result;
        if ( y - winLength < -1) return result;

        for (int i = 0; i < winLength; i++) {
            if (field[x][y] == c) {
                counterDiag++;
                x++; y--;
            } else {
                break;
            }
            if (counterDiag == winLength) return true;
        }
        return result;
    }

    private boolean isMapFull(){
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

}
