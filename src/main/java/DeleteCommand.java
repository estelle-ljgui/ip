class DeleteCommand extends Command {
	private int index;

	public DeleteCommand(int index) {
		this.index = index;
	}

	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage) throws GuibotException {
		String taskString = tasks.delete(this.index);
		storage.saveTasks(tasks);
		ui.showString(String.format("Noted. I've removed this task:\n\t    %s\n\t  Now you have %d tasks in the list.",
							taskString, tasks.size()));
	}

	@Override
	public boolean isExit() {
		return false;
	}
}
