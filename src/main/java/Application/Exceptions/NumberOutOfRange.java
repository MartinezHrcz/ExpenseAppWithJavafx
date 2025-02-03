package Application.Exceptions;

//Exception for handling if the number is out of the valid range
public class NumberOutOfRange extends NumberFormatException {
    public NumberOutOfRange(String message) {
        super("Invalid Number: " + message);
    }
}
