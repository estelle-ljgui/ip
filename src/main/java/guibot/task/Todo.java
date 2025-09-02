package guibot.task;

public class Todo extends Task {
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
