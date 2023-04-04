import java.util.Random;
import java.util.ArrayList;
import java.awt.Color;

public abstract class Agent {
    
    // The box should be set by the controller, but this is default if not
    protected static Rectangle box = Boundary.AGENT_BOUNDARY;

    protected Vector2d position = new Vector2d(0,0);

    protected Vector2d velocity = new Vector2d(0,0);

    /** Color specified in RGB */
    protected Color color = new Color(10, 10, 10);

    /** Fixed size */
    protected int size = 10;

    /** Circels have many random components */
    private Random random = new Random();

    public Agent() {
        reset();
    }

    /** Reassigns member variables to the agent. */
    public void reset() {
        randomPosition();
        randomVelocity();
        randomColor();
    }
    
    /** Randomly assign the RGB components */
    public void randomColor() {
        // color randomly
        color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    /** Randomly assign its location based on the fixed ranges. */
    public void randomPosition() {
        // place at random location
        position.x = (double) random.nextInt(box.width-size*2) + size;   
        position.y = (double) random.nextInt(box.height-size*2) + size;
    }

    /** Randomly point it in a direction with random "speed" */
    public void randomVelocity() {
        // set in a random direction
        velocity.x = (double) random.nextInt(6) - 3;
        velocity.y = (double) random.nextInt(6) - 3;
    }

    /** Move the agent the "delta" for 1 timestep */
    public abstract void update(ArrayList<Agent> agents);

    public abstract void step();


    public Vector2d getPosition() {
        return position;
    }
    public Vector2d getVelocity() {
        return velocity;
    }

    public Color getColor() {
        return color;
    }

    public void setSize(int s) {
        size = s;
    }

    public int getSize() {
        return size;
    }
}