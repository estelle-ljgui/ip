package guibot;

import guibot.exception.TaskNotFoundException;
import guibot.task.Task;
import java.util.ArrayList;
import java.util.stream.Stream;

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

	public String delete(int index) throws TaskNotFoundException {
		if (index >= 0 && index < this.tasks.size()) {
			return this.tasks.remove(index).toString();
		} else {
			throw new TaskNotFoundException();
		}
	}

	public int size() {
		return this.tasks.size();
	}

	public TaskList find(String string) {
		TaskList tasksContainingString = new TaskList();
		tasks.stream()
			.filter(task -> task.toString().contains(string))
			.forEach(task -> tasksContainingString.add(task));
		return tasksContainingString;
	}

	public String toStorageString() {
		String[] s = new String[this.tasks.size()];
		for (int i = 0; i < this.tasks.size(); i++) {
			s[i] = this.tasks.get(i).toStorageString();
		}
		return String.join("\n", s);
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < this.tasks.size(); i++) {
			s += String.format("\n\t  %d.%s", i + 1, this.tasks.get(i).toString());
		}
		return s;
	}
}

	
