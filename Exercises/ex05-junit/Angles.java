public class Angles {
    public static void main(String[] args) {
        double angle;
        double angle2;

        // Consider a fixed circle at the origin.
        // The location of the 2nd circle is then the "deltaX" and "deltaY"
        // Tan theta = deltay / deltax

        // along the x-axis (positive)
        angle = Math.atan(0 / 1);
        angle2 = Math.atan2(0, 1); // y,x params
        System.out.println("\nx-axis positive atan " + angle * 180.0 / Math.PI);
        System.out.println("x-axis positive atan2 " + angle2 * 180.0 / Math.PI);

        // 45 degrees
        angle = Math.atan(1 / 1);
        angle2 = Math.atan2(1, 1); // y,x params
        System.out.println("\n45 deg positive atan " + angle * 180.0 / Math.PI);
        System.out.println("45 deg positive atan2 " + angle2 * 180.0 / Math.PI);

        // along the y-axis (positive)
        // angle = Math.atan(1/0); // **** UH OH, divide by zero!!
        angle2 = Math.atan2(1, 0); // y,x params
        System.out.println("\nERROR. Divide by 0");
        System.out.println("y-axis positive atan2 " + angle2 * 180.0 / Math.PI);

        // 135 degrees
        angle = Math.atan(1/-1);
        angle2 = Math.atan2(1,-1); // y,x params
        System.out.println("\n135 deg positive atan " + angle * 180.0 / Math.PI);
        System.out.println("135 deg positive atan2 " + angle2 * 180.0 / Math.PI);

        // along the x-axis (negative)
        angle = Math.atan(0/-1);
        angle2 = Math.atan2(0, -1);
        System.out.println("\nx-axis negative atan " + angle * 180.0 / Math.PI);
        System.out.println("x-axis negative atan2 " + angle2 * 180.0 / Math.PI);

        // 2225 degrees
        angle = Math.atan(-1/-1);
        angle2 = Math.atan2(-1,-1); // y,x params
        System.out.println("\n225 deg positive atan " + angle * 180.0 / Math.PI);
        System.out.println("225 deg positive atan2 " + angle2 * 180.0 / Math.PI);
        System.out.println("CONVERTED "+(int)(360+(angle2 * 180.0 / Math.PI)));

        // along the y-axis (negative)
        // angle = Math.atan(-1/0); // UH OH, divide by zero!!
        angle2 = Math.atan2(-1,0);
        System.out.println("\nERROR. div by 0");
        System.out.println("-axis negative atan2 " + angle2 * 180.0 / Math.PI);
        System.out.println("CONVERTED "+(int)(360+(angle2 * 180.0 / Math.PI)));

        // 270 degrees
        angle = Math.atan(-1/1);
        angle2 = Math.atan2(-1,1); // y,x params
        System.out.println("\n315 deg positive atan " + angle * 180.0 / Math.PI);
        System.out.println("315 deg positive atan2 " + angle2 * 180.0 / Math.PI);
        System.out.println("CONVERTED "+(int)(360+(angle2 * 180.0 / Math.PI)));
    }
}