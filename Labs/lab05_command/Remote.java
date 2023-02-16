// The remote control. We are simulating its operation by having a function
// that is called that indicates the event that a button has been pushed.

public class Remote {

    public enum Buttons {
        POWERA, UPA1, DOWNA1, UPA2, DOWNA2,
        POWERB, UPB, DOWNB, SOURCE
    }

    Stereo stereo = null;
    TV tv = null;

    public Remote(Stereo s, TV t) {
        stereo = s;
        tv = t;
    }

    /*
     * CircleA and B are power on/off for tv
     * CircleC and D are power on/off for Stereo
     * CircleE is input for Stereo
     * UpA and DownB are tv volume
     * UpC and DownD are stereo volume
     */
    void buttonPressed(Buttons b) {
        switch (b) {
            case POWERA:
                tv.power();
                break;
            case POWERB:
                stereo.powerToggle();
                break;
            case SOURCE:
                stereo.changeInput();
                break;
            case UPA1:
                tv.volumeUp();
                break;
            case UPB:
                stereo.louder();
                break;
            default:
                System.out.println("Button "+b+" not recognized.");
        } // end switch(b)
    } // end buttonPressed()
} // end class Remote
