package Application.Utils;

import java.util.Arrays;

public class Menu {

    //Prints out given menu items
    public static void displayMenu(String[] menuItems) {
        Arrays.stream(menuItems).forEach(System.out::println);
    }

    //Prints out given menu items with indexes
    public static void displayMenuIndexed(String[] menuItems) {
        int index = 0;
        for(String item : menuItems) {
            index++;
            System.out.println(index+"."+item);
        }
    }
}
