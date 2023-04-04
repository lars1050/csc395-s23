/*
 * Controller.java
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.text.DecimalFormat;
/**
 * The controller class for the temp converter application.
 * @author Amy Larson (with Erik Steinmetz)
 */
public class Controller implements ActionListener, ItemListener {
    
    /** The model of the circles. */
    private static Model model;

    /** The gui for the simulation. */
    private static View view;
    
    /** Default constructor to set up the viewer
     */
    public Controller() {
        model = new MovementModel();
        ViewArena.setAgentView("Circle");

        //model = new FlockingModel();
        //ViewArena.setAgentView("Boid");

        view = new View(this,model);

        model.setView(view);
        view.setVisible(true);
        model.start();
    }

    public void itemStateChanged(ItemEvent e){
        //System.out.println("CHECKED "+e.getSource());
        
        //String agentView = ((JCheckBox)(e.getSource())).getText();
        view.setAgentView(((JCheckBox)e.getSource()).getText());        
    }
    
    /**
     * Performs the actions for each of the JButtons
     * @param ae The event which occurred, identifying which button was pushed.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        //System.out.println("Action called: " + ae);
        if( ae.getActionCommand().equals("Set Up")) {

            // Set the model on pause
            model.pause();

            // Create the circles based on count
            Integer count = Integer.valueOf(view.count.getText());
            model.setCount(count);
            view.resetArena();

            // Set the speed of the simulation
            Integer speed = Integer.valueOf(view.speedSlider.getValue());
            model.setSpeed(speed);
        }
        else if( ae.getActionCommand().equals( "Stop")) {
            model.pause();
        }

        else if( ae.getActionCommand().equals( "Play")) {
            model.play();
        }
    }
}
