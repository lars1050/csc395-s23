import javax.swing.JPanel;

public abstract class Viewable extends JPanel  {

    protected Agent agent;

    public Viewable() {}

    public Viewable(Agent a) {
        agent = a;
    }

    public Vector2d getPosition() {
        return agent.getPosition();
    }

    public abstract void draw();
}