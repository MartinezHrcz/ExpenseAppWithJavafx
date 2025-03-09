package Application.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

public class Income {
    private String nameOfIncome;
    private double incomeAmount;
    //Description of the income source
    private String desc;
    //used if an income source is reoccuring
    @JsonIgnoreProperties(ignoreUnknown = true)
    private int dateOfrecurrence = 0;

    public Income() {

    }

    //Constructor for every variable
    public Income(String nameOfIncome, double incomeAmount, String desc, int date) {
        this.nameOfIncome = nameOfIncome;
        this.incomeAmount = incomeAmount;
        this.desc = desc;
        this.dateOfrecurrence = date;
    }
    //Constructor without Day of reoccurence
    public Income(String nameOfIncome,double incomeAmount, String desc) {
        this.nameOfIncome = nameOfIncome;
        this.incomeAmount = incomeAmount;
        this.desc = desc;
    }

    public String getNameOfIncome() {
        return nameOfIncome;
    }

    public double getIncomeAmount() {
        return incomeAmount;
    }

    public String getDesc() {
        return desc;
    }

    public int getDateOfrecurrence() {
        return dateOfrecurrence;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("Name=").append(nameOfIncome).append(" | ");
        sb.append("Amount=").append(incomeAmount).append(" | ");
        sb.append("Description='").append(desc).append(" | ");
        if(LocalDate.now().getDayOfMonth() < dateOfrecurrence){
            sb.append("Days till next =")
                    .append(((Integer)dateOfrecurrence == null || dateOfrecurrence == 0) ? "Doesn't reoccur" :  dateOfrecurrence-LocalDate.now().getDayOfMonth());
        }
        else{
            sb.append("Days till next=")
                    .append(((Integer)dateOfrecurrence == null || dateOfrecurrence == 0) ? "Doesn't reoccur" : (30- LocalDate.now().getDayOfMonth()) + dateOfrecurrence );
        }

        return sb.toString();
    }
}
