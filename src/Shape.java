import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class Shape extends JPanel implements KeyListener {
    public enum Shapes {SQUARE, LINE}
    public static int speed = 50;

    public abstract void rotateLeft();
    public abstract void rotateRight();
    public abstract boolean isEnd();
    public abstract void moveLeft();
    
    public abstract void moveRight();
    public abstract void moveDown();

    public static Shape getInstance() {
        int shape = (int)(Math.random() * Shapes.values().length);
        switch(shape) {
            case 0: return new Square();
            case 1: return new Line();
            default: return new Square();
        }
    }

    public void fallShape() {
        while (!isEnd()) {
            moveDown();
            repaint();
            try {
                Thread.sleep(speed);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(RunGame.WIDTH, RunGame.HEIGHT);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            decreaseSpeed();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT: this.moveRight();
            break;
            case KeyEvent.VK_LEFT: this.moveLeft();
            break;
            case KeyEvent.VK_DOWN: this.increaseSpeed();
            break;
            default: break;
        }
    }

    private void increaseSpeed() {
        speed = 2;
    }

    private void decreaseSpeed() {
        speed = 50;
    }
}
