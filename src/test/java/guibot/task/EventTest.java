import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import guibot.task.Event;

public class EventTest {
    @Test
    public void testStorageStringConversion() {
        Event e = new Event(new String[]{"hello", "2025-09-01 0000", "2025-09-01 2359"});
        assertEquals("e//false//hello/2025-09-01 0000/2025-09-01 2359", e.toStorageString());

        e.mark();
        assertEquals("e//true//hello/2025-09-01 0000/2025-09-01 2359", e.toStorageString());
    }

    @Test
    public void testStringConversion() {
        Event e = new Event(new String[]{"hello", "2025-09-01 0000", "2025-09-01 2359"});
        assertEquals("[E][ ] hello (from: Sep 1 2025 12.00am to: Sep 1 2025 11.59pm)", e.toString());

        e.mark();
        assertEquals("[E][X] hello (from: Sep 1 2025 12.00am to: Sep 1 2025 11.59pm)", e.toString());
    }
}
