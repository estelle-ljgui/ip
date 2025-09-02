package guibot.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
	private LocalDateTime from;
	private LocalDateTime to;
	private final static DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");

	public Event(String[] arguments) {
		super(arguments[0]);
		this.from = LocalDateTime.parse(arguments[1], DATE_TIME_FORMAT);
		this.to = LocalDateTime.parse(arguments[2], DATE_TIME_FORMAT);
	}

	public String toStorageString() {
		return "e//" + super.toStorageString() + "/" +
			this.from.format(DATE_TIME_FORMAT) + "/" +
			this.to.format(DATE_TIME_FORMAT);
	}

	@Override
	public String toString() {
		return "[E]" + super.toString() +
			" (from: " + this.from.format(DateTimeFormatter.ofPattern("MMM d yyyy h.mma")) +
			" to: " + this.to.format(DateTimeFormatter.ofPattern("MMM d yyyy h.mma")) + ")";
	}
}
