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
        this.index = index;
    }

    @Override
    public String execute(TaskList tasks, Storage storage) throws GuibotException {
        String taskString = tasks.delete(index);
        storage.saveTasks(tasks);
        return String.format(output, taskString, tasks.size());
    }
}
