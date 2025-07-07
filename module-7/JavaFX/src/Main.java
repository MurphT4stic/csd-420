//Tabari Harvey, Module-7 Programming assignment
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FourCircles extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Circle c1 = new Circle(100, 100, 50);
        c1.getStyleClass().add("white-fill");

        Circle c2 = new Circle(250, 100, 50);
        c2.setId("red-green");

        Circle c3 = new Circle(100, 250, 50);
        c3.getStyleClass().add("white-fill");

        Circle c4 = new Circle(250, 250, 50);
        c4.setId("red-green");

        pane.getChildren().addAll(c1, c2, c3, c4);

        Scene scene = new Scene(pane, 400, 400);
        scene.getStylesheets().add("mystyle.css");

        primaryStage.setTitle("Four Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


