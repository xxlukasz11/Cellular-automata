package ui.exceptions;

public class NotNumberException extends NumberFormatException {

    public NotNumberException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    private String message;
}
