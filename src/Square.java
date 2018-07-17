import java.awt.*;

public class Square extends Shape {
    // The current position of the shape
    private int curr_x;
    private int curr_y;
    // The previous position of the shape
    private int prev_x;
    private int prev_y;

    // if the shape was moved, firstly clear previous trace, than return previous position to current
    private boolean isMoved = false;

    private static final int SIZE = 50;
    private static final Color COLOR = Color.GREEN;

    Square() {
        curr_x = (RunGame.WIDTH - SIZE) / 2;
        prev_x = curr_x;
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
        prev_y = curr_y;
        if(!isMoved) {
            prev_x = curr_x;
        } else {
            isMoved = false;
        }
        curr_y++;
    }

    @Override
    public void moveLeft() {
        if(SIZE >= RunGame.SHIFT) {
            prev_x = curr_x;
            curr_x -= RunGame.SHIFT;
            isMoved = true;
        }
    }

    @Override
    public void moveRight() {
        if(curr_x <= RunGame.WIDTH - SIZE - RunGame.SHIFT) {
            prev_x = curr_x;
            curr_x += RunGame.SHIFT;
            isMoved = true;
        }
    }

    @Override
    public boolean isEnd() {
        if(curr_y + SIZE == RunGame.HEIGHT)
            return true;
        return false;
    }

    private void clearTrace(Graphics g) {
        g.setColor(RunGame.BACKGROUND);
        g.fillRect(prev_x, prev_y, SIZE, SIZE);
    }

    public void paintComponent(Graphics g) {
        clearTrace(g);
        g.setColor(COLOR);
        g.fillRect(curr_x, curr_y, SIZE, SIZE);
    }
}
