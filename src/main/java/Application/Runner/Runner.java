package Application.Runner;

import Application.Utils.InitializationProcedureUtil;
import UI.StartUI;

import java.io.IOException;

public class Runner {
    //Entry point
    public static void main(String[] args) throws IOException {
        InitializationProcedureUtil.StartInit();
        StartUI.main(args);
    }
}
