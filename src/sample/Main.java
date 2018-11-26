package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("keks.fxml"));
        primaryStage.setTitle("Math helper v1.0");
        primaryStage.setScene(new Scene(root, root.getBoundsInParent().getWidth(), root.getBoundsInParent().getHeight()));
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
