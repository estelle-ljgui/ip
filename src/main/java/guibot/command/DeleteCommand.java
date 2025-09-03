package guibot.command;

import guibot.exception.GuibotException;
import guibot.Storage;
import guibot.TaskList;
import guibot.Ui;

/**
 * Command to delete a task from the list
 */
public class DeleteCommand extends Command {
	private int index;

	/**
	 * Initialises a DeleteCommand object
	 *
	 * @param index Index of task to be deleted
	 */
	public DeleteCommand(int index) {
		this.index = index;
	}

	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage) throws GuibotException {
		String taskString = tasks.delete(this.index);
		storage.saveTasks(tasks);
		ui.showString(String.format("Noted. I've removed this task:\n\t    %s\n\t  Now you have %d tasks in the list.",
							taskString, tasks.size()));
	}

	@Override
	public boolean isExit() {
		return false;
	}
}
