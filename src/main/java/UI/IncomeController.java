package UI;

import Application.Classes.Income;
import Application.Utils.IncomeListUtils;
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
    //scene objects
    @FXML
    public ListView<Income> Income_List;
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
        StartUI.FXMLLoad("Main");
    }

    //Deletes the selected income source from the list
    public boolean DeleteSelectedIncome() {
        //Prechecks if an income is selected
        if (Income_List.getSelectionModel().getSelectedItem() == null) {return false;}
        //Removes the item from the business logic list
        IncomeListUtils.RemoveFromList(Income_List.getSelectionModel().getSelectedItem());
        //Removes item from only the list view
        Income_List.getItems().remove(Income_List.getSelectionModel().getSelectedIndex());
        return true;
    }

    //When the menu is initialized, it ensures that the listview is updated to reflect the current state of the
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //loads in the income sources
        Income_List.getItems().setAll(IncomeListUtils.IncomeList);
    }
}