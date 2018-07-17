import java.awt.*;

public class Line extends Shape {
    // The current position of the shape
    private int curr_x;
    private int curr_y;
    
    // The previous position of the shape
    private int prev_x;
    private int prev_y;

    private boolean isMoved = false;
    
    private static final int WIDTH_SIZE = 25;
    private static final int HEIGHT_SIZE = 100;
    private static final Color COLOR = Color.BLUE;

    Line() {
        curr_x = (RunGame.WIDTH - WIDTH_SIZE) / 2;
        prev_x = curr_x;
    }

    @Override
    public void rotateLeft() {

    }

    @Override
    public void rotateRight() {

    }

    @Override
    public void moveDown() {
        prev_y = curr_y;
        curr_y++;
        if(!isMoved)
            prev_x = curr_x;
        else
            isMoved = false;
    }

    @Override
    public void moveLeft() {
        if(curr_x >= RunGame.SHIFT) {
            prev_x = curr_x;
            curr_x -= RunGame.SHIFT;
            isMoved = true;
        }
    }

    @Override
    public void moveRight() {
        if(curr_x <= RunGame.WIDTH - WIDTH_SIZE - RunGame.SHIFT) {
            prev_x = curr_x;
            curr_x += RunGame.SHIFT;
            isMoved = true;
        }
    }

    @Override
    public boolean isEnd() {
        if(curr_y >= RunGame.HEIGHT - HEIGHT_SIZE)
            return true;
        return false;
    }

    private void clearTrace(Graphics g) {
        g.setColor(RunGame.BACKGROUND);
        g.fillRect(prev_x,prev_y, WIDTH_SIZE, HEIGHT_SIZE);
    }

    public void paintComponent(Graphics g) {
        clearTrace(g);
        g.setColor(COLOR);
        g.fillRect(curr_x, curr_y, WIDTH_SIZE, HEIGHT_SIZE);
    }
}
