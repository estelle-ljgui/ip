public class Deadline extends Task {
	private String deadline;

	public Deadline(String[] arguments) {
		super(arguments[0]);
		this.deadline = arguments[1];
	}

	@Override
	public String toString() {
		return "[D]" + super.toString() + " (by: " + this.deadline + ")";
	}
}
