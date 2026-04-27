import java.util.ArrayList;

public class AddTask {

    private ArrayList<Task> tasks = new ArrayList<>();
    private int idCounter = 1;

    public void addTask(String title, String dueDate) {
        addTask(title, dueDate, "MEDIUM", "General");
    }

    // Method with priority and category
    public void addTask(String title, String dueDate, String priority, String category) {

        // Validate title
        if (title == null || title.trim().isEmpty()) {
            return;
        }

        title = title.trim();

        // Validate date
        if (dueDate != null && dueDate.trim().isEmpty()) {
            dueDate = null;
        }

        // Default priority
        if (priority == null || priority.trim().isEmpty()) {
            priority = "MEDIUM";
        }

        // Default category
        if (category == null || category.trim().isEmpty()) {
            category = "General";
        }

        // Create task
        Task task = new Task(idCounter++, title, dueDate, priority, category);
        tasks.add(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}