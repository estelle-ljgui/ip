package guibot.command;

import guibot.Storage;
import guibot.TaskList;
import guibot.Ui;
import guibot.exception.GuibotException;

/**
 * Represents a set of actions to be done.
 */
public abstract class Command {
    /**
     * Executes the required actions.
     *
     * @param tasks TaskList required to execute actions.
     * @param ui Ui required to execute actions.
     * @param storage Storage required to execute actions.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws GuibotException;

    /**
     * Returns true if the command is to exit the chatbot and false otherwise.
     */
    public abstract boolean isExit();
}
