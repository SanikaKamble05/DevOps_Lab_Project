import java.util.ArrayList;
import java.util.Scanner;

public class EditTask {

    public static void editTask(ArrayList<Task> tasks) {
        Scanner sc = new Scanner(System.in);

        if (tasks.isEmpty()) {
            System.out.println("No tasks available to edit.");
            return;
        }

        System.out.println("Current Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i));
        }

        System.out.print("Enter task number to edit: ");
        int taskNo = sc.nextInt();
        sc.nextLine(); // consume newline

        if (taskNo < 1 || taskNo > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        System.out.print("Enter updated task title: ");
        String updatedTitle = sc.nextLine();

        if (updatedTitle != null && !updatedTitle.trim().isEmpty()) {
            Task task = tasks.get(taskNo - 1);
            task = new Task(task.getId(), updatedTitle);
            tasks.set(taskNo - 1, task);
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Cannot update with empty title!");
        }
    }
}
