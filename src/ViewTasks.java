import java.util.ArrayList;

public class ViewTasks {

    private ArrayList<String> tasks;

    public ViewTasks(ArrayList<String> tasks) {
        this.tasks = tasks;
    }

    public void showTasks() {
        if (tasks == null || tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("------ Task List ------");

        for (int i = 0; i < tasks.size(); i++) {
            String taskData = tasks.get(i);

            // Split task and date
            String[] parts = taskData.split("\\|");

            String taskName = parts[0].trim();
            String taskDate = (parts.length > 1) ? parts[1].trim() : "No Date";

            System.out.println((i + 1) + ". Task: " + taskName + " | Date: " + taskDate);
        }
    }
}
