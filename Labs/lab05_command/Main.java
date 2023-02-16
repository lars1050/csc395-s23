/**
 * A remote control. This is the first pass at design.
 * Implement the different functionality using conditional statements.
 * There are a collection of buttons specified in class Remote.
 * There are 2 devices to control: a stereo and a tv.
 * We want to associate the various buttons with their corresponding command.
 **/

public class Main {

  public static void main(String[] args) {
    Stereo stereo = new Stereo();
    TV tv = new TV();
    Remote remote = new Remote(stereo, tv);

    // Iterate through all the button presses and see what happens.
    // All buttons are not yet defined.
    for (Remote.Buttons button : Remote.Buttons.values()) {
      remote.buttonPressed(button);
    }
    for (Remote.Buttons button : Remote.Buttons.values()) {
      remote.buttonPressed(button);
    }
  } // end main()
} // end Command

