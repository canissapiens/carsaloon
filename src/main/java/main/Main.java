package main;


import controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// to jest wersja saloonu z JavaFX
public class Main extends Application {

    Client client = new Client();

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/ClearScreen.fxml"));

        StackPane pane = loader.load();

        Scene scene = new Scene(pane, 800, 400);

        primaryStage.setTitle("Saloon");
        primaryStage.setScene(scene);
        primaryStage.show();

        MainController controller = loader.getController();
        controller.setClient(client);

        controller.showMenu();
    }
}
