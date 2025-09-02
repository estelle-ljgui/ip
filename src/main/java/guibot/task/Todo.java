package guibot.task;

/**
 * Represents a todo task
 */
public class Todo extends Task {

	/**
	 * Initialises a Todo object
	 *
	 * @param arguments Array of strings containing the description of the task
	 */
	public Todo(String[] arguments) {
		super(arguments[0]);
	}

	@Override
	public String toStorageString() {
		return "t//" + super.toStorageString();
	}

	@Override
	public String toString() {
		return "[T]" + super.toString();
	}
}
