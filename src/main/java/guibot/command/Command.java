package guibot.command;

import guibot.exception.GuibotException;
import guibot.Storage;
import guibot.TaskList;
import guibot.Ui;

public abstract class Command {
	public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws GuibotException;

	public abstract boolean isExit();
}
