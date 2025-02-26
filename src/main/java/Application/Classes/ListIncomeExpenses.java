package Application.Classes;

import UI.ExceptionController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

    /*
    |---------------------------|
    |ToDo: Make the income      |
    |and expenses into          |
    |a single method with a bool|
    |___________________________|
    */


public class ListIncomeExpenses {
    //Stores the Income values
    public static List<Income> IncomeList = new ArrayList<>();
    //Stores the Expense values
    public static List<Expenses> ExpensesList= new ArrayList<>();

    //Income methods:

    //Adds value to Income list
    public static boolean AddtoIncomeList(String name, double amount, String desc, int Date) {
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

    //Removes specified Income from IncomeList
    public static void RemoveFromIncomeList(Income deleteIncome) {
        //Precheck if Incomelist is empty
        if (IncomeList.isEmpty()) {
            try {
                ExceptionController.ShowErrorWindow("","");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }

        //Removes the selected object
        IncomeList.remove(deleteIncome);
    }

    //Prints IncomeList to console
    public static void ListIncomeList(boolean detailed) throws IOException {
        int index = 0;
        for (Income income : ListIncomeExpenses.IncomeList){
            index++;
            //Detail levels:
            //1.Everything is shown
            //2.Only the name and amount
            if (detailed == true) {
                System.out.println(index + ". " + income.toString());
            } else {
                System.out.println(index + ". " + income.getNameOfIncome() + ": " + income.getIncomeAmount());
            }

        }
        System.out.println("Press any key to continue...");
    }
    //-------------------------------------------

    //Expenses methods:

    //Adds value to Expenses list
    public static boolean AddtoExpensesList(String name, Double amount, String desc, boolean ess, boolean checked ) throws IOException {
        Expenses expense = new Expenses(name,desc,amount,ess,checked);
        ExpensesList.add(expense);
        return true;
    }

    //Removes specified Expense from ExpensesList
    public static void RemoveFromExpensesList(Expenses deleteExpense) {
        //Precheck if ExpensesList is empty
        if (ExpensesList.isEmpty()) {
            try {
                ExceptionController.ShowErrorWindow("", "");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        ExpensesList.remove(deleteExpense);
    }

    public static double IncomeSum(){
        double sum = 0;
        for (Income income : IncomeList){
            sum += income.getIncomeAmount();
        }
        return sum;
    }

    public static double ExpenseSum() {
        double sum = 0;
        for (Expenses expense : ExpensesList){
            sum += expense.getAmount();
        }
        return sum;
    }

    public static double RemainingFunds() {
        return IncomeSum() - ExpenseSum();
    }
}