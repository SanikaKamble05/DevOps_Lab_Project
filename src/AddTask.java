import java.util.ArrayList;
import java.util.Scanner;

public class AddTask {

    private ArrayList<String> tasks = new ArrayList<>();

    // Your module: Add Task
    public void addTask(String task) {
        if (task != null && !task.trim().isEmpty()) {
            tasks.add(task);
            System.out.println("Task added: " + task);
        } else {
            System.out.println("Cannot add empty task!");
        }
    }

    // For checking output
    public void showTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    // Test runner (temporary)
    public static void main(String[] args) {
        AddTask addTaskModule = new AddTask();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a task to add: ");
        String task = sc.nextLine();

        addTaskModule.addTask(task);
        addTaskModule.showTasks();

        sc.close();
    }
}
