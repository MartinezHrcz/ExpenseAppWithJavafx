package UI;

import Application.Utils.IncomeListUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class IncomeAddingController {
    @FXML
    public TextField NameBox;
    @FXML
    private TextField AmountBox;
    @FXML
    private TextField DescBox;
    @FXML
    private TextField DateBox;

    //Gets called on the back arrow button
    public void BackToIncomeMenu() {
        StartUI.FXMLLoad("Income");
    }

    //Retrieves data from the income adder and creates the income object
    public void AddIncomePress() throws IOException {
        String name = NameBox.getText();
        String description = DescBox.getText();

        //Error handling for the amount box
        try{
            double amount = Double.parseDouble(AmountBox.getText());
            int date = Integer.parseInt(DateBox.getText());
            if (IncomeListUtils.AddtoList(name,amount,description,date)){
                BackToIncomeMenu();
            }
        }
        catch (NumberFormatException e) {
            StartUI.ERR("Invalid number error", "The input amount wasn't a number, or it was invalid.");
        }
    }
}
