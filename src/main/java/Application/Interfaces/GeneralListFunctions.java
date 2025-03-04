package Application.Interfaces;

public interface GeneralListFunctions {
    boolean AddToList(String name, double amount, String desc, int Date,  boolean ess, boolean checked);
    boolean RemoveFromList();
    static double Sum(){double sum = 0; return sum;};

}
