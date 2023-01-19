/** Wheeled Differential Drive Robot using an IR Sensor */
public class WheelIR extends RobotBad {

  public WheelIR(String name) {
    setName(name);
    // IR sensors have a relatively short range
    setMaxDistance(10);
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
}
