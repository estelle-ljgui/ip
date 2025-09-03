import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import guibot.task.Deadline;

public class DeadlineTest {
    @Test
    public void testStorageStringConversion() {
        Deadline d = new Deadline(new String[]{"hello", "2025-09-01 2359"});
        assertEquals("d//false//hello/2025-09-01 2359", d.toStorageString());

        d.mark();
        assertEquals("d//true//hello/2025-09-01 2359", d.toStorageString());
    }

    @Test
    public void testStringConversion() {
        Deadline d = new Deadline(new String[]{"hello", "2025-09-01 2359"});
        assertEquals("[D][ ] hello (by: Sep 1 2025 11.59pm)", d.toString());

        d.mark();
        assertEquals("[D][X] hello (by: Sep 1 2025 11.59pm)", d.toString());
    }
}
