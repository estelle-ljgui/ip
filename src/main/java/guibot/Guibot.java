package guibot;

import java.io.IOException;

import guibot.exception.DataFileCorruptedException;
import guibot.exception.GuibotException;

/**
 * Represents a Guibot.
 */
public class Guibot {
    private static final String DEFAULT_FILE_PATH = "../data/tasks.txt";

    private Storage storage;
    private TaskList tasks;

    /**
     * Creates a Guibot with specified filePath.
     *
     * @param filePath Path to the data file.
     * @return A Guibot with its storage set to the file.
     */
    public Guibot(String filePath) throws DataFileCorruptedException, IOException {
        storage = new Storage(filePath);
        tasks = storage.getTasks();
    }

    /**
     * Creates a Guibot with default filePath. To be used for GUI
     *
     * @return A Guibot with its storage set to the file in the default location.
     */
    public Guibot() throws DataFileCorruptedException, IOException {
        storage = new Storage(DEFAULT_FILE_PATH);
        tasks = storage.getTasks();
    }

    /**
     * Gets the Guibot's response to an input string.
     *
     * @param input The input string.
     * @return A string response
     */
    public String getResponse(String input) {
        try {
            return Parser.parse(input).execute(tasks, storage);
        } catch (GuibotException e) {
            return e.getMessage();
        }
    }
}
