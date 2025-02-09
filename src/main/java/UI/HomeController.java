package UI;

import java.awt.*;
import java.io.IOException;
import javafx.scene.control.Button;
public class HomeController {


    public void ButtonClicked(javafx.event.ActionEvent actionEvent) throws IOException {
        Button bt = (Button) actionEvent.getSource();
        switch (bt.getId().toString()){
            case "Income_Btn":
                UI.StartUI.IncomeLoad();
                break;
            case "Expenses_Btn":
                UI.StartUI.ExpenseLoad();
                break;
            case "Finances_Btn":
                UI.StartUI.FinancesLoad();
                break;
        }

    }
}