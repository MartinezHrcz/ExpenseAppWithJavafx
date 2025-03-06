package Application.Utils;
import Application.Classes.Income;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.controlsfx.tools.Utils;

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
        System.out.println(file.getAbsolutePath());
        ObjectMapper obm = new ObjectMapper();
        try {
            if (!file.exists()) {
                file.createNewFile();

            }
            obm.writeValue(file, new Income("ljdsfk",12,"sdf",12));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    private static boolean SaveExpense(){
        return true;
    }
    private static boolean Exit(){
        return true;
    }


}
