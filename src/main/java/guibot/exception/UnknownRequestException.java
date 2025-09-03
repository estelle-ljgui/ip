package guibot.exception;

public class UnknownRequestException extends GuibotException {
	public UnknownRequestException() {
		super("Sorry, I do not know what you want.\n\t  Here are some commands you can use:\n\t    - todo\n\t    - deadline\n\t    - event\n\t    - mark\n\t    - unmark\n\t    - list\n\t    - find\n\t    - delete");
	}
}
