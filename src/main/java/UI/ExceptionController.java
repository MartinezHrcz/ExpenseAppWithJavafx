package UI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ExceptionController implements Initializable {
    //Name of the error
    @FXML
    public static Label ExceptionName;
    private static String name;
    //Short description of the error
    @FXML
    public static Label ExceptionDesc;
    private static String desc;
    //stage for the exception window

    //To do make this prettier and add documentation

    @FXML
    private static void SetExceptionData(){
        //Doesn't work yet
        //sets the Text on the scene to the name of the error
        //ExceptionName.setText("hjskdf");
        //sets the explanation for the error
        //ExceptionDesc.setText(desc);
    }


    //goes back to the previous window
    @FXML
    private void Close() {
        StartUI.window.show();
        StartUI.exceptionStage.close();
    }
    //This is the entry point of the class
    public static void ShowErrorWindow(String Name, String Desc) throws IOException {
        name = Name;
        desc = Desc;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Initializing");
        //System.out.println(ExceptionDesc.getLabelFor());
        //ExceptionDesc.setText(desc);

    }
}
