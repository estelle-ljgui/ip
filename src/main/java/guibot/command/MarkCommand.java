package guibot.command;

import guibot.Storage;
import guibot.TaskList;
import guibot.exception.GuibotException;

/**
 * Command to mark a task as done.
 */
public class MarkCommand extends Command {
    private int index;
    private String output = "Nice! I've marked this task as done:\n%s";

    /**
     * Creates a MarkCommand.
     *
     * @param index Index of task to be marked as done.
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(TaskList tasks, Storage storage) throws GuibotException {
        String taskString = tasks.mark(index);
        storage.saveTasks(tasks);
        return String.format(output, taskString);
    }
}
