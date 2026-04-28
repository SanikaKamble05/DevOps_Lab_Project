import java.util.ArrayList;

public class TodoList {
    private int id;
    private String title;

    public TodoList(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    /**
     * Deletes a task from the list by its ID.
     * @param tasks  the list of tasks
     * @param taskId the ID of the task to delete
     * @return true if the task was found and deleted, false if not found
     */
    public static boolean deleteTask(ArrayList<Task> tasks, int taskId) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == taskId) {
                tasks.remove(i);
                return true;
            }
        }
        return false;
    }

    public static void printTasks(ArrayList<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
