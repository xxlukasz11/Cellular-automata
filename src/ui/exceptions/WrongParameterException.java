package ui.exceptions;

public class WrongParameterException extends Exception {


	public WrongParameterException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	private String message;
}
