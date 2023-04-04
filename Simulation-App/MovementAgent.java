import java.util.Random;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Agent in a simulation
 *
 * @author Amy Larson
 * 
 * A Boid moves within a fixed sized simulation arena.
 * All positions will be relative to the origin of the arena (upper left corner)
 */
public class MovementAgent extends Agent {

    /** Unique id (for debugging) */
    static int nextId = 0;
    static int getId() {
        return nextId++;
    }
    private int id;

    private int radius = 5;

    public void setRadius(int r) {
        radius = r;
    }
    public int getRadius() {
        return radius;
    }

    /** Default constructor */
    public MovementAgent() {
        super();
        id = getId(); // for debugging
    }

        /** Move the robot the "delta" for 1 timestep */
    /** Move the robot the "delta" for 1 timestep */
    @Override 
    public void update(ArrayList<Agent> boids) {
    }

    @Override
    public void step() {
        position.add(velocity);
        checkBorders();
    }

    private void checkBorders() {
        if (position.x<=0) {
            position.x = 1;
            velocity.x = -velocity.x;
        }
        if (position.y<=0) {
            position.y = 1;
            velocity.y = -velocity.y;
        }
        if (position.x>=box.width-radius*2) {
            position.x = box.width-radius*2;
            velocity.x = -velocity.x;
        }
        if (position.y>=box.height-radius*2) {
            position.y = box.height-radius*2;
            velocity.y = -velocity.y;
        }
    }
}

