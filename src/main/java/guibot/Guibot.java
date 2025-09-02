package guibot;

import guibot.exception.GuibotException;
import guibot.command.Command;

/**
 * Represents a Guibot
 */
public class Guibot {

	private Storage storage;
	private Ui ui;
	private TaskList tasks;
	
	/**
	 * Initialises a Guibot
	 *
	 * @param directoryPath Path to the directory of the data file
	 * @param fileName Name of the data file
	 */
	public Guibot(String directoryPath, String fileName) {
		this.ui = new Ui();
		this.storage = new Storage(directoryPath, fileName);
		this.tasks = new TaskList();
		try {
			this.storage.getTasks(this.tasks);
		} catch (GuibotException e) {
			ui.showError(e);
		}
	}

	/**
	 * Runs the Guibot
	 */
	public void run() {
		ui.showWelcome();
		boolean isExit = false;
		while (!isExit) {
			try {
				String input = ui.readInput();
				ui.showLine();
				Command c = Parser.parse(input);
				c.execute(tasks, ui, storage);
				isExit = c.isExit();
			} catch (GuibotException e) {
				ui.showError(e);
			} finally {
				ui.showLine();
			}
		}
	}

	public static void main(String[] args) {
		new Guibot("../data/", "tasks.txt").run();
	}

}
