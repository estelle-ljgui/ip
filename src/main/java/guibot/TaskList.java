package guibot;

import java.util.ArrayList;

import guibot.exception.TaskNotFoundException;
import guibot.task.Task;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void add(Task t) {
        tasks.add(t);
    }

    public String mark(int index) throws TaskNotFoundException {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).mark();
            return tasks.get(index).toString();
        } else {
            throw new TaskNotFoundException();
        }
    }

    public String unmark(int index) throws TaskNotFoundException {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).unmark();
            return tasks.get(index).toString();
        } else {
            throw new TaskNotFoundException();
        }
    }

    public String delete(int index) throws TaskNotFoundException {
        if (index >= 0 && index < tasks.size()) {
            return tasks.remove(index).toString();
        } else {
            throw new TaskNotFoundException();
        }
    }

    public int size() {
        return tasks.size();
    }

    public String toStorageString() {
        String[] s = new String[tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            s[i] = tasks.get(i).toStorageString();
        }
        return String.join("\n", s);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < tasks.size(); i++) {
            s += String.format("\n\t  %d.%s", i + 1, tasks.get(i).toString());
        }
        return s;
    }
}
