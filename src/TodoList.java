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

    public static void deleteTask(ArrayList<Task> tasks, int taskId) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == taskId) {
                tasks.remove(i);
                return;
            }
        }
    }

    public static void printTasks(ArrayList<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task.getId() + " - " + task.getTitle());
        }
    }
}
