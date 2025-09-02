package guibot.exception;

public class GuibotException extends Exception {
	private String message;

	public GuibotException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
