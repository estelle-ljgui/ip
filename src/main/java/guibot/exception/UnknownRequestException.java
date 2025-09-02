package guibot.exception;

/**
 * Exception when user inputs an unknown request
 */
public class UnknownRequestException extends GuibotException {
	/**
	 * Initialises an UnknownRequestException object
	 */
	public UnknownRequestException() {
		super("Sorry, I do not know what you want.\n\t  Here are some commands you can use:\n\t    - todo\n\t    - deadline\n\t    - event\n\t    - mark\n\t    - unmark\n\t    - list\n\t    - delete");
	}
}
