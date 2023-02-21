import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.BasicStroke;

/** Creates an outline of a transparent box */
public class BoundingBox extends JPanel {

    // width and height set in the constructor
    int height;
    int width;

    /** Constructor specifies height and width of bounding box within a JFrame */
    public BoundingBox(int h, int w) {
        height = h;
        width = w;
        setSize(height,width);
        // Setting the background as transparent
        setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawRect(0,0,height,width);
    }
}