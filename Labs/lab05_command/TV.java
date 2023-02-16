// The TV class with almost identical functionality to the stereo.
// Notice the interfaces to the same functionality are not identical.
public class TV {

    private final static int MAX_VOLUME = 11;

    private int volume = 0;
    private boolean on = false;

    void power() {
        if (on) {
            on = false;
            System.out.println("TV OFF");
        } else {
            on = true;
            System.out.println("TV ON");
        }
    }

    void volumeUp() {
        if (volume!=MAX_VOLUME) {
            ++volume;
        }
        System.out.println("TV volume UP to "+volume+".");
    }

    void volumeDown() {
        if (volume != 0) {
            --volume;
        }
        System.out.println("TV volume DOWN to "+volume+".");
    }
}