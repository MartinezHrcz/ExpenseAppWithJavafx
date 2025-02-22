package Application.Menus;

import Application.Classes.ListIncomeExpenses;
import Application.Exceptions.NumberOutOfRange;
import Application.Utils.Menu;

import java.io.IOException;
import java.util.Scanner;

public class ExpensesMenu {
    //Menu items stored in local variable
    private final static String[] MENU_ITEMS = {"Új Megadása", "Törlés", "Megtekintés", "Megtekintés részletesen","Type \"exit\" to go back"};
    //Entry Point
    public static void RunExpenses() throws IOException {
        ExpensesMainMenu();
    }
    //Main menu
    private static void ExpensesMainMenu() throws IOException {
        Scanner userInputSC = new Scanner(System.in);
        String input = "";

        while (!input.equalsIgnoreCase("exit")) {
            //Menu util used for menu items
            System.out.println("Expenses Menu:");
            Menu.displayMenuIndexed(MENU_ITEMS);
            //get input
            input = userInputSC.nextLine();
            if (!input.equalsIgnoreCase("exit")) {
                Redirecting(input.trim());
            }

        }
    }
    //Redirecting and prechecking input
    private static void Redirecting(String input) throws IOException {
        int inputInt = 0;
        //Precheck
        //Checks if the input is blank
        //if blank returns to the RunnerMainMenu method
        if(input.isBlank()){
            return;
        }
        //Checks if the input is a number
        try{
            //Converting to an integer
            inputInt = Integer.parseInt(input.trim());
            //Checks if a number is in valid range
            if (inputInt < 1 || inputInt > MENU_ITEMS.length){
                System.out.println( new NumberOutOfRange(input).getMessage());
            }
        }
        catch (NumberFormatException e){
            System.out.println("Not a number");
        }
        //Redirecting
        switch (inputInt){
            case 1: AddExpense();break;
            case 2: RemoveExpense();break;
            case 3:
                try{
                    ShowExpense(false);
                } catch (IOException e) {
                    throw new IOException(e);
                }
                break;
            case 4:
                try{
                    ShowExpense(true);
                } catch (IOException e) {
                    throw new IOException(e);
                }
                break;
        }
    }
    //Adding income
    private static void AddExpense() throws IOException {
        //ListIncomeExpenses.AddtoExpensesList();
    }
    //Removing Income
    private static void RemoveExpense() throws IOException {
        //ListIncomeExpenses.RemoveFromExpensesList();
    }
    //just lists the incomes
    private static void ShowExpense(boolean detail) throws IOException {
        //ListIncomeExpenses.ListExpensesList(detail);
    }
}
