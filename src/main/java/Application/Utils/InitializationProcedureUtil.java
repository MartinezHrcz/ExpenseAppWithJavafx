package Application.Utils;

import Application.Classes.Expenses;
import Application.Classes.Income;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InitializationProcedureUtil {
    public static boolean StartInit(){
        if (LoadIncome() && LoadExpense()){
            System.out.println("All good");
        }
        return false;
    }

    private static boolean LoadIncome() {
        ObjectMapper obm = new ObjectMapper();
        File file = new File("src/main/appData/Income.json");
        if (file.exists()) {
            List<Income> InitFileData ;
            try {
                InitFileData = obm.readValue(file, new TypeReference<List<Income>>(){});
                for (Income income : InitFileData) {
                    IncomeListUtils.AddtoList(income);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            return true;
        }
        return false;
    }

    private static boolean LoadExpense() {
        ObjectMapper obm = new ObjectMapper();
        File file = new File("src/main/appData/Expense.json");
        if (file.exists()) {
            List<Expenses> InitFileData ;
            try {
                InitFileData = obm.readValue(file, new TypeReference<List<Expenses>>(){});
                for (Expenses expense : InitFileData) {
                    ExpenseListUtils.AddtoList(expense);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            return true;
        }
        return false;
    }
}
