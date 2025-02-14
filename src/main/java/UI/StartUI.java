package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class StartUI extends Application {
    public static Stage window;
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

    //Used to load in Income menu
    public static void IncomeLoad() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartUI.class.getResource("Income.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        window.setTitle("Income");
        window.setScene(scene);
    }
    //Used to load in Expense menu
    public static void ExpenseLoad() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartUI.class.getResource("Expense.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        window.setTitle("Expenses");
        window.setScene(scene);
    }
    //Used to load in Finances menu
    public static void FinancesLoad() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartUI.class.getResource("Finances.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        window.setTitle("Finances");
        window.setScene(scene);
    }
    //Used to load in the main menu when going back
    public static void BackToMain() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartUI.class.getResource("home-ui.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        window.setTitle("ExpenseApp");
        window.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}