import java.util.ArrayList;

public class ViewTasks {

    public static void viewTasks(ArrayList<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n=== Tasks List ===");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i));
        }
        System.out.println();
    }
}
