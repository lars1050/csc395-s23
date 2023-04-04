/*
 * Circle Model.java
 */

import java.util.ArrayList;
import java.lang.Thread;

/**
 * Models a collection of agents roaming about.
 * 
 * @author Amy Larson
 */
public abstract class Model extends Thread {

    /** Collection of (abstract) agents */
    protected ArrayList<Agent> agents = new ArrayList<>();

    /** Current number of agents in the model */
    private int count = 0;

    /** Pauses simulation so agents do not move */
    private boolean paused = true;

    /** Maximum number of agents possible in environment */
    private int maxAgents = 200;

    /** Thread sleep (in ms) controls speed of movement */
    private int speed = 100;

    /** View that will show the model.
     * Uses to inform the view when model has changed.
     */
    private View view;


    /** Default constructor calling the concrete populate
     * This should create all agents for the model
     */
    public Model() {
        populate();
    }

    /** Populate agents list with new agents */
    public abstract void populate();

    /** Repopulate by creating new array and populate. */
    public abstract void reset();


    @Override
    public void run() {
        // Forever run the simulation
        while (true) {
            // Move things only if the simulation is not paused
            if (!paused) {
                advanceAgents();    // update position
                view.update();      // move in the graphics window
                updateAgents();     // make adjustments to agents based on new positioning
            }
            try {
                Thread.sleep(speed);
            } catch (Exception e) {

            }
        }
    }

    /** Move agents to next location */
    public abstract void advanceAgents();

    /* This is the most likely implementation, but leaving it up to model builders
    public void advanceAgents() {
        for (Agent agent : agents) {
            agent.step();
        }
    }
    */

    /** Adjust agents based on forces or influences acting on them  */
    public abstract void updateAgents();

    /*  This is the most likely implementation, but leaving it up to model builders
    public void updateAgents() {
        for (Agent agent : agents) {
            agent.update(agents);
        }
    }
    */

    /** Pause the simulation - agents freeze. */
    public void pause() {
        paused = true;
    }

    /** Agents move again */
    public void play() {
        System.out.println("Playing now");
        paused = false;
    }


    /** Reset agents in the model */
    public void setCount(int aCount) {
        System.out.println("Making agents!");
        // Cannot set outside of bounds
        if (aCount < 2) {
            count = 2;
        } else if (aCount > maxAgents) {
            count = maxAgents;
        } else {
            count = aCount;
        }
        reset();    // new population of specified size
    }

    //________________________________________________________
    //_________________________ Getters and Setters

    public boolean isPaused() {
        return paused;
    }

    public int count() {
        return count;
    }

    public int maxAgents() {
        return maxAgents;
    }

    public ArrayList<Agent> getAgents() {
        return agents;
    }

    public void setSpeed(int ms) {
        speed = ms;
    }

    public void setView(View sim) {
        view = sim;
    }

    public View view() {
        return view;
    }

}
