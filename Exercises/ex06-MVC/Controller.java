/*
 * Controller.java
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.text.DecimalFormat;
/**
 * The controller class for the temp converter application.
 * @author Amy Larson (with Erik Steinmetz)
 */
public class Controller implements ActionListener {
    

    /** The model of the circles. */
    private final CircleModel model = new CircleModel();
    /** The gui for the simulation. */
    private final SimulationGUI view;
    
    /** Default constructor to set up the viewer
     */
    public Controller() {
        view = new SimulationGUI(this,model);
        view.setVisible(true);
        model.start();
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
            Integer count = Integer.valueOf(this.view.count.getText());
            model.setCount(count);

            // Set the speed of the simulation
            Integer speed = Integer.valueOf(this.view.speed.getText());
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
