package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class IncomeController {
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
}
