import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;

/**
 * The "VIEW" of Model-View-Controller
 * An instance of this gui contains a reference to the Controller and the Model.
 * @author Amy Larson (with Erik Steinmetz)
 */
public class TicTacToeGUI extends JFrame {

    // Controller GUI Components
    private final JButton restart = new JButton("Play Again");

    private JLabel player = new JLabel("Turn: Player X");
    private JLabel winner = new JLabel("");
    private JLabel imageLabel = new JLabel("");

    private Icon iconX = new ImageIcon("images/x.png");
    private Icon iconO = new ImageIcon("images/o.png"); 
    private Icon iconWhite = new ImageIcon("images/white.png");
    private ImageIcon dance = new ImageIcon("images/dancing.gif");

    private JButton[][] boxes = new JButton[3][3];

    /**
     * Creates a Simulation GUI application.
     * Sets the components and their positions in the gui.
     * Sets the Controller as the buttons' action listener.
     */
    public TicTacToeGUI(Controller control, GameModel model) {

        // Initialize the graphics window
        super("Tic Tac Toe Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setSize(800,900);
        // You control the layout
        this.getContentPane().setLayout(null);

        winner.setFont(new Font("Serif", Font.PLAIN, 36));
        this.winner.setBounds(100,50,500,100);
        this.getContentPane().add(this.winner);

        player.setFont(new Font("Serif", Font.PLAIN, 24));
        this.player.setBounds(100,100,500,100);
        this.getContentPane().add(this.player);

        imageLabel.setBounds(600,-50,200,300);

        for (int r=0; r<3; r++ ) {
            for (int c=0; c<3; c++) {
                boxes[r][c] = new JButton();
                boxes[r][c].setBounds(c*200+100,(r+1)*200,190,190);
                boxes[r][c].setActionCommand("b"+r+c);
                boxes[r][c].addActionListener(control);
                getContentPane().add(boxes[r][c]);
            }
        }
    }
    public void winner(GameModel.Players w) {
        String s = "WINNER PLAYER "+w;
        winner.setText(s);
        player.setText("");
        imageLabel.setIcon(dance);
        getContentPane().add(imageLabel, java.awt.BorderLayout.CENTER);
    }

    public void setPlayer(GameModel.Players p) {
        String s = "Turn: Player "+p;
        player.setText(s);
    }
    public void markBox(int r, int c, GameModel.Players p) {
        if (p==GameModel.Players.X) {
            boxes[r][c].setIcon(iconX);
        } else {
            boxes[r][c].setIcon(iconO);
        }
    }
}
