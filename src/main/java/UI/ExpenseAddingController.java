package UI;

import Application.Classes.ListIncomeExpenses;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ExpenseAddingController {
    @FXML
    public TextField NameBox;
    @FXML
    private TextField AmountBox;
    @FXML
    private TextField DescBox;
    @FXML
    private TextField DateBox;
    @FXML
    private CheckBox EssentialCheck;
    @FXML
    private CheckBox CheckedBox;
    //Gets called on the back arrow button
    public void BackToExpenseMenu() {
        try {
            StartUI.ExpenseLoad();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Retrives data from the income adder and creates the income object
    public void AddExpensePress() throws IOException {
        String name = NameBox.getText();
        String description = DescBox.getText();
        String date = DateBox.getText();
        boolean essential = EssentialCheck.isPressed();
        boolean checked = CheckedBox.isSelected();
        //Error handling for the amount box
        try{
            double amount = Double.parseDouble(AmountBox.getText());
            if (ListIncomeExpenses.AddtoExpensesList(name,amount,description,essential,checked)){
                //ListIncomeExpenses.ListIncomeList(true);
                BackToExpenseMenu();

            }
        }
        catch (NumberFormatException e) {
            ExceptionController.ShowErrorWindow("Invalid number error", "The input amount wasn't a number, or it was invalid.");
        }
    }
}
