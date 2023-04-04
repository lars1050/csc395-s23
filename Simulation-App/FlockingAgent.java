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
public class FlockingAgent extends Agent {

    // The box should be set by the controller, but this is default if not
    private static Rectangle box = Boundary.AGENT_BOUNDARY;

    /** Unique id (for debugging) */
    static int nextId = 0;
    static int getId() {
        return nextId++;
    }
    private int id;

    public static final int maxspeed = 4;
    public static final double maxforce = .3;
    public static final int neighborhood = 75;
    public static final int proximity = 40;

    private int radius = 5;

    public void setRadius(int r) {
        radius = r;
    }
    public int getRadius() {
        return radius;
    }

    /** Default constructor */
    public FlockingAgent() {
        super();
        id = getId(); // for debugging
    }

        /** Move the robot the "delta" for 1 timestep */
    /** Move the robot the "delta" for 1 timestep */
    @Override 
    public void update(ArrayList<Agent> boids) {
        calculateForces(boids);
    }

    private void calculateForces(ArrayList<Agent> boids) {

        // Calculate the average position, direction, separation in this boid's neighborhood
        int neighborCount = 0;
        int proximityCount = 0;

        Vector2d cohesion = new Vector2d(0.0,0.0);
        Vector2d alignment = new Vector2d(0.0,0.0);
        Vector2d separation = new Vector2d(0.0,0.0);

        for (Agent agent: boids) {
            FlockingAgent other = (FlockingAgent) agent;
            if (this==other) {
                continue;
            }
            double distance = position.distance(other.getPosition());

            if (distance <= neighborhood) {
                cohesion.add(other.getPosition());
                alignment.add(other.getVelocity());
                neighborCount++;
            }
            if (distance <= proximity) {
                // Calculate vector pointing away from neighbor
                Vector2d difference = Vector2d.subtract(position,other.getPosition());
                difference.normalize();
                difference.divide(distance);        // Weight by distance
                separation.add(difference);
                proximityCount++; 
            } // end inner for loop
        }

        // Average for position and direction in neighborhood
        if (neighborCount > 0) {
            cohesion.divide(neighborCount);
            alignment.divide(neighborCount);
        }

        if (neighborCount > 0) {
            cohesion.subtract(position);
            cohesion.normalize();
            cohesion.multiply(maxspeed);
            cohesion.subtract(getVelocity());
            cohesion.limit(maxforce);  // Limit to maximum steering force
        } 

        if (neighborCount > 0) {
            // Implement Reynolds: Steering = Desired - Velocity
            alignment.normalize();
            alignment.multiply(maxspeed);
            alignment.subtract(getVelocity());
            alignment.limit(maxforce);
        }

        // Average separation
        if (proximityCount > 0) {
            separation.divide(proximityCount);
        }
        // As long as the vector is greater than 0
        if (separation.magnitude() > 0) {
            // Implement Reynolds: Steering = Desired - Velocity
            separation.normalize();
            separation.multiply(maxspeed);
            separation.subtract(getVelocity());
            separation.limit(maxforce);
        }
        separation.multiply(1.5);
        alignment.multiply(1.0);
        cohesion.multiply(1.0);

        // apply those forces
        applyForces(alignment, cohesion, separation);
    }

    private void applyForces(Vector2d align, Vector2d cohesion, Vector2d separation) {
        velocity.add(align);
        velocity.add(cohesion);
        velocity.add(separation);
        velocity.limit(maxspeed);
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

