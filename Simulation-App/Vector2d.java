/** Helper class to store xy locations */
public class Vector2d {
    /** Making public for each access. */
    public double x = 0.0;
    public double y = 0.0;
    
    public Vector2d(double xx, double yy) {
        x = xx;
        y = yy;
    }

    public static Vector2d subtract(Vector2d one, Vector2d two) {
        return new Vector2d(one.x-two.x, one.y-two.y);
    }

    public double magnitude() {
        return Math.sqrt(x*x+y*y);
    }

    public void add(Vector2d operand) {
        x += operand.x;
        y += operand.y;
    }

    public void subtract(Vector2d operand) {
        x -= operand.x;
        y -= operand.y;
    }


    public void multiply(double scaler) {
        x = x*scaler;
        y = y*scaler;
    }

    public void divide(double scaler) {
        x = x/scaler;
        y = y/scaler;
    }

    public double distance(Vector2d operand) {
        double dx = x-operand.x;
        double dy = y-operand.y;
        return Math.sqrt(dx*dx+dy*dy);
    }

    public void normalize() {
        double angle = Math.atan2(y,x);
        x = Math.cos(angle);
        y = Math.sin(angle);
    }

    public void limit(double maxmag) {
        if (magnitude()>maxmag) {
            normalize();
            multiply(maxmag);
        }
    }

    public String toString() {
        return "["+x+","+y+"]";
    }
}