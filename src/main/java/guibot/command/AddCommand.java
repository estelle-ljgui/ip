package guibot.command;

import guibot.Storage;
import guibot.TaskList;
import guibot.task.Task;

/**
 * Command to add a task to the list.
 */
public class AddCommand extends Command {
    private Task task;
    private String output = "Got it, I've added this task:\n%s\nNow you have %d tasks in the list.";

    /**
     * Creates an AddCommand.
     *
     * @param task Task to be added.
     */
    public AddCommand(Task task) {
        assert task != null : "Cannot make an AddCommand with a null task";
        this.task = task;
    }

    @Override
    public String execute(TaskList tasks, Storage storage) {
        assert tasks != null : "Cannot add to a null tasklist";
        tasks.add(task);
	assert storage != null : "Cannot save to a null storage";
        storage.saveTasks(tasks);
        return String.format(output, task.toString(), tasks.size());
    }
}
