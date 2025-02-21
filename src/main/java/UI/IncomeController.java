package UI;

import Application.Classes.Income;
import Application.Classes.ListIncomeExpenses;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IncomeController{
    //Boxes on the sceen
    @FXML
    public TextField NameBox;
    public Text IncomeList_Text;
    public ListView<String> Income_List;
    @FXML
    private TextField AmountBox;
    @FXML
    private TextField DescBox;
    @FXML
    private TextField DateBox;

    //Loads the menu for adding income sources
    public void AddIncomeMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(IncomeController.class.getResource("IncomeMenuSub/IncomeAdder.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        StartUI.window.setTitle("Add Income");
        StartUI.window.setScene(scene);
    }
    //Gets called on the back arrow button
    public void BackToIncomeMenu(ActionEvent actionEvent) {
        try {
            StartUI.IncomeLoad();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Loads back to the main menu
    public void BackToMainMenu() {
        try {
            StartUI.BackToMain();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Retrives data from the income adder and creates the income object
    public void AddIncomePress() throws IOException {
        String name = NameBox.getText();
        String description = DescBox.getText();
        String date = DateBox.getText();
        //Error handling for the amount box
        try{
            double amount = Double.parseDouble(AmountBox.getText());
            if (ListIncomeExpenses.AddtoIncomeList(name,amount,description,date)){
                ListIncomeExpenses.ListIncomeList(true);
                StartUI.IncomeLoad();
                updateIncome();
            }
        }
        catch (NumberFormatException e){
            ExceptionController.ShowErrorWindow("Invalid number error","The input amount wasn't a number, or it was invalid.");
        } catch (IOException e) {
            ExceptionController.ShowErrorWindow("IOException error","The program has ran into a problem!");
        }
    }

    //Updates the Income list node on the income menu
    public void updateIncome() throws IOException {
        ObservableList<Income> list = FXCollections.observableList(ListIncomeExpenses.IncomeList.stream().toList());

        //Income_List.setItems(list);
    }
}