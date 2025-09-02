package guibot;

import guibot.command.Command;
import guibot.command.AddCommand;
import guibot.command.DeleteCommand;
import guibot.command.MarkCommand;
import guibot.command.UnmarkCommand;
import guibot.command.ListCommand;
import guibot.command.ExitCommand;
import guibot.exception.GuibotException;
import guibot.exception.UnknownRequestException;
import guibot.task.Task;
import guibot.task.TaskType;
import guibot.task.Todo;
import guibot.task.Deadline;
import guibot.task.Event;

/**
 * Converts input into a command
 */
public class Parser {
	
	/**
	 * Converts input into a command
	 *
	 * @param input The input in String format
	 * @throws GuibotException If input is missing arguments
	 */
	public static Command parse(String input) throws GuibotException {
		String[] splitInput = input.split(" ", 2);
		switch (splitInput[0]) {
			case "bye":
				return new ExitCommand();
			case "list":
				return new ListCommand();
			case "mark":
				if (splitInput.length == 2 && splitInput[1].matches("[0-9]*")) {
					return new MarkCommand(Integer.parseInt(splitInput[1]) - 1);
				} else {
					throw new GuibotException("Please type \"mark <index of task>\".");
				}
			case "unmark":
				if (splitInput.length == 2 && splitInput[1].matches("[0-9]*")) {
					return new UnmarkCommand(Integer.parseInt(splitInput[1]) - 1);
				} else {
					throw new GuibotException("Please type \"unmark <index of task>\".");
				}
			case "delete":
				if (splitInput.length == 2 && splitInput[1].matches("[0-9]*")) {
					return new DeleteCommand(Integer.parseInt(splitInput[1]) - 1);
				} else {
					throw new GuibotException("Please type \"delete <index of task>\"");
				}
			case "todo":
				return new AddCommand(new Todo(getDetails(TaskType.TODO, splitInput)));
			case "deadline":
				return new AddCommand(new Deadline(getDetails(TaskType.DEADLINE, splitInput)));
			case "event":
				return new AddCommand(new Event(getDetails(TaskType.EVENT, splitInput)));
			default:
				throw new UnknownRequestException();
		}
	}

	private static String[] getDetails(TaskType taskType, String[] splitInput) throws GuibotException {
		
		String[] splitters = {};
		String errorMessage = "";

		switch (taskType) {
		case TODO:
			splitters = new String[] {};
			errorMessage = "Please type \"todo <description of task>\".";
			break;
		case DEADLINE:
			splitters = new String[] {" /by "};
			errorMessage = "Please type \"deadline <description of task> /by <deadline of task>\".";
			break;
		case EVENT:
			splitters = new String[] {" /from ", " /to "};
			errorMessage = "Please type \"event <description of event> /from <start of event> /to <end of event>\".";
			break;
		}

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
