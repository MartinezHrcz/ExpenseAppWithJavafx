package UI;

import javafx.event.ActionEvent;

import java.io.IOException;

public class NetSalController {


    public void BackToMainMenu() {
        try {
            StartUI.FinancesLoad();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
