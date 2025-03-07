package Application.Utils;
import UI.StartUI;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ExitProcedureUtil {

    public static void Start(){
        if(SaveIncome() && SaveExpense()){
            Exit();
        }
    }

    private static boolean SaveIncome(){
        File file = new File("src/main/appData/Income.json");
        ObjectMapper obm = new ObjectMapper();
        try {

            if (!file.exists()) {
                file.createNewFile();
            }
            obm.writeValue(file,IncomeListUtils.IncomeList);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private static boolean SaveExpense(){
        File file = new File("src/main/appData/Expense.json");
        ObjectMapper obm = new ObjectMapper();
        try {

            if (!file.exists()) {
                file.createNewFile();
            }
            obm.writeValue(file,ExpenseListUtils.ExpensesList);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private static void Exit(){
        StartUI.window.close();
    }


}
