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

    public static float[] AfterTaxAmount(float grossSalary, boolean under25){
        float incomeTax = (float) (grossSalary * 0.15);
        float socialSecurity = (float) (grossSalary * 0.185);
        // returns net salary, incomeTax and social security tax
        return new float[]{grossSalary - (incomeTax + socialSecurity), incomeTax, socialSecurity};
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
