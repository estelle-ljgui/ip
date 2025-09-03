package guibot.task;

public enum TaskType {
    TODO(new String[] {}, "todo <description of task>"),
    DEADLINE(new String[] {" /by "}, "deadline <description of task> /by <deadline of task>"),
    EVENT(new String[] {" /from ", " /to "},
            "event <description of event> /from <start of event> /to <end of event>");

    private final String[] splitters;
    private final String expectedInputFormat;

    private TaskType(String [] splitters, String expectedInputFormat) {
        this.splitters = splitters;
        this.expectedInputFormat = expectedInputFormat;
    }

    public String[] getSplitters() {
        return splitters;
    }

    public String getExpectedInputFormat() {
        return expectedInputFormat;
    }
}
