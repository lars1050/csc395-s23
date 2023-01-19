/** Wheeled Differential Drive Robot using a Camera */
public class WheelTouch extends RobotBad {

  public WheelTouch(String name) {
    setName(name);
  }

  /** Moves the robot in the specified direction and speed. */
  @Override
  public void move(int heading, int distance) {
    System.out.printf("Arcing to %d degrees for %d units.%n",heading, distance);

    // Differential drive means the robot will arc as it rotates and will not get quite as far
    double radians = heading * Math.PI/180.0;
    int x = getLocation().x + (int)((double)distance*7/8 * Math.cos(radians));
    int y = getLocation().y + (int)((double)distance*7/8 * Math.sin(radians));

    // Update to the new location
    setLocation(new Point(x,y));
    System.out.println("Moved to "+getLocation());
  }

  /** Reports if obstacle ahead */
  @Override
  public void sense() {
    // Obstacle is known only when touch sensor is in physical contact with obstacle.
    // Randomly generate this signal (giving it a 1 in 10 chance that there is an obstacle)
    int spinTheWheel = rand.nextInt(10);
    if (spinTheWheel == 1) {
      System.out.println("Hitting obstacle right now!");
    } else {
      System.out.println("Not in contact with obstacle.");
    }
  }
}