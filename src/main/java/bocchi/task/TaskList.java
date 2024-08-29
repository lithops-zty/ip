package bocchi.task;

import bocchi.exception.BocchiException;
import bocchi.storage.Storage;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of tasks.
 */
public class TaskList {
    /**
     * The list of tasks.
     */
    private List<Task> tasks;

    /**
     * The bocchi.storage for saving and loading tasks.
     */
    private Storage storage;

    /**
     * The constructor.
     *
     * @param storage The bocchi.storage for saving and loading tasks.
     */
    public TaskList(Storage storage) {
        this.storage = storage;
        try {
            tasks = storage.load();
        } catch (BocchiException e) {
            tasks = new ArrayList<>();
        }
    }

    /**
     * Adds a bocchi.task to the list.
     *
     * @param task The bocchi.task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a bocchi.task from the list.
     *
     * @param index The index of the bocchi.task to be deleted.
     * @return The bocchi.task that was deleted.
     */
    public Task removeTask(int index) {
        return tasks.remove(index);
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public int size() {
        return tasks.size();
    }

    /**
     * Saves the tasks to the file.
     */
    public void saveTasks() {
        try {
            storage.save(tasks);
        } catch (BocchiException e) {

        }
    }
}
