package UI;

import Application.Utils.ExpenseListUtils;
import Application.Utils.IncomeListUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FinancesController implements Initializable {
    @FXML
    BarChart<String, Double> Bar_Chart;
    //Returns back to the home screen
    public void BackToMainMenu() {
        StartUI.FXMLLoad("Main");
    }
    //Initializes the data for the chart
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series<String, Double> I = new XYChart.Series<>();

        I.setName("Income");
        I.getData().add(new XYChart.Data<>("Income "+ IncomeListUtils.Sum() + "Ft", IncomeListUtils.Sum()));
        XYChart.Series<String, Double> E = new XYChart.Series<>();
        E.setName("Expense");
        E.getData().add(new XYChart.Data<>("Expense "+ ExpenseListUtils.Sum() + "Ft", ExpenseListUtils.Sum()));
        Bar_Chart.getData().addAll(I,E);
    }
    //Opens Net salary calculator menu
    public void NetSalPress() {
        StartUI.FXMLLoad("Net Salary Calculator");
    }
}
