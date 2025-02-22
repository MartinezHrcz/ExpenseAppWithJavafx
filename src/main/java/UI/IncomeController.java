package UI;

import Application.Classes.Income;
import Application.Classes.ListIncomeExpenses;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IncomeController implements Initializable {
    @FXML
    public ListView<Income> Income_List;
    //Boxes on the sceen
    @FXML
    public Text IncomeList_Text;

    //Loads the menu for adding income sources
    public void AddIncomeMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(IncomeController.class.getResource("IncomeMenuSub/IncomeAdder.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        StartUI.window.setTitle("Add Income");
        StartUI.window.setScene(scene);
    }

    //Loads back to the main menu
    public void BackToMainMenu() {
        try {
            StartUI.BackToMain();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Deletes the selected income source from the list
    public void DeleteSelectedIncome() {
        ListIncomeExpenses.RemoveFromIncomeList(Income_List.getSelectionModel().getSelectedItem());
        Income_List.getItems().remove(Income_List.getSelectionModel().getSelectedIndex());
    }

    //When the menu is initalized, it ensures that the listview is updated to reflect the current state of the
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Income_List.getItems().setAll(ListIncomeExpenses.IncomeList);
    }
}