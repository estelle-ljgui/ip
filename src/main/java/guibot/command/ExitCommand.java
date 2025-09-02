package guibot.command;

import guibot.Storage;
import guibot.TaskList;
import guibot.Ui;

/**
 * Command to exit the chatbot
 */
public class ExitCommand extends Command {
	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage) {
		ui.showString("Bye. Hope to see you again soon!");
	}

	@Override
	public boolean isExit() {
		return true;
	}
}
