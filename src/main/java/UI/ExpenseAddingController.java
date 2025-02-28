package UI;

import Application.Utils.ExpenseListUtils;
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
        int date = Integer.parseInt(DateBox.getText());
        boolean essential = EssentialCheck.isSelected();
        boolean checked = CheckedBox.isSelected();
        //Error handling for the amount box
        try{
            double amount = Double.parseDouble(AmountBox.getText());
            if (ExpenseListUtils.AddtoList(name,amount,description, date ,essential,checked)){
                //ListIncomeExpenses.ListIncomeList(true);
                BackToExpenseMenu();

            }
        }
        catch (NumberFormatException e) {
            ExceptionController.ShowErrorWindow("Invalid number error", "The input amount wasn't a number, or it was invalid.");
        }
    }
}
