import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Scanner;

class Storage {
	private static final Path DIRECTORY_PATH = Paths.get("..", "data");
	private static final Path FILE_PATH = Paths.get("..", "data", "Tasks.txt"); 

	public static void setup() throws IOException {
		if (!Files.exists(DIRECTORY_PATH)) {
			Files.createDirectory(DIRECTORY_PATH);
		}
		if (!Files.exists(FILE_PATH)) {
			Files.createFile(FILE_PATH);
		}
	}

	public static TaskList getTasks() throws IOException, GuibotException {
		Scanner taskReader = new Scanner(FILE_PATH);
		TaskList taskList = new TaskList();
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
				taskList.add(t);
			}
		}
		return taskList;
	}

	public static void saveTasks(TaskList taskList) throws IOException {
		Files.writeString(FILE_PATH, taskList.toStorageString());
	}
}
