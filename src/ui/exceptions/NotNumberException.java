package ui.exceptions;

public class NotNumberException extends NumberFormatException {

    @Override
    public String getMessage() {
        return "Unable to convert to number";
    }
}
