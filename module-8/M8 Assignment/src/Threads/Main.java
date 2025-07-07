package Threads;//Tabari Harvey, Module8 Programming Assignment
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Random;

public class ThreeThreads extends Application {

    private static final int COUNT = 10000;
    private final Random random = new Random();

    private final char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);

        Thread lettersThread = new Thread(() -> appendRandomLetters(textArea));
        Thread digitsThread = new Thread(() -> appendRandomDigits(textArea));
        Thread symbolsThread = new Thread(() -> appendRandomSymbols(textArea));

        lettersThread.setDaemon(true);
        digitsThread.setDaemon(true);
        symbolsThread.setDaemon(true);

        lettersThread.start();
        digitsThread.start();
        symbolsThread.start();

        BorderPane root = new BorderPane();
        root.setCenter(textArea);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Three Threads");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void appendRandomLetters(TextArea textArea) {
        for (int i = 0; i < COUNT; i++) {
            char letter = (char) ('a' + random.nextInt(26));
            appendToTextArea(textArea, letter);
        }
    }

    private void appendRandomDigits(TextArea textArea) {
        for (int i = 0; i < COUNT; i++) {
            char digit = (char) ('0' + random.nextInt(10));
            appendToTextArea(textArea, digit);
        }
    }

    private void appendRandomSymbols(TextArea textArea) {
        for (int i = 0; i < COUNT; i++) {
            char symbol = symbols[random.nextInt(symbols.length)];
            appendToTextArea(textArea, symbol);
        }
    }

    private void appendToTextArea(TextArea textArea, char c) {
        javafx.application.Platform.runLater(() -> textArea.appendText(String.valueOf(c)));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
