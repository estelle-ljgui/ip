package guibot.command;

import guibot.Storage;
import guibot.TaskList;
import guibot.Ui;
import guibot.exception.GuibotException;

/**
 * Command to mark a task as not done.
 */
public class UnmarkCommand extends Command {
    private int index;

    /**
     * Creates an UnmarkCommand.
     *
     * @param index Index of task to be marked as not done.
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws GuibotException {
        String taskString = tasks.unmark(index);
        storage.saveTasks(tasks);
        ui.showString(String.format("OK, I've marked this task as not done yet:\n\t    %s",
                taskString, tasks.size()));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
