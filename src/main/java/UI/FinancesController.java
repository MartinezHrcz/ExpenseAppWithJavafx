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

    public void BackToMainMenu() {
        try {
            StartUI.BackToMain();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series<String, Double> I = new XYChart.Series<>();

        I.setName("Income");
        I.getData().add(new XYChart.Data<>("Income "+ IncomeListUtils.Sum() + "$", IncomeListUtils.Sum()));
        XYChart.Series<String, Double> E = new XYChart.Series<>();
        E.setName("Expense");
        E.getData().add(new XYChart.Data<>("Expense "+ ExpenseListUtils.Sum() + "$", ExpenseListUtils.Sum()));
        Bar_Chart.getData().addAll(I,E);
    }

    public void NetSalPress() {
        try {
            StartUI.NetSalLoad();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
