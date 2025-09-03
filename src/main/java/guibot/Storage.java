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

public class Storage {
    private Path path;

    public Storage(String directoryPath, String fileName) {
        path = Paths.get(directoryPath + fileName);
        try {
            Files.createDirectories(Paths.get(directoryPath));
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getTasks(TaskList tasks) throws GuibotException {
        Scanner taskReader;
        try {
            taskReader = new Scanner(path);
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

    public void saveTasks(TaskList taskList) {
        try {
            Files.writeString(path, taskList.toStorageString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
