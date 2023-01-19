public class Main {
  public static void main(String[] args) {

    System.out.println("^^^^^^^^  ROBOTS  ^^^^^^^");

    RobotBad rosie = new RobotBad("Rosie");

    WheelIR eva = new WheelIR("Eva");

    WheelTouch roomba = new WheelTouch("Hoover");

    OmniIR walle  = new OmniIR("Wall-E");

    RobotBad[] robots = {rosie, eva, roomba, walle};
    for (RobotBad robot : robots) {
      System.out.println("----------------------------");
      robot.describe();
      robot.move(45,10);
      robot.sense();
    }
  }
}
