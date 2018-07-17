import com.sun.corba.se.impl.presentation.rmi.StubInvocationHandlerImpl;

import java.awt.*;

public class Square extends Shape {
    private int position_x;
    private int position_y;
    private static final int SIZE = 50;
    private static final Color COLOR = Color.GREEN;

    Square() {
        position_x = (RunGame.WIDTH - SIZE) / 2;
    }

    @Override
    public void rotateLeft() {
        // do nothing
    }

    @Override
    public void rotateRight() {
        // do nothing
    }

    @Override
    public void moveDown() {
        position_y++;
    }

    @Override
    public void moveLeft() {
        if(position_x >= RunGame.SHIFT)
            position_x -= RunGame.SHIFT;
    }

    @Override
    public void moveRight() {
        if(position_x <= RunGame.WIDTH - SIZE - RunGame.SHIFT)
            position_x += RunGame.SHIFT;
    }

    @Override
    public boolean isEnd() {
        if(position_y + SIZE == RunGame.HEIGHT)
            return true;
        return false;
    }

    private void clearTrace(Graphics g) {
        g.setColor(RunGame.BACKGROUND);
        g.fillRect(position_x, position_y - 1, position_x + RunGame.SHIFT, 1);
    }

    public void paintComponent(Graphics g) {
     //   g.setColor(RunGame.BACKGROUND);
     //   g.fillRect(0,0, RunGame.WIDTH, RunGame.HEIGHT);
        clearTrace(g);
        g.setColor(COLOR);
        g.fillRect(position_x, position_y, SIZE, SIZE);
    }
}
