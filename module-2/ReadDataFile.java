//Tabari Harvey, 06/06/2025, Module-2 Programming Assignment 
import java.io.*;

public class ReadDataFile {
    public static void main(String[] args) {
        String filename = "MurphTasticDataFile.dat"; // The name of the file to read
        
        // Reads the contents of the file and prints them to the console
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            // Print the contents of the file line by line
            System.out.println("Contents of " + filename + ":\n");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            } // End of file reached
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            System.err.println("File read error: " + e.getMessage());
        }
    }
}
