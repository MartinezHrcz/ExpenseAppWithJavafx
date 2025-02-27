package Application.Menus;

import Application.Exceptions.NumberOutOfRange;
import Application.Utils.Finances;
import Application.Utils.Menu;

import java.io.IOException;
import java.util.Scanner;

public class FinancesMenu {



    private final static String[] MENU_ITEMS = {
            "Maradék megtekintése",
            "Teljes bevétel",
            "Bruttó fizetés kalkulátor",
            "Áfa Kalkulátor",
            "Type \"exit\" to go back"};

    public static void RunFinances() {
        FinancesMainMenu();
    }

    private static void FinancesMainMenu() {
        Scanner userInputSC = new Scanner(System.in);
        String input = "";

        while (!input.trim().equalsIgnoreCase("exit")){
            //Menu util used for menu items
            System.out.println("Finances Menu:");
            Menu.displayMenuIndexed(MENU_ITEMS);
            //get input
            input = userInputSC.nextLine();
            if (!input.trim().equalsIgnoreCase("exit")) {
       //         Redirecting(input.trim());
            }
        }
    }

    /*private static void Redirecting(String input) {
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
               case 1:
                   System.out.print("Maradék összeg kiadások után:");
                   System.out.println(Finances.RemainingFunds());
                   System.out.println("Press any key to continue");
                   try {
                       System.in.read();
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }
                   break;
               case 2:
                   System.out.print("Teljes bevétel: ");
                   System.out.println(Finances.TotalFunds());
                   try {
                       System.in.read();
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }
                   break;
               case 3:
                   System.out.println(Finances.AfterTaxAmount());
                   try {
                       System.in.read();
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }
                   break;
               case 4:
                   System.out.println(Finances.AfaCalculation());
                   try {
                       System.in.read();
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }
                   break;
        }
    }*/
}
