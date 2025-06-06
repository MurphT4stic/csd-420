//Tabari Harvey, 06/06/2025, Module-2 Programming Assignment 
import java.io.*;
import java.io.IOException;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        String filename = "MurphTasticDataFile.dat";
        Random rand = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Integers: ");
            for (int i = 0; i < 5; i++) {
                int randomInt = rand.nextInt(100);
                writer.write(randomInt + " ");
            }
            writer.newLine();

            writer.write("Doubles: ");
            for (int i = 0; i < 5; i++) {
                double randomDouble = rand.nextDouble() * 100;
                writer.write(String.format("%.2f ", randomDouble));
            }
            writer.newLine();
            writer.write("------------------------");
            writer.newLine();

            System.out.println("Data written to " + filename);
        } catch (IOException e) {
            System.err.println("File write error: " + e.getMessage());
        }
    }
}


     