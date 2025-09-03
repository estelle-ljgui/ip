package guibot;

import guibot.command.AddCommand;
import guibot.command.Command;
import guibot.command.DeleteCommand;
import guibot.command.ExitCommand;
import guibot.command.ListCommand;
import guibot.command.MarkCommand;
import guibot.command.UnmarkCommand;
import guibot.exception.GuibotException;
import guibot.exception.UnknownRequestException;
import guibot.task.Deadline;
import guibot.task.Event;
import guibot.task.TaskType;
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
    public static Command parse(String input) throws GuibotException {
        String[] splitInput = input.split(" ", 2);
        return switch (splitInput[0]) {
        case "bye" -> new ExitCommand();
        case "list" -> new ListCommand();
        case "mark" -> new MarkCommand(getIndex("mark", splitInput));
        case "unmark" -> new UnmarkCommand(getIndex("unmark", splitInput));
        case "delete" -> new DeleteCommand(getIndex("delete", splitInput));
        case "todo" -> new AddCommand(new Todo(getDetails(TaskType.TODO, splitInput)));
        case "deadline" -> new AddCommand(new Deadline(getDetails(TaskType.DEADLINE, splitInput)));
        case "event" -> new AddCommand(new Event(getDetails(TaskType.EVENT, splitInput)));
        default -> throw new UnknownRequestException();
        };
    }

    private static int getIndex(String commandWord, String[] splitInput) throws GuibotException {
        if (splitInput.length == 2 && splitInput[1].matches("[0-9]*")) {
            return Integer.parseInt(splitInput[1]) - 1;
        } else {
            throw new GuibotException(String.format("Please type \"%s <index of task>\".", commandWord));
        }
    }

    private static String[] getDetails(TaskType taskType, String[] splitInput) throws GuibotException {
        String[] splitters = taskType.getSplitters();
        String errorMessage = String.format("Please type \"%s\".", taskType.getExpectedInputFormat());

        if (splitInput.length != 2) {
            throw new GuibotException(errorMessage);
        }

        String toSplit = splitInput[1];
        String[] details = new String[splitters.length + 1];

        for (int i = 0; i < splitters.length; i++) {
            String[] temp = toSplit.split(splitters[i], 2);
            if (temp.length < 2) {
                throw new GuibotException(errorMessage);
            }
            details[i] = temp[0];
            toSplit = temp[1];
        }

        details[splitters.length] = toSplit;
        return details;
    }
}
