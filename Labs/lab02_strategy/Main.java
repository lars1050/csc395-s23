public class Main {
  public static void main(String[] args) {

    System.out.println("^^^^^^^^  ROBOTS  ^^^^^^^");

    Robot rosie = new Robot("Rosie");

    WheelIR eva = new WheelIR("Eva");

    WheelTouch roomba = new WheelTouch("Hoover");

    OmniIR walle  = new OmniIR("Wall-E");

    Robot[] robots = {rosie, eva, roomba, walle};
    for (Robot robot : robots) {
      System.out.println("----------------------------");
      robot.describe();
      robot.move(45,10);
      robot.sense();
    }
  }
}
