package guibot.gui;

import java.io.IOException;

import guibot.Guibot;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A GUI for Guibot using FXML.
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            MainWindow mw = fxmlLoader.getController();
            stage.setScene(scene);
            mw.setGuibot(new Guibot()); // inject the Guibot instance
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
