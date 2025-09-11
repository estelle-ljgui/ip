package guibot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import guibot.exception.DataFileCorruptedException;
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
     * Gets tasks from data file and return them in a TaskList.
     *
     * @return TaskList of tasks stored in the data file.
     * @throws DataFileCorruptedException If data file is corrupted.
     */
    public TaskList getTasks() throws IOException, DataFileCorruptedException {
        Scanner taskReader = new Scanner(filePath);
        TaskList tasks = new TaskList();
        while (taskReader.hasNextLine()) {
            tasks.add(getTaskFromString(taskReader.nextLine()));
        }
        return tasks;
    }

    private Task getTaskFromString(String string) throws DataFileCorruptedException {
        String[] taskInfo = string.split("//", 3);

        if (taskInfo.length == 3) {
            Task t = switch (taskInfo[0]) {
            case "t" -> new Todo(taskInfo[2]);
            case "d" -> new Deadline(taskInfo[2].split("/"));
            case "e" -> new Event(taskInfo[2].split("/"));
            default -> throw new DataFileCorruptedException();
            };

            if (taskInfo[1].equals("true")) {
                t.mark();
            }

            return t;

        } else {
            throw new DataFileCorruptedException();
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
