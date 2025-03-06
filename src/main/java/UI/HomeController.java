package UI;

import Application.Utils.ExitProcedureUtil;
import javafx.application.Application;
import javafx.scene.control.Button;
import org.controlsfx.tools.Utils;

public class HomeController {


    public void ButtonClicked(javafx.event.ActionEvent actionEvent) {

        Button bt = (Button) actionEvent.getSource();
        //When one of the menu choices is clicked this loads in the wanted menu
        switch (bt.getId()){
            case "Income_Btn":
                StartUI.FXMLLoad("Income");
                break;
            case "Expenses_Btn":
                StartUI.FXMLLoad("Expenses");
                break;
            case "Finances_Btn":
                StartUI.FXMLLoad("Finances");
                break;
            case "Quit":
                ExitProcedureUtil.Start();
                break;
        }

    }
}