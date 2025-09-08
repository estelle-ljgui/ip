package guibot.command;

/**
 * Represents the types of commands.
 */
public enum CommandType {
    BYE(null, "bye"),
    LIST(null, "list"),
    FIND(null, "find <string to search for>"),
    MARK(null, "mark <index of task>"),
    UNMARK(null, "unmark <index of task>"),
    DELETE(null, "delete <index of task>"),
    TODO(null, "todo <description of task>"),
    DEADLINE(new String[] {" /by "}, "deadline <description of task> /by <deadline of task>"),
    EVENT(new String[] {" /from ", " /to "},
            "event <description of event> /from <start of event> /to <end of event>");

    private final String[] splitters;
    private final String expectedInputFormat;

    private CommandType(String [] splitters, String expectedInputFormat) {
        this.splitters = splitters;
        this.expectedInputFormat = expectedInputFormat;
    }

    /**
     * Get the list of strings to split user input by.
     */
    public String[] getSplitters() {
        return splitters;
    }

    /**
     * Get the expected format of the command.
     */
    public String getExpectedInputFormat() {
        return expectedInputFormat;
    }
}
