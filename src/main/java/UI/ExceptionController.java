package UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class ExceptionController {
    //Name of the error
    @FXML
    public static Label ExceptionName;
    private static String name;
    //Short description of the error
    @FXML
    public static Label ExceptionDesc;
    private static String desc;
    //stage for the exception window
    private static Stage exceptionStage;
    //To do make this prettier and add documentation
    @FXML
    private static void Show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartUI.class.getResource("Error.fxml"));

        Scene scene;
        exceptionStage = new Stage();
        scene = new Scene(fxmlLoader.load(), 600, 400);
        exceptionStage.setScene(scene);
        exceptionStage.setAlwaysOnTop(true);
        //hides the main window
        StartUI.window.hide();
        exceptionStage.setResizable(false);
        //shows the new error pop up
        exceptionStage.show();
        SetExceptionData();
        exceptionStage.setTitle("Error!");
    }

    @FXML
    private static void SetExceptionData(){

        //sets the Text on the scene to the name of the error
        //ExceptionName.setText("hjskdf");
        //sets the explanation for the error
        //ExceptionDesc.setText(desc);
    }


    //goes back to the previous window
    @FXML
    private void Close() {
        StartUI.window.show();
        exceptionStage.close();
    }
    //This is the entry point of the class
    public static void ShowErrorWindow(String Name, String Desc) throws IOException {
        name = Name;
        desc = Desc;
        Show();
    }
}
