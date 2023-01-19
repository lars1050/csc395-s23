/** Omni-Directional Robot that uses an IR Sensor */
// Omni-directional robots can turn in place
public class OmniIR extends RobotBad {

  /** Constructor */
  public OmniIR(String name) {
    setName(name);
    // IR sensors have a relatively short range
    setMaxDistance(10);
  }
}
