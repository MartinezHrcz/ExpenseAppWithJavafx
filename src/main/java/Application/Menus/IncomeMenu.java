package Application.Menus;

import Application.Classes.ListIncomeExpenses;
import Application.Exceptions.NumberOutOfRange;
import Application.Utils.Menu;

import java.io.IOException;
import java.util.Scanner;

public class IncomeMenu {
    //Menu items stored in local variable
    private final static String[] MENU_ITEMS = {"Új Megadása", "Törlés", "Megtekintés", "Megtekintés részletesen", "Type \"exit\" to go back"};
    //Entry Point
    public static void RunIncome() throws IOException {
        IncomeMainMenu();
    }
    //Main menu
    private static void IncomeMainMenu() throws IOException {
        Scanner userInputSC = new Scanner(System.in);
        String input = "";

        while (!input.trim().equalsIgnoreCase("exit")){
            //Menu util used for menu items
            System.out.println("Income Menu:");
            Menu.displayMenuIndexed(MENU_ITEMS);
            //get input
            input = userInputSC.nextLine();
            if (!input.trim().equalsIgnoreCase("exit")) {
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
            case 1: AddIncome();break;
            case 2: RemoveIncome();break;
            case 3:
                try{
                    ShowIncome(false);
                } catch (IOException e) {
                    throw new IOException(e);
                }
                break;
            case 4:
                try{
                    ShowIncome(true);
                } catch (IOException e) {
                    throw new IOException(e);
                }
                break;
        }
    }
    //Adding income
    private static void AddIncome() throws IOException {
        ListIncomeExpenses.AddtoIncomeList();
    }
    //Removing Income
    private static void RemoveIncome() throws IOException {
        ListIncomeExpenses.RemoveFromIncomeList();
    }
    //just lists the incomes
    private static void ShowIncome(boolean detail) throws IOException {
        ListIncomeExpenses.ListIncomeList(detail);
    }
}