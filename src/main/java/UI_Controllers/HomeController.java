package UI_Controllers;

import javafx.fxml.FXML;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class HomeController {

    public void ButtonClicked(javafx.event.ActionEvent actionEvent) throws IOException {
        UI_Controllers.StartUI.IncomeLoad();
    }
}