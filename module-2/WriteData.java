//Tabari Harvey, 06/06/2025, Module-2 Programming Assignment 
import java.io.*;
import java.io.IOException;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        //Creates objects to make random numbers
        String filename = "MurphTasticDataFile.dat";
        Random rand = new Random();

        // Writes random integers and doubles to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Integers: ");
            for (int i = 0; i < 5; i++) {
                int randomInt = rand.nextInt(100);
                writer.write(randomInt + " ");
            }
            // Adds a new line after writing integers
            writer.newLine();
            
            // Writes random doubles to the file
            writer.write("Doubles: ");
            for (int i = 0; i < 5; i++) {
                double randomDouble = rand.nextDouble() * 100;
                writer.write(String.format("%.2f ", randomDouble));
            }
            // Adds a new line after writing doubles
            writer.newLine();
            writer.write("------------------------");
            writer.newLine();
            
            // Flushes the writer to ensure all data is written to the file
            System.out.println("Data written to " + filename);
        } catch (IOException e) {
            System.err.println("File write error: " + e.getMessage());
        }
    }
}


     