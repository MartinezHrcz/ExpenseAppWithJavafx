package UI;

import Application.Classes.Expenses;

import Application.Utils.ExpenseListUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ExpenseControler implements Initializable {
    //used for the Expense menu
    //scene objects
    @FXML
    public ListView<Expenses> Expense_List;
    @FXML
    public Text ExpenseList_Text;

    //Loads the menu for adding income sources
    public void AddExpenseMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ExpenseControler.class.getResource("ExpenseMenuSub/ExpenseAdder.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        StartUI.window.setTitle("Add Expense");
        StartUI.window.setScene(scene);
    }

    //Loads back to the main menu
    public void BackToMainMenu() {
        StartUI.FXMLLoad("Main");
    }

    //Deletes the selected income source from the list
    public void DeleteSelectedExpense() {
        //Removes the item from the business logic list
        ExpenseListUtils.RemoveFromList(Expense_List.getSelectionModel().getSelectedItem());
        //Removes item from only the list view
        Expense_List.getItems().remove(Expense_List.getSelectionModel().getSelectedIndex());
    }

    //When the menu is initalized, it ensures that the listview is updated
    // to reflect the current state of the stored data
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //loads in the expense sources
        Expense_List.getItems().setAll(ExpenseListUtils.ExpensesList);
    }
}