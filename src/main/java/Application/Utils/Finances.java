package Application.Utils;
import java.util.Scanner;

public class Finances {
    //Calculates the net salary from input
    //Doesn't include incomeTax if the user is under 25
    public static float[] AfterTaxAmount(float grossSalary, boolean under25){
        float incomeTax = under25 ? 0: (float) (grossSalary * 0.15);
        float socialSecurity = (float) (grossSalary * 0.185);
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
