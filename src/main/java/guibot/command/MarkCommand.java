package guibot.command;

import guibot.exception.GuibotException;
import guibot.Storage;
import guibot.TaskList;
import guibot.Ui;

/**
 * Command to mark a task as done
 */
public class MarkCommand extends Command {
	private int index;

	/**
	 * Initialises a MarkCommand object
	 *
	 * @param index Index of task to be marked as done
	 */
	public MarkCommand(int index) {
		this.index = index;
	}

	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage) throws GuibotException {
		String taskString = tasks.mark(this.index);
		storage.saveTasks(tasks);
		ui.showString(String.format("Nice! I've marked this task as done:\n\t    %s",
							taskString, tasks.size()));
	}

	@Override
	public boolean isExit() {
		return false;
	}
}
