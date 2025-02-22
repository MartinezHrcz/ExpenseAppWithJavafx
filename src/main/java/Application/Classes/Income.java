package Application.Classes;

public class Income {

    private String nameOfIncome;

    private double incomeAmount;
    //Description of the income source
    private String desc;
    //used if an income source is reoccuring
    private int dateOfrecurrenceDay;

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
        //Tenary for checking if an income source is reoccuring
        sb.append("Reoccurence=")
                .append(((Integer)dateOfrecurrenceDay == null || dateOfrecurrenceDay == 0) ? "Doesn't reoccur" : dateOfrecurrenceDay);
        return sb.toString();
    }
}
