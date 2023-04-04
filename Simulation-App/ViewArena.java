import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JSlider;

import java.awt.Color;
import java.util.ArrayList;

public class ViewArena extends JPanel {

    /** Agents to be viewed in arena */
    private ArrayList<Agent> agents;

    /** Wrappers for Agents used to draw them in the graphics window */
    private ArrayList<Viewable> viewables;

    /** Boundary of arena with respect to the graphics window */
    private Rectangle box = Boundary.MODEL_ARENA;

    /** Viewable shape of the agents */
    private static String agentType = "Circle";

    /** Constructor for various concrete types of Viewable */
    private ViewableFactory factory = new ViewableFactory();

    /** Constructor to build arena
     * @param agents List of agents to place in arena
     * @param graphics frame in which to place agents
     */
    public ViewArena(ArrayList<Agent> agents, JFrame frame) {

        // Graphics setLocation to place in graphics window
        setLocation(box.x, box.y);
        setBackground(new Color(255,255,255));
        setBounds(box.x, box.y, box.width, box.height);

        // save agents, then add to arena
        this.agents = agents;
        addAgents(agents, frame);
    } // end constructor


    /** Add agents to arean by wrapping in Viewable */
    public void addAgents(ArrayList<Agent> agents, JFrame frame) {

        viewables = new ArrayList<>();

        // Wrap each agent in a Viewable
        for (Agent agent: agents) {
            viewables.add(factory.getViewable(agentType,agent));
        }
    
        // Place the agent in the viewing frame
        for (Viewable viewable: viewables) {
            //System.out.println("trying to add to frame");
            viewable.setLocation(
                (int)viewable.getPosition().x+box.x,
                (int)viewable.getPosition().y+box.y);
            frame.getContentPane().add(viewable);
        }
    }

    /** Redraw agents at current location */
    public void update() {
        //System.out.println("drawing viewables");
        for (Viewable viewable: viewables) {
            viewable.setLocation(
                (int)viewable.getPosition().x+box.x,
                (int)viewable.getPosition().y+box.y);
            viewable.draw();
        }
    }

    /** Reset viewables in arena */
    public void reset(ArrayList<Agent> agents, JFrame frame) {
        removeAgents(frame);
        addAgents(agents,frame);
    }

    /** Remove all viewables from the arena */
    public void removeAgents(JFrame frame) {
        for (Viewable viewable: viewables) {
            frame.getContentPane().remove(viewable);
        }
    }

    public static void setAgentView(String s) {
        agentType = s;
    }
    public static String getAgentView() {
        return agentType;
    }
} // end simulation arena

