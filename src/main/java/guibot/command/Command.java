package guibot.command;

import guibot.Storage;
import guibot.TaskList;
import guibot.Ui;
import guibot.exception.GuibotException;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws GuibotException;

    public abstract boolean isExit();
}
