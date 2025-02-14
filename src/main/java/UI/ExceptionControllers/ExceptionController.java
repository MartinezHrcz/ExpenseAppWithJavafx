package UI.ExceptionControllers;

import UI.StartUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import java.io.IOException;

public class ExceptionController {
    @FXML
    private static Text ExceptionName;
    private static String name;
    @FXML
    private static Text ExceptionDesc;
    private static String desc;

    private static Stage exceptionStage;

    public static void ShowExc() throws IOException, Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(StartUI.class.getResource("ExceptionMenus/Error.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        exceptionStage.setTitle("ExpenseApp");
        exceptionStage.setResizable(false);
        exceptionStage.setScene(scene);
        exceptionStage.setAlwaysOnTop(true);
        StartUI.window.hide();

        ExceptionName.setText(name);
        ExceptionDesc.setText(desc);

        exceptionStage.show();
    }

    public void Close() {
        StartUI.window.show();
        exceptionStage.close();
    }

    public static void main(String Name, String Desc) throws IOException {
        name = Name;
        desc = Desc;
        try {
            ShowExc();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
