package guibot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import guibot.exception.DataFileCorruptedException;
import guibot.exception.GuibotException;
import guibot.task.Deadline;
import guibot.task.Event;
import guibot.task.Task;
import guibot.task.Todo;

/**
 * Handles interactions with a data file.
 */
public class Storage {
    private Path filePath;

    /**
     * Creates a Storage object and the data file if it does not exist yet.
     *
     * @param filePath Path to data file.
     * @return Storage object with path set.
     */
    public Storage(String filePath) {
        this.filePath = Paths.get(filePath);
        try {
            Files.createDirectories(this.filePath.getParent());
            if (!Files.exists(this.filePath)) {
                Files.createFile(this.filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets tasks from data file and puts them into a TaskList.
     *
     * @param tasks TaskList to put tasks into.
     * @throws GuibotException If data file is corrupted.
     */
    public void getTasks(TaskList tasks) throws GuibotException {
        Scanner taskReader;
        try {
            taskReader = new Scanner(filePath);
            while (taskReader.hasNextLine()) {
                String[] taskInfo = taskReader.nextLine().split("//", 3);
                if (taskInfo.length != 3) {
                    throw new DataFileCorruptedException();
                } else {
                    Task t = switch (taskInfo[0]) {
                    case "t" -> new Todo(taskInfo[2].split("/"));
                    case "d" -> new Deadline(taskInfo[2].split("/"));
                    case "e" -> new Event(taskInfo[2].split("/"));
                    default -> throw new DataFileCorruptedException();
                    };
                    if (taskInfo[1].equals("true")) {
                        t.mark();
                    }
                    tasks.add(t);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves tasks from a TaskList into the data file.
     *
     * @param taskList TaskList to save tasks from.
     */
    public void saveTasks(TaskList taskList) {
        try {
            Files.writeString(filePath, taskList.toStorageString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
