package Application.Classes;

import java.time.LocalDate;

public class Income {

    private String nameOfIncome;

    private double incomeAmount;
    //Description of the income source
    private String desc;
    //used if an income source is reoccuring
    private int dateOfrecurrenceDay = 0;

    //Constructor for every variable
    public Income(String nameOfIncome, double incomeAmount, String desc, int date) {
        this.nameOfIncome = nameOfIncome;
        this.incomeAmount = incomeAmount;
        this.desc = desc;
        this.dateOfrecurrenceDay = date;
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
        return dateOfrecurrenceDay;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("Name=").append(nameOfIncome).append(" | ");
        sb.append("Amount=").append(incomeAmount).append(" | ");
        sb.append("Description='").append(desc).append(" | ");
        if(LocalDate.now().getDayOfMonth() < dateOfrecurrenceDay){
            sb.append("Days till next =")
                    .append(((Integer)dateOfrecurrenceDay == null || dateOfrecurrenceDay == 0) ? "Doesn't reoccur" :  dateOfrecurrenceDay-LocalDate.now().getDayOfMonth());
        }
        else{
            sb.append("Days till next=")
                    .append(((Integer)dateOfrecurrenceDay == null || dateOfrecurrenceDay == 0) ? "Doesn't reoccur" : (30- LocalDate.now().getDayOfMonth()) + dateOfrecurrenceDay );
        }

        return sb.toString();
    }
}
