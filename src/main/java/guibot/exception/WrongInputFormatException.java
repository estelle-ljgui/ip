package guibot.exception;

import guibot.command.CommandType;

/**
 * Exception when user inputs a command in the wrong format.
 */
public class WrongInputFormatException extends GuibotException {
    /**
     * Creates a WrongInputFormatException.
     */
    public WrongInputFormatException(CommandType commandType) {
        super(String.format("Please type \"%s\".", commandType.getExpectedInputFormat()));
    }
}
