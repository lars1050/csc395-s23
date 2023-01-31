public class Messenger {

    private String[] mailbox = new String[20];

    long counter = 0;

    public void write() {
        System.out.print(" Writing msg... ");
        for (int i = 0; i < mailbox.length; i++) {
            mailbox[i] = "word-" + counter;
            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }
        }
        counter++;
        System.out.println("Done writing.");
    }

    public void read(String[] msg) {
        System.out.print(" Reading msg...");
        for (int i = 0; i < mailbox.length; i++) {
            msg[i] = mailbox[i];
            try {
                Thread.sleep(300);
            } catch (Exception e) {
            }
        }
        System.out.println(" Done reading.");
    }
}