class ListCommand extends Command {
	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage) {
		ui.showString("Here are the tasks in your list:" + tasks.toString());
	}

	@Override
	public boolean isExit() {
		return false;
	}
}
