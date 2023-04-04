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
public class FlockingModel extends Model {

    /** Default constructor. */
    public FlockingModel() {
        super();
    }
    public void populate() {

        for (int i = 0; i < count(); i++) {
            agents.add(new FlockingAgent());
        }
    }

    public void advanceAgents() {
        for (Agent agent : agents) {
            agent.step();
        }
    }

    public void updateAgents() {
        for (Agent agent : agents) {
            agent.update(agents);
        }
    }

    public void reset() {
        agents = new ArrayList<>();
        for (int i = 0; i < count(); i++) {
            agents.add(new FlockingAgent());
        }
    }
}
