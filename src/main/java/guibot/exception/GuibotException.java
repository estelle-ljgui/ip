package guibot.exception;

/**
 * Checked exceptions in Guibot
 */
public class GuibotException extends Exception {

	/**
	 * Initialises a GuibotException object
	 *
	 * @param message Error message to be shown to user
	 */
	public GuibotException(String message) {
		super(message);
	}
}
