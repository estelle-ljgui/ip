abstract class Command {
	abstract void execute(TaskList tasks, Ui ui, Storage storage) throws GuibotException;

	abstract boolean isExit();
}
