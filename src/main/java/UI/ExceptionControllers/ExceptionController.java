package UI.ExceptionControllers;

import UI.StartUI;
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

    public static void show() throws IOException {
        exceptionStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ExceptionController.class.getResource("Error.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        exceptionStage.setResizable(false);
        //exceptionStage.setScene(scene);
        //exceptionStage.setAlwaysOnTop(true);
        //StartUI.window.hide();

        //ExceptionName.setText("NO");
        //ExceptionDesc.setText(desc);

        //exceptionStage.show();
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
