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
        this.task = task;
    }

    @Override
    public String execute(TaskList tasks, Storage storage) {
        tasks.add(task);
        storage.saveTasks(tasks);
        return String.format(output, task.toString(), tasks.size());
    }
}
