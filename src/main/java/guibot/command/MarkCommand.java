package guibot.command;

import guibot.Storage;
import guibot.TaskList;
import guibot.Ui;
import guibot.exception.GuibotException;

public class MarkCommand extends Command {
    private int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws GuibotException {
        String taskString = tasks.mark(index);
        storage.saveTasks(tasks);
        ui.showString(String.format("Nice! I've marked this task as done:\n\t    %s",
                taskString, tasks.size()));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
