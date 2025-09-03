package guibot.exception;

public class DataFileCorruptedException extends GuibotException {
    public DataFileCorruptedException() {
        super("Data file not formatted properly. Starting from empty task list.");
    }
}
