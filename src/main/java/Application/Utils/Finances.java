package Application.Utils;

import Application.Classes.Expenses;
import Application.Classes.Income;
import Application.Classes.ListIncomeExpenses;

import java.util.Scanner;

public class Finances {

    public static double RemainingFunds(){
        double funds = 0;

        for (Income i : ListIncomeExpenses.IncomeList){
            funds += i.getIncomeAmount();
        }

        for (Expenses e : ListIncomeExpenses.ExpensesList){
            funds -= e.getAmount();
        }

        return funds;
    }

    public static double TotalFunds(){
        double funds = 0;
        for (Income i : ListIncomeExpenses.IncomeList){
            funds += i.getIncomeAmount();
        }
        return funds;
    }

    public static double AfterTaxAmount(){
        double funds = 0;
        Scanner userInputSC = new Scanner(System.in);
        System.out.print("Kérem adja meg a bruttó fizetését: ");
        do {
            try{
                funds = Double.parseDouble(userInputSC.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Not a valid number!");
                funds = 0;
            }
        }
        while (funds <= 0);
        System.out.print("Bruttó fizetés: ");
        return funds*0.665;
    }

    public static double AfaCalculation(){
        double price = 0;
        double afa = 0;
        Scanner userInputSC = new Scanner(System.in);
        System.out.print("Adja meg az áfás termék árát: ");
        do{
            try{
                price = Double.parseDouble(userInputSC.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Not a valid number!");
                price = 0;
            }

        }while (price <= 0);

        System.out.println("Áfa: ");
        do{
            try{
                afa = Double.parseDouble(userInputSC.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Not a valid number!");
                afa = 0;
            }

        }while (afa <= 0);
        afa /=100;
        System.out.println("Afa:" + afa);
        afa++;
        System.out.print("Áfa nélkül: ");
        return price/afa;
    }

}
