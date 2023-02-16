// The Stereo class and all its varied functionality.
public class Stereo {

    private static final int MAX_VOLUME = 11;
    private int volume = 0;
    private boolean on = false;

    private enum Inputs {
        CD, TUNER, SONOS
    }

    private Inputs input;

    public Stereo() {
        input = Inputs.CD;
    }

    void powerToggle() {
        if (on) {
            on = false;
            System.out.println("STEREO OFF");
        } else {
            on = true;
            System.out.println("STEREO ON");
        }
    }

    public void louder() {
        if (volume != MAX_VOLUME) {
            ++volume;
        }
        System.out.println("Stereo volume UP to "+volume+".");
    }

    public void quieter() {
        if (volume != 0) {
            --volume;
        }
        System.out.println("Stereo volume DOWN to "+volume+".");
    }

    public void changeInput() {
        if (input == Inputs.CD) {
            input = Inputs.TUNER;
        } else if (input == Inputs.TUNER) {
            input = Inputs.SONOS;
        } else {
            input = Inputs.CD;
        }
        System.out.println("Stereo changing input to " + input);
    }
}
