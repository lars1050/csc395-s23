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
    private final GameModel model = new GameModel();
    /** The gui for the simulation. */
    private final TicTacToeGUI view;

    private boolean ignoring = false;
    
    /** Default constructor to set up the viewer
     */
    public Controller() {
        view = new TicTacToeGUI(this,model);
        model.setSim(view);
        view.setVisible(true);
    }
    
    /**
     * Performs the actions for each of the JButtons
     * @param ae The event which occurred, identifying which button was pushed.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ignoring) {
            return;
        }
        String button = ae.getActionCommand();
        Integer row = button.charAt(1)-'0';
        Integer col = button.charAt(2)-'0';
        //System.out.println("EXTRACTED row col "+row+" "+col);
        if (!model.valid(row,col)) {
            return;
        }
        view.markBox(row,col,model.getPlayer());

        model.selected(row, col);   // changes the player in the model

        GameModel.Players winner = model.winner();
        if (winner!=null) {
            view.winner(winner);
            ignoring = true;
        } else {
            view.setPlayer(model.getPlayer());
        }
    }
}
