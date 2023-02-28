/**
 * Models a collection of circles roaming about impacting other circles.
 * @author Amy Larson (with Erik Steinmetz)
 */
public class GameModel {

    public static enum Players {NONE,X,O};

    private Players[][] board = new Players[3][3];
    private int[] rowsTotal = {0,0,0};
    private int[] colsTotal = {0,0,0};
    private int leftRightTotal;
    private int rightLeftTotal;
    private Players turn = Players.X;

    private int fillCount = 0;


    private TicTacToeGUI gui;

    /** Default constructor. */
    public GameModel() {
        reset();
    }

    public void reset() {
        for (int r=0; r<3; r++) {
            for (int c=0; c<3; c++) {
                board[r][c] = Players.NONE;
            }
        }
        fillCount = 0;
    }

    public void setSim(TicTacToeGUI gui) {
        this.gui = gui;
    }

    /** Set speed of simulation from 1 (slow) to 5 (fast) */
    public boolean valid(int r, int c) {
        if (board[r][c] != Players.NONE) {
            return false;
        }
        return true;
    }
    public void selected(int r, int c) {
        if (!valid(r, c)) {
            return;
        }
        board[r][c] = turn;
        fillCount++;
        if (turn==Players.X) {
            rowsTotal[r]++;
            colsTotal[c]++;
            if (r==c) {
                leftRightTotal++;
            }
            if ((r+c)==2) {
                rightLeftTotal++;
            }
            turn = Players.O;
        } else {
            rowsTotal[r]--;
            colsTotal[c]--;
            if (r==c) {
                leftRightTotal--;
            }
            if ((r+c)==2) {
                rightLeftTotal--;
            }
            turn = Players.X;
        }
    }
    public Players winner() {
        Players w = null;
        if (leftRightTotal==3 || rightLeftTotal==3) {
            w = Players.X;
        } else if (leftRightTotal==-3 || rightLeftTotal==-3) {
            w = Players.O;
        } else {
            for (int i=0; i<3; i++) {
                if ((rowsTotal[i]==3) || (colsTotal[i]==3)) {
                    w = Players.X;
                } else if ((rowsTotal[i]==-3) || (colsTotal[i]==-3)) {
                    w = Players.O;
                }
            }
        }
        return w;
    }
    public Players getPlayer() {
        return turn;
    }
}
