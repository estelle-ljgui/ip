package guibot.command;

import guibot.Storage;
import guibot.TaskList;
import guibot.Ui;

/**
 * Command to print tasks in the list.
 */
public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showString("Here are the tasks in your list:" + tasks.toString());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
