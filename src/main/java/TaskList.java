import java.util.ArrayList;

public class TaskList {
	private ArrayList<Task> tasks;

	public TaskList() {
		this.tasks = new ArrayList<>();
	}

	public void add(Task t) {
		this.tasks.add(t);
	}

	public String mark(int index) throws TaskNotFoundException {
		if (index >= 0 && index < this.tasks.size()) {
			this.tasks.get(index).mark();
			return this.tasks.get(index).toString();
		} else {
			throw new TaskNotFoundException();
		}
	}

	public String unmark(int index) throws TaskNotFoundException {
		if (index >= 0 && index < this.tasks.size()) {
			this.tasks.get(index).unmark();
			return this.tasks.get(index).toString();
		} else {
			throw new TaskNotFoundException();
		}
	}

	public String toString() {
		String s = "";

		for (int i = 0; i < this.tasks.size(); i++) {
			s += String.format("\n\t  %d.%s", i + 1, this.tasks.get(i).toString());
		}

		return s;
	}
}

	
