// Tabari Harvey Module-1 Programming Assignment
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDisplayApp extends Application {

    private static final int NUM_CARDS = 52;
    private static final String CARD_DIR = "cards/";
    private static final int CARD_WIDTH = 100;
    private static final int CARD_HEIGHT = 150;

    private HBox cardBox = new HBox(10); // HBox to hold card images

    @Override
    public void start(Stage primaryStage) {
        // Initial display
        displayRandomCards();

        // Refresh button with lambda expression
        Button refreshBtn = new Button("Refresh");
        refreshBtn.setOnAction(e -> displayRandomCards());

        // Layout
        VBox root = new VBox(10, cardBox, refreshBtn);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 500, 250);
        primaryStage.setTitle("Random Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to display 4 random cards
    private void displayRandomCards() {
        cardBox.getChildren().clear();

        List<Integer> cardNumbers = new ArrayList<>();
        for (int i = 1; i <= NUM_CARDS; i++) {
            cardNumbers.add(i);
        }

        Collections.shuffle(cardNumbers);

        for (int i = 0; i < 4; i++) {
            String imagePath = CARD_DIR + cardNumbers.get(i) + ".png";
            Image img = new Image(new File(imagePath).toURI().toString());
            ImageView imageView = new ImageView(img);
            imageView.setFitWidth(CARD_WIDTH);
            imageView.setFitHeight(CARD_HEIGHT);
            cardBox.getChildren().add(imageView);
        }
    }

    public static void main(String
