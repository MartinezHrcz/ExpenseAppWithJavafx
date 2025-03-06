package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Map;


public class StartUI extends Application {
    //Window which the app runs in
    public static Stage window;
    //Window which shows the errors
    public static Stage exceptionStage;
    //Map used to store the name and location of the fxml files
    private final static Map<String,String> Menus = Map.ofEntries(
            Map.entry("Main", "home-ui.fxml"),
            Map.entry("Income", "MainMenus/Income.fxml"),
            Map.entry("Expenses", "MainMenus/Expense.fxml"),
            Map.entry("Finances", "MainMenus/Finances.fxml"),
            Map.entry("Net Salary Calculator", "FinanceMenuSub/NetSal.fxml")
    );
    //Loads in the main menu when the application is started
    @Override
    public void start(Stage stage) {
        window = stage;
        FXMLLoad("Main");
        window.show();
    }

    public static void ERR(String invalidNumberError, String s) {
        System.out.println("showing");
        try {
            ExceptionController.ShowErrorWindow(invalidNumberError,s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(StartUI.class.getResource("Error.fxml"));
        Scene scene;
        exceptionStage = new Stage();
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        exceptionStage.setScene(scene);
        exceptionStage.setAlwaysOnTop(true);
        //hides the main window
        StartUI.window.hide();
        exceptionStage.setResizable(false);
        //shows the new error pop up
        exceptionStage.show();
        //SetExceptionData();
        exceptionStage.setTitle("Error!");
    }

    //Used to load in the menu fxml files
    //This is the reworked method, before this every menu had its own method
    public static void FXMLLoad(String neededFXML){
        FXMLLoader fxmlLoader = new FXMLLoader(StartUI.class.getResource(Menus.get(neededFXML)));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //scene.getStylesheets().add(String.valueOf(StartUI.class.getResource("General.css").toExternalForm()));
        window.setTitle(neededFXML);
        window.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}