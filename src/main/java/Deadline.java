import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
	private LocalDateTime deadline;
	private final static DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");

	public Deadline(String[] arguments) {
		super(arguments[0]);
		this.deadline = LocalDateTime.parse(arguments[1], DATE_TIME_FORMAT);
	}

	public String toStorageString() {
		return "d//" + super.toStorageString() + "/" + this.deadline.format(DATE_TIME_FORMAT);
	}

	@Override
	public String toString() {
		return "[D]" + super.toString() + " (by: " + this.deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy h.mma")) + ")";
	}
}
