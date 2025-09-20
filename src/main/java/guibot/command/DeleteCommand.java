package guibot.command;

import guibot.Storage;
import guibot.TaskList;
import guibot.exception.GuibotException;

/**
 * Command to delete a task from the list.
 */
public class DeleteCommand extends Command {
    private int index;
    private String output = "Noted. I've removed this task:\n%s\nNow you have %d tasks in the list.";

    /**
     * Creates a DeleteCommand.
     *
     * @param index Index of task to be deleted.
     */
    public DeleteCommand(int index) {
        assert index != null : "Cannot make a DeleteCommand with a null index";
        this.index = index;
    }

    @Override
    public String execute(TaskList tasks, Storage storage) throws GuibotException {
	assert tasks != null : "Cannot delete from a null tasklist";
        String taskString = tasks.delete(index);
	assert storage != null : "Cannot save to a null storage";
        storage.saveTasks(tasks);
        return String.format(output, taskString, tasks.size());
    }
}
