package Application.Classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public static boolean AddtoIncomeList(String name, double amount, String desc, String Date) {
        Income i;
        //Precheck
        name = name.trim();
        desc = desc.trim();

        if (name.length() == 0 || amount<0 || Date.length() == 0){
            return false;
        }
        i = new Income(name, amount, desc);
        IncomeList.add(i);
        return true;
    }

    //Removes specified Income from IncomeList
    public static void RemoveFromIncomeList() throws IOException {
        //Precheck if Incomelist is empty
        if (IncomeList.isEmpty()) {
            System.out.println("Nothing to remove");
            return;
        }

        int index = 0;
        //Listsincome list but only it's name
        //Just prints out on the console
        for (Income i : IncomeList) {
            index++;
            System.out.println(index + "." +i.getNameOfIncome());
        }

        Scanner userDeleteSC = new Scanner(System.in);
        String input;
        int inputInt = 0; //for the list.get
        //User input of which index to delete
        do{
            try{
                input = userDeleteSC.nextLine();
                inputInt = Integer.parseInt(input);
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input, please try again!");
            }
        }
        while (inputInt < 1 || inputInt > IncomeList.size());
        //Removes the selected object
        IncomeList.remove(IncomeList.get(inputInt-1));
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
    public static void AddtoExpensesList() throws IOException {
        Scanner userExpInputSC = new Scanner(System.in);
        Expenses e;
        //Data gathering about the expense:

        System.out.println("Is this expense reoccuring? (Y/N)");
        String reo = userExpInputSC.nextLine(); //reoccurence

        System.out.println("Name of expense: ");
        String name = userExpInputSC.nextLine(); //Name of the expense

        System.out.println("Description of expense:");
        String description = userExpInputSC.nextLine(); //Description of the expense

        System.out.println("Is this expense essential? (Y/N)");
        String ess = userExpInputSC.nextLine();//is the expense essential?
        //loops untill it is y/n
        while (!(ess.trim().toLowerCase().equals("y") || ess.trim().toLowerCase().equals("n"))) {
            System.out.println("Invalid input, please try again!");
            ess = userExpInputSC.nextLine();
        }

        //amount is asked until it is valid
        System.out.println("Amount of expense: ");
        double amount=0;
        do {
            try
            {
                amount = Double.parseDouble(userExpInputSC.nextLine());
            } catch (NumberFormatException ex) {
                System.out.printf("Invalid input, please try again!");
            }
        }
        while (amount < 1);
        //Only gets called if the income is reoccuring
        if (reo.trim().toLowerCase().equals("y")) {
            System.out.println("Date (Day of month) of reoccurenc: ");
            int date = 0;
            //tries to get a date if it isn't in the valid range
            do {
                //for checking if the value is
                try {
                    date = Integer.parseInt(userExpInputSC.nextLine());
                } catch (NumberFormatException error) {
                    System.out.println("Invalid date, please try again!");
                }
            }
            while (date < 1 || date > 30);
            //here object
            e = ess.trim().toLowerCase().equals("y") ?
                    new Expenses(name,description, amount, true, date)
                    :
                    new Expenses(name,description,amount,false,date);
        }
        //if the expense isn't reoccuring
        else{
            e = ess.trim().toLowerCase().equals("y") ?
                    new Expenses(name,description, amount, true)
                    :
                    new Expenses(name,description,amount,false);
        }
        ExpensesList.add(e);
    }

    //Removes specified Expense from ExpensesList
    public static void RemoveFromExpensesList() throws IOException {
        //Precheck if ExpensesList is empty
        if (ExpensesList.isEmpty()) {
            System.out.println("Nothing to remove");
            return;
        }

        int index = 0;
        //ListExpense list but only it's name
        for (Expenses expenses : ExpensesList) {
            index++;
            System.out.println(index + "." +expenses.getName());
        }

        Scanner userDeleteSC = new Scanner(System.in);
        String input;
        int inputInt = 0;
        //User input of which index to delete
        do{
            try{
                input = userDeleteSC.nextLine();
                inputInt = Integer.parseInt(input);
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input, please try again!");
            }
        }while (inputInt < 1 || inputInt > ExpensesList.size());
        //Removes the selected object
        ExpensesList.remove(ExpensesList.get(inputInt-1));
        System.out.println("Removed!");
        System.out.println("Press any key to continue...");
        System.in.read();
    }

    //Prints ExpensesList to console
    public static void ListExpensesList(boolean detailed) throws IOException {
        int index = 0;
        for (Expenses expense : ExpensesList) {
            index++;
            //detail levels:
            //1.Everything is listed
            //2.Only name and amount
            if (detailed == true) {
                System.out.println(index + ". " + expense.toString());
            }
            else {
                System.out.println(index + ". " + expense.getName() + ": " + expense.getAmount());
            }
        }
        System.out.println("Press any key to continue...");
        System.in.read();
    }
    //--------------------------------------------
}