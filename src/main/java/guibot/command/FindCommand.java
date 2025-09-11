package guibot.command;

import guibot.Storage;
import guibot.TaskList;

/**
 * Represents a command to find all tasks containing a given string.
 */
public class FindCommand extends Command {
    private String string;
    private String output = "Here are the matching tasks in your list:%s";

    /**
     * Creates a FindCommand.
     */
    public FindCommand(String string) {
        this.string = string;
    }

    @Override
    public String execute(TaskList tasks, Storage storage) {
        TaskList tasksContainingString = tasks.find(string);
        return String.format(output, tasksContainingString.toString());
    }
}
