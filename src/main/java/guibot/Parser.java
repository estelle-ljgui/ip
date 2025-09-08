package guibot;

import guibot.command.AddCommand;
import guibot.command.Command;
import guibot.command.CommandType;
import guibot.command.DeleteCommand;
import guibot.command.ExitCommand;
import guibot.command.FindCommand;
import guibot.command.ListCommand;
import guibot.command.MarkCommand;
import guibot.command.UnmarkCommand;
import guibot.exception.UnknownRequestException;
import guibot.exception.WrongInputFormatException;
import guibot.task.Deadline;
import guibot.task.Event;
import guibot.task.Todo;

/**
 * Handles string input.
 */
public class Parser {
    /**
     * Converts input into a command.
     *
     * @param input The input in String format.
     * @throws GuibotException If input is missing arguments.
     */
    public static Command parse(String input) throws UnknownRequestException, WrongInputFormatException {
        String[] splitInput = input.split(" ", 2);
        return switch (splitInput[0]) {
        case "bye" -> new ExitCommand();
        case "list" -> new ListCommand();
        case "find" -> new FindCommand(getSecondString(CommandType.FIND, splitInput));
        case "mark" -> new MarkCommand(getIndex(CommandType.MARK, splitInput));
        case "unmark" -> new UnmarkCommand(getIndex(CommandType.UNMARK, splitInput));
        case "delete" -> new DeleteCommand(getIndex(CommandType.DELETE, splitInput));
        case "todo" -> new AddCommand(new Todo(getSecondString(CommandType.TODO, splitInput)));
        case "deadline" -> new AddCommand(new Deadline(getDetails(CommandType.DEADLINE, splitInput)));
        case "event" -> new AddCommand(new Event(getDetails(CommandType.EVENT, splitInput)));
        default -> throw new UnknownRequestException();
        };
    }

    private static String getSecondString(CommandType commandType, String[] splitInput)
            throws WrongInputFormatException {
        if (splitInput.length == 2) {
            return splitInput[1];
        } else {
            throw new WrongInputFormatException(commandType);
        }
    }

    private static int getIndex(CommandType commandType, String[] splitInput) throws WrongInputFormatException {
        if (splitInput.length == 2 && splitInput[1].matches("[0-9]*")) {
            return Integer.parseInt(splitInput[1]) - 1;
        } else {
            throw new WrongInputFormatException(commandType);
        }
    }

    private static String[] getDetails(CommandType commandType, String[] splitInput) throws WrongInputFormatException {
        String[] splitters = commandType.getSplitters();

        if (splitInput.length != 2) {
            throw new WrongInputFormatException(commandType);
        }

        String toSplit = splitInput[1];
        String[] details = new String[splitters.length + 1];

        for (int i = 0; i < splitters.length; i++) {
            String[] temp = toSplit.split(splitters[i], 2);
            if (temp.length < 2) {
                throw new WrongInputFormatException(commandType);
            }
            details[i] = temp[0];
            toSplit = temp[1];
        }

        details[splitters.length] = toSplit;
        return details;
    }
}
