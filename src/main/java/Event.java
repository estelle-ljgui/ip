public class Event extends Task {
	private String from;
	private String to;

	public Event(String[] arguments) {
		super(arguments[0]);
		this.from = arguments[1];
		this.to = arguments[2];
	}

	@Override
	public String toString() {
		return "[E]" + super.toString() + " (from: " + this.from + " to: " + this.to + ")";
	}
}
