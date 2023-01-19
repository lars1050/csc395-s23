import java.util.Random;

/** Generic Robot */
public class Robot {

  Random rand = new Random();

  private String name;

  /** Current location in a fixed grid covering 1000x1000 pixels */
  private Point location = new Point();

  /** Maximum distance to detect an obstacle */
  private int maxDistance = 50;

  /** Default Constructor */
  public Robot() {
    this("Anonymous");
  }

  /** Constructor */
  public Robot(String name) {
    this.name = name;

    // Place the robot at a random location within the fixed grid
    location.x = rand.nextInt(1000) - 500;
    location.y = rand.nextInt(1000) - 500;
  }

  /** Prints general information */
  public void describe() {
    System.out.println("I am "+name+" located at "+location);
  }

  /** Moves the robot in the specified direction and speed. */
  public void move(int heading, int distance) {
    System.out.printf("Heading %d degrees for %d units.%n",heading, distance);

    // Calculate the new location based on the requested movement
    double radians = heading * Math.PI/180.0;
    location.x = location.x + (int)(distance * Math.cos(radians));
    location.y = location.y + (int)(distance * Math.sin(radians));
    System.out.println("Moved to "+location);
  }

  /** Reports if obstacle ahead */
  public void sense() {
    // Randomly generate a reading of an obstacle in the environment
    // It can be as close as 2 or beyond the max (thus not visible)
    int distance = rand.nextInt(maxDistance*2) + 2;
    if (distance > maxDistance) {
      System.out.println("No obstacles ahead");
    } else {
      System.out.printf("Obstacle %d units ahead.%n",distance);
    }
  }

  //______________________________________________________________
  // All below are getters and setters for class member variables

  public void setName(String value) { 
    name = value; 
  }
  public String getName() { 
    return name; 
  }

  public void setLocation(Point point) { 
    location = point; 
  }
  public Point getLocation() { 
    return location; 
  }

  public void setMaxDistance(int value) {
    maxDistance = value;
  }
  public int getMaxDistance() {
    return maxDistance;
  }
}
