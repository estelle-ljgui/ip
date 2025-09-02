import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import guibot.task.Todo;

public class TodoTest {

    @Test
    public void testStorageStringConversion() {
	Todo t = new Todo(new String[]{"hello"});
	assertEquals("t//false//hello", t.toStorageString());

	t.mark();
	assertEquals("t//true//hello", t.toStorageString());
    }

    @Test
    public void testStringConversion() {
	Todo t = new Todo(new String[]{"hello"});
        assertEquals("[T][ ] hello", t.toString());

	t.mark();
	assertEquals("[T][X] hello", t.toString());
    }
}
