import java.util.ArrayList;
import java.util.Scanner;
//helo
class EditTask {

    public static void editTask(ArrayList<String> tasks) {
        Scanner sc = new Scanner(System.in);

        if (tasks.isEmpty()) {
            System.out.println("No tasks available to edit.");
            return;
        }

        System.out.println("Current Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

        System.out.print("Enter task number to edit: ");
        int taskNo = sc.nextInt();
        sc.nextLine(); // consume newline

        if (taskNo < 1 || taskNo > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        // Split task into description and date
        String[] parts = tasks.get(taskNo - 1).split(" \\| ");
        String oldTask = parts[0];
        String oldDate = parts.length > 1 ? parts[1] : "No date";

        System.out.println("Current Task: " + oldTask);
        System.out.println("Current Date: " + oldDate);

        System.out.print("Enter updated task (leave blank to keep same): ");
        String newTask = sc.nextLine();
        if (newTask.isEmpty()) {
            newTask = oldTask;
        }

        System.out.print("Enter updated date (YYYY-MM-DD, leave blank to keep same): ");
        String newDate = sc.nextLine();
        if (newDate.isEmpty()) {
            newDate = oldDate;
        }

        tasks.set(taskNo - 1, newTask + " | " + newDate);
        System.out.println("Task and date updated successfully.");
    }
}
