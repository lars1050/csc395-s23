import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Circle for drawing in a JFrame
 *
 * @author Amy Larson
 */
public class ViewableCircle extends Viewable {

    private MovementAgent boid;

    public ViewableCircle(Agent b) {
        super(b);
        boid = (MovementAgent) b;
        this.setSize(boid.getRadius()*2, boid.getRadius()*2);

        // Make the box/panel on which the circle is drawn transparent
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
    }

    /** Default constructor.  */
    public ViewableCircle() {
    }

    @Override
    public void draw() {
        //paintComponent(getGraphics());
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        // This is called every time the circle location is reset in the CircleModel
        //System.out.print("Painting a boid "+boid.getRadius());
        super.paintComponent(g);
        //setLocation((int)boid.getPosition().x,(int)boid.getPosition().y);
        g.setColor(boid.getColor());
        g.fillOval(0, 0, boid.getRadius()*2, boid.getRadius()*2);
    }

    public Vector2d getPosition() {
        return boid.getPosition();
    }
}

