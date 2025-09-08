package guibot;

import guibot.command.Command;
import guibot.exception.GuibotException;

/**
 * Represents a Guibot.
 */
public class Guibot {
    private Storage storage;
    private Ui ui;
    private TaskList tasks;

    /**
     * Creates a Guibot.
     *
     * @param filePath Path to the data file.
     * @return A Guibot with its storage set to the file.
     */
    public Guibot(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList();
        try {
            storage.getTasks(tasks);
        } catch (GuibotException e) {
            ui.showError(e);
        }
    }

    /**
     * Runs the Guibot.
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
        new Guibot("../data/tasks.txt").run();
    }
}
