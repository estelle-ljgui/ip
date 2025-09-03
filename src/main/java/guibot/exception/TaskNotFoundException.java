package guibot.exception;

public class TaskNotFoundException extends GuibotException {
    public TaskNotFoundException() {
        super("The index specified does not correspond to a task in the list. Please try again.");
    }
}
