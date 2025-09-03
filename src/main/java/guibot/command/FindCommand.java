package guibot.command;

import guibot.Storage;
import guibot.TaskList;
import guibot.Ui;
import guibot.task.Task;

public class FindCommand extends Command {
	private String string;

	public FindCommand(String string) {
		this.string = string;
	}

	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage) {
		TaskList tasksContainingString = tasks.find(string);
		ui.showString("Here are the matching tasks in your list:\n\t    "
				+ tasksContainingString.toString());
	}

	@Override
	public boolean isExit() {
		return false;
	}
}
