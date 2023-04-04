/*
 * Circle Model.java
 */

import java.util.ArrayList;
import java.lang.Thread;

/**
 * Models a collection of circles roaming about impacting other circles.
 * 
 * @author Amy Larson (with Erik Steinmetz)
 */
public class MovementModel extends Model {

    /** Default constructor. */
    public MovementModel() {
        super();
    }

    public void populate() {

        for (int i = 0; i < count(); i++) {
            agents.add(new MovementAgent());
        }
    }

    @Override
    public void advanceAgents() {
        for (Agent agent : agents) {
            agent.step();
        }
    }

    @Override
    public void updateAgents() {
        // This is a model of simple movement. Agents do not effect other agents.
    }

    public void reset() {
        agents = new ArrayList<>();
        for (int i = 0; i < count(); i++) {
            agents.add(new MovementAgent());
        }
    }
}
