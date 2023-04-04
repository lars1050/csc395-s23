public final class Boundary {

    // Private constructor. Not necessary to instantiate the class.
     private Boundary() {}


    /*
     * new Rectangle(x, y, width, height)
     */


     /** Set the size of total window that includes control panel and simulation arena */
    public static Rectangle GRAPHICS_WINDOW = new Rectangle(0,0,1500,1000);

    /** Top of the graphics window reserved for control panel */
    public static int GUI_HEIGHT = 200;

    public static Rectangle CONTROL_PANEL_FIXED = new Rectangle(
        0,0,
        GRAPHICS_WINDOW.width/2,
        GRAPHICS_WINDOW.height
    );

    public static Rectangle CONTROL_PANEL_MODEL = new Rectangle(
        GRAPHICS_WINDOW.width,  // starting column
        0,
        GRAPHICS_WINDOW.width/2,
        GRAPHICS_WINDOW.height
    );

    /** Border around the simulation arena */  
    public static int ARENA_PADDING = 20;
    
    /** Area within the graphics window in which agents move about */
    public static Rectangle MODEL_ARENA = new Rectangle(
        // left border
        GRAPHICS_WINDOW.x+ARENA_PADDING,
        // starting row (below control panel plus some padding)
        GRAPHICS_WINDOW.y+GUI_HEIGHT,//+ARENA_PADDING * why not +padding -- need to think about this
        // total width
        GRAPHICS_WINDOW.width-ARENA_PADDING*2,
        // total height
        GRAPHICS_WINDOW.height-(GUI_HEIGHT + 2*ARENA_PADDING)
    );

    /** Size of the area that an agent can move about.
     * Location of an agent will be adjusted to be within the model arena in the graphics window
     */
    public static Rectangle AGENT_BOUNDARY = new Rectangle(
        0, 0, MODEL_ARENA.width, MODEL_ARENA.height
    );
}