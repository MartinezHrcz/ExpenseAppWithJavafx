package Application.Utils;

import Application.Classes.Income;
import Application.Interfaces.GeneralListFunctions;
import UI.ExceptionController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class IncomeListUtils implements GeneralListFunctions {

    //used to store income sources
    private static List<Income> IncomeList = new ArrayList<>();

    //Adds income source to the list, returns true if it was succesful
    public static boolean AddtoList(String name, double amount, String desc, int Date) {
        Income income;
        //Removing unnecessary spaces
        name = name.trim();
        desc = desc.trim();
        //Prechecks for invalid inputs
        if (name.length() == 0 || amount<0 || (Date < 0 || Date > 30)){
            return false;
        }
        income = new Income(name, amount,desc, Date);
        IncomeList.add(income);
        return true;
    }

    public static boolean AddtoList(Income income) {
        IncomeList.add(income);
        return true;
    }

    //Removes income source from the list, returns true if it was succesful
    public static boolean RemoveFromList(Income deleteIncome) {
        //precheck
        if (IncomeList.isEmpty()) {
            //shows error window if there is no income source
            try {
                ExceptionController.ShowErrorWindow("","");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return false;
        }

        //Removes the selected object
        IncomeList.remove(deleteIncome);
        return true;
    }
    //Returns the sum of the sources
    public static double Sum() {
        double sum = 0;
        for (Income income : IncomeList){
            sum += income.getIncomeAmount();
        }
        return sum;
    }

    public static List<Income> getIncomeList() {
        return IncomeList;
    }
}
