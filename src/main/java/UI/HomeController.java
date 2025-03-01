package UI;

import java.awt.*;
import java.io.IOException;
import javafx.scene.control.Button;
public class HomeController {


    public void ButtonClicked(javafx.event.ActionEvent actionEvent) throws IOException {
        Button bt = (Button) actionEvent.getSource();
        switch (bt.getId().toString()){
            case "Income_Btn":
                StartUI.FXMLLoad("Income");
                break;
            case "Expenses_Btn":
                StartUI.FXMLLoad("Expenses");
                break;
            case "Finances_Btn":
                StartUI.FXMLLoad("Finances");
                break;
        }

    }
}