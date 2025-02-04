package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(StartUI.class.getResource("home-ui.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ExpenseApp");
        stage.setScene(scene);
        stage.show();
    }
    public static void IncomeLoad() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(StartUI.class.getResource("Income.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Income");
        stage.setScene(scene);
        stage.show();
    }
    public static void ExpenseLoad() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(StartUI.class.getResource("Expense.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Expenses");
        stage.setScene(scene);
        stage.show();
    }
    public static void FinancesLoad() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(StartUI.class.getResource("Finance.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Finances");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}