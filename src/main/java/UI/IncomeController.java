package UI;

import Application.Classes.Income;
import Application.Classes.ListIncomeExpenses;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;

public class IncomeController implements Initializable {
    @FXML
    public ListView<String> Income_List;
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

    //Updates the Income list node on the income menu
    public void updateIncome() {
        ArrayList<String> list = new ArrayList<>();
        ListIncomeExpenses.IncomeList.forEach(x-> {
            list.add(x.toString());
        });
        //  ObservableList<String> observableList = FXCollections.observableList(list);
        //ObservableList<String> observableList2 = FXCollections.observableList();
       // Income_List.setItems(FXCollections.observableArrayList( "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise"));
    }

    public void DeleteIncomeMenu() {

    }

    String[] xyz = {"ds","dsf",""};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // Income_List.getItems().setAll(xyz);
    }
}