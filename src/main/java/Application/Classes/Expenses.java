package Application.Classes;

public class Expenses {
    //Name of expense
    private String Name;
    //Description of the expense
    private String Desc;
    //The amont of the expense
    private double Amount;
    //If the expense is payed off
    //When constructed it is allways false
    private boolean Checked;
    //if the expense is true or false
    private boolean Essential;
    private int dateOfrecurrenceDay;

    //Constructor with every variable
    public Expenses(String Name, String Desc, double Amount, boolean Essential, int dateOfrecurrenceDay) {
        this.Name = Name;
        this.Desc = Desc;
        this.Amount = Amount;
        this.Checked = false;
        this.Essential = Essential;
        this.dateOfrecurrenceDay = dateOfrecurrenceDay;
    }
    //Constructor without essential variable and date ofOfreoccurence
    public Expenses(String Name, String Desc, double Amount) {
        this.Name = Name;
        this.Desc = Desc;
        this.Amount = Amount;
        this.Checked = false;
    }
    //Constructor without reoccurence
    public Expenses(String Name, String Desc, double Amount, boolean Essential) {
        this.Name = Name;
        this.Desc = Desc;
        this.Amount = Amount;
        this.Checked = false;
        this.Essential = Essential;
    }
    //Constructor without essential
    public Expenses(String Name, String Desc, double Amount, int dateOfrecurrenceDay) {
        this.Name = Name;
        this.Desc = Desc;
        this.Amount = Amount;
        this.Checked = false;
        this.dateOfrecurrenceDay = dateOfrecurrenceDay;
    }


    //Getters
    //-----------------------------------------
    public String getName() {
        return Name;
    }

    public String getDesc() {
        return Desc;
    }

    public double getAmount() {
        return Amount;
    }

    public boolean getChecked() {
        return Checked;
    }

    public void setChecked(boolean checked) {
        Checked = checked;
    }
    //-----------------------------------------

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("Name=").append(Name).append('\n');
        sb.append("Description='").append(Desc).append('\n');
        sb.append("Amount=").append(Amount).append('\n');
        //Tenary operator for checkmark or X
        sb.append("Paid=").append(Checked ? "\u2713" : "X" ).append('\n');
        //Tenary operator for the essential variable
        if((Boolean)Essential != null){
            sb.append(this.Essential ? "Essential" : "Non-Essential").append('\n');
        }
        return sb.toString();
    }

}
