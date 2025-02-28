package Application.Utils;

import Application.Classes.Income;
import Application.Interfaces.GeneralListFunctions;
import UI.ExceptionController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class IncomeListUtils implements GeneralListFunctions {

    public static List<Income> IncomeList = new ArrayList<>();
    public static boolean AddtoList(String name, double amount, String desc, int Date, boolean ess, boolean checked) {
        Income i;
        //Precheck
        name = name.trim();
        desc = desc.trim();

        if (name.length() == 0 || amount<0 || (Date < 0 || Date > 30)){
            return false;
        }
        i = new Income(name, amount,desc, Date);
        IncomeList.add(i);
        return true;
    }

    public static boolean RemoveFromList(Income deleteIncome) {
        if (IncomeList.isEmpty()) {
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

    public static double Sum() {
        double sum = 0;
        for (Income income : IncomeList){
            sum += income.getIncomeAmount();
        }
        return sum;
    }
}
