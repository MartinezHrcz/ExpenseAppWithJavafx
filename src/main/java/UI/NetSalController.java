package UI;

import Application.Utils.Finances;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class NetSalController {

    private int grossIncome;

    @FXML
    private TextField GrossIncome;
    @FXML
    private ListView<String> NetSalList;
    @FXML
    private CheckBox AgeCheck;
    @FXML
    private StackedBarChart StackedBarChart;

    public void BackToMainMenu() {
        StartUI.FXMLLoad("Finances");
    }


    public void CalcNet_Press() {
        try {
            NetSalList.getItems().clear();
            grossIncome = Integer.parseInt(GrossIncome.getText());
            float[] values = Finances.AfterTaxAmount(grossIncome, AgeCheck.isSelected());
            FillList(values);
            FillChart(values);

        }
        catch (NumberFormatException e) {
            //nothing happens
        }
    }

    //When the net salary is calculated, the list gets filled with the values
    private void FillList(float [] values){
        NetSalList.getItems().add("Net salary: " +values[0] + "Ft");
        NetSalList.getItems().add("Income Tax: " +values[1] + "Ft");
        NetSalList.getItems().add("Social Tax: " +values[2] + "Ft");
    }
    //When the net salary is calculated, the stacked barchart gets filled with the values
    private void FillChart(float [] values) {
        StackedBarChart.getData().clear();
        StackedBarChart.getXAxis().setLabel("BreakDown of gross salary");
        StackedBarChart.getYAxis().setLabel("Amount");

        CategoryAxis xAxis= new CategoryAxis();
        xAxis.setLabel("Values");
        xAxis.getCategories().addAll("Net salary", "Income Tax", "Social Tax");

        NumberAxis yAxis = new NumberAxis();

        yAxis.setLabel("Amount");
        XYChart.Series NetSal = new XYChart.Series();

        NetSal.setName("Net salary");
        XYChart.Series IncomeTax = new XYChart.Series();

        IncomeTax.setName("Income Tax");
        XYChart.Series SocialTax = new XYChart.Series();

        SocialTax.setName("Social Tax");
        NetSal.getData().add(new XYChart.Data("Sum",values[0]));
        IncomeTax.getData().add(new XYChart.Data("Sum",values[1]));
        SocialTax.getData().add(new XYChart.Data("Sum",values[2]));

        StackedBarChart.getData().addAll(NetSal);
        StackedBarChart.getData().addAll(IncomeTax);

        StackedBarChart.getData().addAll(SocialTax);
    }
}
