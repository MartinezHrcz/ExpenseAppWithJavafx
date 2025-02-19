package UI;

import Application.Classes.ListIncomeExpenses;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import java.io.IOException;

public class IncomeController{
    //Boxes on the sceen
    @FXML
    public TextField NameBox;
    @FXML
    private TextField AmountBox;
    @FXML
    private TextField DescBox;
    @FXML
    private TextField DateBox;

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

    public void AddIncomePress() throws IOException {
        String name = NameBox.getText();
        String description = DescBox.getText();
        String date = DateBox.getText();
        try{
            double amount = Double.parseDouble(AmountBox.getText());
            if (ListIncomeExpenses.AddtoIncomeList(name,amount,description,date)){
                ListIncomeExpenses.ListIncomeList(true);
            }
        }
        catch (NumberFormatException e){
            ExceptionController.ShowErrorWindow("Invalid number error","The input amount wasn't a number, or it was invalid.");
        } catch (IOException e) {
            ExceptionController.ShowErrorWindow("IOException error","The program has ran into a problem!");
        }


    }
}