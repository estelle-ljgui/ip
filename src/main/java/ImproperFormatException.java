public class ImproperFormatException extends GuibotException {
	final static String[] taskTypes = {"ToDo", "Deadline", "Event"};
	final static String[] formats = {"todo xxx", "deadline xxx /by xxx", "event xxx /from xxx /to xxx"};

	public ImproperFormatException(int type) {
		super("It seems like you have formatted a " + taskTypes[type] + " task incorrectly.\n\t  Please use the format [" + formats[type] + "]");
	}
}
