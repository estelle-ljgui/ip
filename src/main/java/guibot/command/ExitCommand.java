package guibot.command;

import guibot.Storage;
import guibot.TaskList;

/**
 * Command to exit the chatbot.
 */
public class ExitCommand extends Command {
    private String output = "Bye. Hope to see you again soon!";

    @Override
    public String execute(TaskList tasks, Storage storage) {
        return output;
    }
}
