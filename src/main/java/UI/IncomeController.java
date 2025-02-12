package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextInputControl;

import java.awt.*;
import java.io.IOException;

public class IncomeController {

    @FXML
    private TextField Name;
    @FXML
    private TextField Amount;
    @FXML
    private TextField Description;
    @FXML
    private TextField Date;

    public void AddIncomeMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(IncomeController.class.getResource("IncomeMenuSub/IncomeAdder.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        StartUI.window.setTitle("Add Income");
        StartUI.window.setScene(scene);
    }

    public void BackToIncomeMenu(ActionEvent actionEvent) {
        try {
            StartUI.IncomeLoad();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void BackToMainMenu(ActionEvent actionEvent) {
        try {
            StartUI.BackToMain();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddIncomePress(ActionEvent actionEvent) {
        Scene p = StartUI.window.getScene();

    }
}
