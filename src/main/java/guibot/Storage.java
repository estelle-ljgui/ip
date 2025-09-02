package guibot;

import guibot.exception.GuibotException;
import guibot.task.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Scanner;

public class Storage {
	private Path path;

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

	public void saveTasks(TaskList taskList) {
		try {
			Files.writeString(path, taskList.toStorageString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
