//Tabari Harvey, 06/06/2025, Module-2 Programming Assignment 
import java.io.*;

public class ReadDataFile {
    public static void main(String[] args) {
        String filename = "MurphTasticDataFile.dat";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Contents of " + filename + ":\n");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            System.err.println("File read error: " + e.getMessage());
        }
    }
}
