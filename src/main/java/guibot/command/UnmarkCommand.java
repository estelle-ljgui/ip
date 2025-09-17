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
        assert index != null : "Cannot make an UnmarkCommand with a null index";
        this.index = index;
    }

    @Override
    public String execute(TaskList tasks, Storage storage) throws GuibotException {
        assert tasks != null : "Cannot unmark a task in a null tasklist";
        String taskString = tasks.unmark(index);
	assert storage != null : "Cannot save to a null storage";
        storage.saveTasks(tasks);
        return String.format(output, taskString);
    }
}
