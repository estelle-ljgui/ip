package guibot.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an event task.
 */
public class Event extends Task {
    private static final DateTimeFormatter STORAGE_DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter OUTPUT_DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("MMM d yyyy h.mma");
    private LocalDateTime from;
    private LocalDateTime to;

    /**
     * Creates an Event task.
     *
     * @param arguments Array of strings containing description, start and end of the task.
     */
    public Event(String[] arguments) {
        assert arguments.length > 0 : "Cannot make Event task with no description";
        super(arguments[0]);
	assert arguments.length > 1 : "Cannot make Event task with no start";
        from = LocalDateTime.parse(arguments[1], STORAGE_DATE_TIME_FORMAT);
	assert arguments.length > 2 : "Cannot make Event task with no end";
        to = LocalDateTime.parse(arguments[2], STORAGE_DATE_TIME_FORMAT);
    }

    @Override
    public String toStorageString() {
        return "e//" + super.toStorageString()
                + "/" + from.format(STORAGE_DATE_TIME_FORMAT)
                + "/" + to.format(STORAGE_DATE_TIME_FORMAT);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString()
                + " (from: " + from.format(OUTPUT_DATE_TIME_FORMAT)
                + " to: " + to.format(OUTPUT_DATE_TIME_FORMAT) + ")";
    }
}
