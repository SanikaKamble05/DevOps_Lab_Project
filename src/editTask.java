import java.util.ArrayList;
import java.util.Scanner;

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

        System.out.print("Enter updated task: ");
        String updatedTask = sc.nextLine();

        tasks.set(taskNo - 1, updatedTask);
        System.out.println("Task updated successfully.");
    }
}
