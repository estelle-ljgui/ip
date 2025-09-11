package guibot.command;

import guibot.Storage;
import guibot.TaskList;
import guibot.exception.GuibotException;

/**
 * Command to mark a task as not done.
 */
public class UnmarkCommand extends Command {
    private int index;
    private String output = "OK, I've marked this task as not done yet:\n%s";

    /**
     * Creates an UnmarkCommand.
     *
     * @param index Index of task to be marked as not done.
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(TaskList tasks, Storage storage) throws GuibotException {
        String taskString = tasks.unmark(index);
        storage.saveTasks(tasks);
        return String.format(output, taskString);
    }
}
