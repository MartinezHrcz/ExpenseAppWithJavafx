package UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ExceptionController {
    @FXML
    private static Text ExceptionName;
    private static String name;
    @FXML
    private static Text ExceptionDesc;
    private static String desc;

    public static Stage exceptionStage;
    //To do make this prettier and add documentation
    public static void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartUI.class.getResource("Error.fxml"));

        Scene scene; exceptionStage = new Stage();
        scene = new Scene(fxmlLoader.load(), 600, 400);
        exceptionStage.setScene(scene);
        exceptionStage.setAlwaysOnTop(true);
        StartUI.window.hide();
        exceptionStage.setResizable(false);
        exceptionStage.show();
        exceptionStage.setTitle("Error!");
        ExceptionName.setText(name);
        ExceptionDesc.setText(desc);


    }

    public void Close() {
        StartUI.window.show();
        exceptionStage.close();
    }

    public static void main(String Name, String Desc) throws IOException {
        name = Name;
        desc = Desc;
        show();
    }
}
