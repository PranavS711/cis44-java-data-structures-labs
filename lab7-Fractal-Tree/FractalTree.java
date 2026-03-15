import javax.swing.*;
import java.awt.*;

/**
 * This class draws a recursive fractal tree using Java Swing.
 */
public class FractalTree extends JPanel {

    private final int MAX_DEPTH = 9; // maximum recursion depth

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Start recursion from the bottom center of the panel
        int startX = getWidth() / 2;
        int startY = getHeight() - 50;
        drawTree(g, startX, startY, -90, MAX_DEPTH);
    }

    /**
     * Recursively draws a fractal tree.
     * @param g Graphics object to draw on
     * @param x1 Starting x-coordinate
     * @param y1 Starting y-coordinate
     * @param angle Angle of the current branch
     * @param depth Current depth of recursion
     */
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        // base case: stop recursion if depth is 0
        if (depth == 0) return;

        // calculate branch length (smaller for deeper recursion)
        int length = depth * 10;

        // calculate end point of the branch using trigonometry
        int x2 = x1 + (int)(length * Math.cos(Math.toRadians(angle)));
        int y2 = y1 + (int)(length * Math.sin(Math.toRadians(angle)));

        // draw the branch
        g.drawLine(x1, y1, x2, y2);

        // recursive calls for left and right sub-branches
        drawTree(g, x2, y2, angle - 20, depth - 1); // left branch
        drawTree(g, x2, y2, angle + 20, depth - 1); // right branch
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700); // window size
        frame.add(new FractalTree()); // add our panel
        frame.setLocationRelativeTo(null); // center on screen
        frame.setVisible(true); // show the window
    }
}
