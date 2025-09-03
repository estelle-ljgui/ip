package guibot.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private static final DateTimeFormatter STORAGE_DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter OUTPUT_DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("MMM d yyyy h.mma");
    private LocalDateTime deadline;

    public Deadline(String[] arguments) {
        super(arguments[0]);
        deadline = LocalDateTime.parse(arguments[1], STORAGE_DATE_TIME_FORMAT);
    }

    @Override
    public String toStorageString() {
        return "d//" + super.toStorageString() + "/" + deadline.format(STORAGE_DATE_TIME_FORMAT);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadline.format(OUTPUT_DATE_TIME_FORMAT) + ")";
    }
}
