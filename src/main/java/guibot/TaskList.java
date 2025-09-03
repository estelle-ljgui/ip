package guibot;

import java.util.ArrayList;

import guibot.exception.TaskNotFoundException;
import guibot.task.Task;

/**
 * Represents a list of tasks.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Creates an empty TaskList.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Adds a task into the list.
     *
     * @param t Task to be added.
     */
    public void add(Task t) {
        tasks.add(t);
    }

    /**
     * Marks a task as done.
     *
     * @param index Index of task to be marked as done.
     * @throws TaskNotFoundException If index does not correspond to a task on the list.
     */
    public String mark(int index) throws TaskNotFoundException {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).mark();
            return tasks.get(index).toString();
        } else {
            throw new TaskNotFoundException();
        }
    }

    /**
     * Marks a task as not done.
     *
     * @param index Index of task to be marked as not done.
     * @throws TaskNotFoundException If index does not correspond to a task on the list.
     */
    public String unmark(int index) throws TaskNotFoundException {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).unmark();
            return tasks.get(index).toString();
        } else {
            throw new TaskNotFoundException();
        }
    }

    /**
     * Deletes a task.
     *
     * @param index Index of task to be deleted.
     * @throws TaskNotFoundException If index does not correspond to a task on the list.
     */
    public String delete(int index) throws TaskNotFoundException {
        if (index >= 0 && index < tasks.size()) {
            return tasks.remove(index).toString();
        } else {
            throw new TaskNotFoundException();
        }
    }

    /**
     * Returns the number of tasks in the list.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Returns a string formatted for storing in a data file.
     */
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
