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

    private static Map<String,String> Menus = Map.ofEntries(
            Map.entry("Main", "home-ui.fxml"),
            Map.entry("Income", "MainMenus/Income.fxml"),
            Map.entry("Expenses", "MainMenus/Expense.fxml"),
            Map.entry("Finances", "MainMenus/Finances.fxml"),
            Map.entry("Net Salary Calculator", "FinanceMenuSub/NetSal.fxml")

    );
    //Loads in the main menu when the applications is started
    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(StartUI.class.getResource("home-ui.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        window.setTitle("ExpenseApp");
        window.setResizable(false);
        window.setScene(scene);
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
    //This is the reworked method, before this every menu had it's own method
    public static void FXMLLoad(String neededFXML){
        FXMLLoader fxmlLoader = new FXMLLoader(StartUI.class.getResource(Menus.get(neededFXML)));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        window.setTitle(neededFXML);
        window.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}