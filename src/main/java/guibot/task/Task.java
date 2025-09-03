package guibot.task;

/**
 * Represents a task
 */
public class Task {
	private String description;
	private boolean isDone;

	/**
	 * Initialises a Task object
	 *
	 * @param description Description of the task
	 */
	public Task(String description) {
		this.description = description;
		this.isDone = false;
	}

	/**
	 * Marks the task as done
	 */
	public void mark() {
		this.isDone = true;
	}

	/**
	 * Marks the task as not done
	 */
	public void unmark() {
		this.isDone = false;
	}

	 
	/**
	 * Returns a string formatted for storage in data file
	 */
	public String toStorageString() {
		return this.isDone + "//" + this.description;
	}

	@Override
	public String toString() {
		return (this.isDone ? "[X] " : "[ ] ") + this.description;
	}
}
