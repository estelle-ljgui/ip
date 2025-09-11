package guibot.gui;

import guibot.Guibot;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    private static final String WELCOME_MESSAGE = "Hello! I'm Guibot\nWhat can I do for you?";
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Guibot guibot;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image guiImage = new Image(this.getClass().getResourceAsStream("/images/DaGui.png"));

    /**
     * Initialises the main window.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().add(
                DialogBox.getGuibotDialog(WELCOME_MESSAGE, guiImage)
        );
    }

    /** Injects the Guibot instance */
    public void setGuibot(Guibot g) {
        guibot = g;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Guibot's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = guibot.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getGuibotDialog(response, guiImage)
        );
        userInput.clear();
        if (input.matches("bye*")) {
            Scene scene = this.sendButton.getScene();
            Stage stage = (Stage) scene.getWindow();
            stage.close();
        }
    }
}
