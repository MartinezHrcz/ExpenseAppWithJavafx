package Application.Utils;

import Application.Classes.Expenses;
import Application.Interfaces.GeneralListFunctions;
import UI.ExceptionController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class ExpenseListUtils implements GeneralListFunctions {
    //used to store expenditure
    private static List<Expenses> ExpensesList= new ArrayList<>();

    //Adds expense to the list, returns true if it was succesful
    public static boolean AddtoList(String name, double amount, String desc, int Date, boolean ess, boolean checked) {
        Expenses expense;
        name = name.trim();
        desc = desc.trim();
        if (name.length() == 0 || amount<0 || (Date < 0 || Date > 30)){
            return false;
        }
        expense = new Expenses(name,desc,amount,ess,checked);
        ExpensesList.add(expense);
        return true;
    }
    public static boolean AddtoList(Expenses expense) {
        ExpensesList.add(expense);
        return true;
    }

    //Removes expence from the list, returns true if it was succesful
    public static boolean RemoveFromList(Expenses deleteExpense) {
        //Precheck
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
    //Returns the sum of the sources
    public static double Sum() {
        double sum = 0;
        for (Expenses expense : ExpensesList){
            sum += expense.getAmount();
        }
        return sum;
    }

    public static List<Expenses> getExpensesList() {
        return ExpensesList;
    }
}
