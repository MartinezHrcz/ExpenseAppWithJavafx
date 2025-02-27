package UI;

import Application.Classes.Expenses;

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

public class ExpenseControler implements Initializable {
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
        try {
            StartUI.BackToMain();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Deletes the selected income source from the list
    public void DeleteSelectedExpense() {
        //Removes the item from the business logic list
        ListIncomeExpenses.RemoveFromExpensesList(Expense_List.getSelectionModel().getSelectedItem());
        //Removes item from only the list view
        Expense_List.getItems().remove(Expense_List.getSelectionModel().getSelectedIndex());
    }

    //When the menu is initalized, it ensures that the listview is updated
    // to reflect the current state of the stored data
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //loads in the income sources
        Expense_List.getItems().setAll(ListIncomeExpenses.ExpensesList);
    }
}