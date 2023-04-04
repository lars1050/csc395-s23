import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.lang.model.util.ElementScanner14;
import javax.swing.ButtonGroup;

import java.awt.Color;
import java.util.ArrayList;

/**
 * The "VIEW" of Model-View-Controller
 * An instance of this gui contains a reference to the Controller and the Model.
 * @author Amy Larson (with Erik Steinmetz)
 */
public class View extends JFrame {

    /** The model of the circles. */
    private static Model model;

    /** Controller of MVC */
    private static Controller controller;

    ViewArena arena;

    // {R,G,B} values from 0-255 each
    protected Color backGroundColor = new Color(40, 40, 40);
    protected Color textColor = new Color(192, 96, 0);
    protected Color buttonColor = new Color(200, 200, 200);
    protected Color secondaryColor = new Color(51, 102, 255);

    // Controller GUI Components
    private final JLabel countLabel = new JLabel("Agents (2-100): ");
    protected final JTextField count = new JTextField(10);

    private final JLabel speedLabel = new JLabel("Speed (10-500 ms): ");
    protected final JSlider speedSlider = new JSlider(10, 500);

    private final JLabel agentLabel = new JLabel("Agent View");
    protected final JCheckBox circleOption = new JCheckBox("Circle",false);
    protected final JCheckBox squareOption = new JCheckBox("Square", false);
    protected final JCheckBox flockOption = new JCheckBox("Boid",false);
    protected final ButtonGroup checkGroup = new ButtonGroup();

    private final JButton stop = new JButton("Stop");
    private final JButton play = new JButton("Play");
    private final JButton restart = new JButton("Set Up");   


    /** Default constructor. */
    public View() {}

    /**
     * Creates a Simulation GUI application.
     * Sets the components and their positions in the gui.
     * Sets the Controller as the buttons' action listener.
     */
    public View(Controller control, Model m) {

        // Initialize the graphics window
        super("Simulation");

        this.model = m;
        this.controller = control;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(Boundary.GRAPHICS_WINDOW.width, Boundary.GRAPHICS_WINDOW.height);
   
        // Layout is manual -- not set by swing graphics
        this.getContentPane().setLayout(null);

        // Designated section of graphics window for agents to move about in
        arena = new ViewArena(model.getAgents(),this);
        getContentPane().add(arena);

        // __________________  POPULATION SIZE ___________________
        // Control the size of the agent population used in the model
        countLabel.setBounds(20,20,150,30);
        getContentPane().add(this.countLabel);

        count.setBounds(150, 20, 80, 30);
        getContentPane().add(count);
 
        // __________________  SIMULATION SPEED (in ms) ___________________
        // place the sim speed label and text box
        this.speedLabel.setBounds( 20, 50, 150, 30);
        getContentPane().add(this.speedLabel);
        
        this.speedSlider.setBounds(150, 50, 150, 30);
        getContentPane().add(this.speedSlider);

        // __________________  AGENT VIEW OPTIONS ___________________
        agentLabel.setBounds( 20, 100, 150, 30);
        getContentPane().add(agentLabel);

        if (arena.getAgentView().equals("Square")) {
            squareOption.setSelected(true);
        } else if (arena.getAgentView().equals("Boid")) {
            flockOption.setSelected(true);
        } else {
            circleOption.setSelected(true);
        }

        circleOption.setBounds( 150, 100, 100, 30);
        getContentPane().add(circleOption);
        circleOption.addItemListener(controller);

        squareOption.setBounds( 250, 100, 100, 30);
        getContentPane().add(squareOption);
        squareOption.addItemListener(controller);

        flockOption.setBounds( 350, 100, 100, 30);
        getContentPane().add(flockOption);
        flockOption.addItemListener(controller);

        checkGroup.add(circleOption);
        checkGroup.add(squareOption);
        checkGroup.add(flockOption);

        // __________________  PLAY, PAUSE, RESET ___________________
        // bounds are col, row, width, height

        // place the play and stop buttons
        this.play.setBounds(40, 150, 120, 30);
        this.play.addActionListener(controller);
        getContentPane().add(this.play);
        
        this.stop.setBounds(150, 150, 120, 30);
        this.stop.addActionListener(controller);
        getContentPane().add(this.stop);

        // place the restart button 
        this.restart.setBounds(260, 150, 120, 30);
        this.restart.addActionListener(controller);
        getContentPane().add(this.restart);
    }

    /** Time to redraw the agents */
    //  (it has "subscribed" to the model in a way)
    public void update() {
        arena.update();
        getContentPane().repaint();
    }

    /** Reset the arena to reestablish agents in simulation */
    public void resetArena() {
        arena.reset(model.getAgents(),this);
        getContentPane().add(arena);
        //getContentPane().remove(arena);
        //arena = new SimulationArena(model.getAgents(),this);
        //getContentPane().add(arena);
    }

    /** Determines Viewable (shape) to use for Model */
    public void setAgentView(String s) {
        arena.setAgentView(s);
    }
}