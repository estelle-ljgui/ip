package guibot.command;

import guibot.Storage;
import guibot.TaskList;
import guibot.Ui;
import guibot.task.Task;

/**
 * Command to add a task to the list
 */
public class AddCommand extends Command {
	private Task task;

	/**
	 * Initialises an AddCommand object
	 *
	 * @param task Task to be added
	 */
	public AddCommand(Task task) {
		this.task = task;
	}

	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage) {
		tasks.add(this.task);
		storage.saveTasks(tasks);
		ui.showString(String.format("Got it, I've added this task:\n\t    %s\n\t  Now you have %d tasks in the list.",
							this.task.toString(), tasks.size()));
	}

	@Override
	public boolean isExit() {
		return false;
	}
}
