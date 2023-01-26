import java.io.File;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class DataFile {

    private String filename;

    public DataFile(String fname) {
        
        filename = fname;

        // Write file using "try with resources"
        // When try-ing with resources, the system will manage the
        // closing of the file if anything goes wrong.
        try ( FileWriter writer = new FileWriter(new File(filename))) {
            writer.write("STOCK INFORMATION\n");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    public void addData(String data) {
        // TODO: add a timestamp to each entry ****
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filename, true))) {
            // Writing on output stream
            out.write(data+"\n");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }
}