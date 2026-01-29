import java.util.ArrayList;

public class TodoList {

    // Delete task by ID
    public static void deleteTask(ArrayList<Task> tasks, int taskId) {
        boolean found = false;

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == taskId) {
                tasks.remove(i);
                found = true;
                System.out.println("Task deleted successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Task not found.");
        }
    }
}
