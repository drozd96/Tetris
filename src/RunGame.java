import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class RunGame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 500;
    public static final Color BACKGROUND = Color.white;
    public static final int SHIFT = 25;

    public static void main(String[] args) {
        RunGame run = new RunGame();
        run.startGame();
    }

    private void startGame() {
        JFrame frame = new JFrame();
        frame.setBackground(BACKGROUND);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Shape newShape = Shape.getInstance();
        frame.addKeyListener(newShape);
        frame.getContentPane().add(newShape);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);

        newShape.fallShape();
    }
}