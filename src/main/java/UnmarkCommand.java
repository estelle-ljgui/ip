class UnmarkCommand extends Command {
	private int index;

	public UnmarkCommand(int index) {
		this.index = index;
	}

	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage) throws GuibotException {
		String taskString = tasks.unmark(this.index);
		storage.saveTasks(tasks);
		ui.showString(String.format("OK, I've marked this task as not done yet:\n\t    %s",
							taskString, tasks.size()));
	}

	@Override
	public boolean isExit() {
		return false;
	}
}
