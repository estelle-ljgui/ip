package guibot;

import guibot.exception.GuibotException;
import guibot.task.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Handles interactions with the data file
 */
public class Storage {
	private Path path;
	
	/**
	 * Initialises a Storage object
	 *
	 * @param directoryPath Path to directory of data file
	 * @param fileName Name of data file
	 */
	public Storage(String directoryPath, String fileName) {
		this.path = Paths.get(directoryPath + fileName);
		try {
			Files.createDirectories(Paths.get(directoryPath));
			if (!Files.exists(path)) {
				Files.createFile(path);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets tasks from data file and puts them into a TaskList
	 *
	 * @param tasks TaskList to put tasks into
	 * @throws GuibotException If data file is corrupted
	 */
	public void getTasks(TaskList tasks) throws GuibotException {
		Scanner taskReader;
		try {
			taskReader = new Scanner(this.path);
			while (taskReader.hasNextLine()) {
				String[] taskInfo = taskReader.nextLine().split("//", 3);
				if (taskInfo.length != 3) {
					throw new GuibotException("Data file not formatted properly");
				} else {
					Task t;
					switch (taskInfo[0]) {
						case "t":
							t = new Todo(taskInfo[2].split("/"));
							break;
						case "d":
							t = new Deadline(taskInfo[2].split("/"));
							break;
						case "e":
							t = new Event(taskInfo[2].split("/"));
							break;
						default:
							throw new GuibotException("Data file not formatted properly");
					}	
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
	 * Saves tasks from a TaskList into the data file
	 *
	 * @param taskList TaskList to save tasks from
	 */
	public void saveTasks(TaskList taskList) {
		try {
			Files.writeString(path, taskList.toStorageString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
