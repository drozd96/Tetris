import java.awt.*;

public class Line extends Shape {

    private int position_x;
    private int position_y;
    private static final int WIDTH_SIZE = 25;
    private static final int HEIGHT_SIZE = 100;
    private static final Color COLOR = Color.BLUE;

    Line() {
        position_x = (RunGame.WIDTH - WIDTH_SIZE) / 2;
    }

    @Override
    public void rotateLeft() {

    }

    @Override
    public void rotateRight() {

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
        if(position_x <= RunGame.WIDTH - WIDTH_SIZE - RunGame.SHIFT)
            position_x += RunGame.SHIFT;
    }

    @Override
    public boolean isEnd() {
        if(position_y >= RunGame.HEIGHT - HEIGHT_SIZE)
            return true;
        return false;
    }

    public void paintComponent(Graphics g) {
        g.setColor(RunGame.BACKGROUND);
        g.fillRect(0,0, RunGame.WIDTH, RunGame.HEIGHT);

        g.setColor(COLOR);
        g.fillRect(position_x, position_y, WIDTH_SIZE, HEIGHT_SIZE);
    }
}
