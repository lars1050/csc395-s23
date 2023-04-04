public class ViewableFactory {

    public Viewable getViewable(String type, Agent agent) {
        
        if (type.equals("Circle")) {
            return new ViewableCircle(agent);
        } else if (type.equals("Square")) {
            return new ViewableSquare(agent);
        } else if (type.equals("Boid")) {
            return new FlockingViewable(agent);
        }
        return new ViewableCircle(agent);
    }

}