public class Rectangle {
    public int x = 0;
    public int y = 0;
    public int width = 1;   // range of x in the window
    public int height = 1;  // range of y in the window

    public Rectangle() {
    }

    public Rectangle(int w, int h) {
        width = w;
        height = h;
    }
    public Rectangle(int xx, int yy, int w, int h) {
        x = xx;
        y = yy;
        width = w;
        height = h;
    }

    // No need for getters and setters -- all public
}