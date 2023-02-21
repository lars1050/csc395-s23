/** Helper class to store xy locations */
public class Point {
    /** Making public for each access. */
    public int x = 0;
    public int y = 0;
    
    public Point(int xx, int yy) {
        x = xx;
        y = yy;
    }

    public String toString() {
        return "["+x+","+y+"]";
    }
}