package Application.Utils;

import Application.Classes.Expenses;
import Application.Interfaces.GeneralListFunctions;
import UI.ExceptionController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class ExpenseListUtils implements GeneralListFunctions {

    public static List<Expenses> ExpensesList= new ArrayList<>();

    public static boolean AddtoList(String name, double amount, String desc, int Date, boolean ess, boolean checked) {
        Expenses expense = new Expenses(name,desc,amount,ess,checked);
        ExpensesList.add(expense);
        return true;
    }

    public static boolean RemoveFromList(Expenses deleteExpense) {
        //Precheck if ExpensesList is empty
        if (ExpensesList.isEmpty()) {
            try {
                ExceptionController.ShowErrorWindow("", "");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return false;
        }
        ExpensesList.remove(deleteExpense);
        return true;
    }

    public static double Sum() {
        double sum = 0;
        for (Expenses expense : ExpensesList){
            sum += expense.getAmount();
        }
        return sum;
    }
}
