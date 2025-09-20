package guibot.command;

import guibot.Storage;
import guibot.TaskList;

/**
 * Command to print tasks in the list.
 */
public class ListCommand extends Command {
    private String output = "Here are the tasks in your list:%s";

    @Override
    public String execute(TaskList tasks, Storage storage) {
        assert tasks != null : "Cannot list a null tasklist";
        return String.format(output, tasks.toString());
    }
}
