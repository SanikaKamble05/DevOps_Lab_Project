import java.util.ArrayList;
import java.util.Scanner;

public class AddTask {
    private ArrayList<Task> tasks = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addTask() {
        System.out.print("Enter task title: ");
        String title = sc.nextLine();
        addTask(title);
    }

    public void addTask(String title) {
        addTask(tasks, title);
    }

    public void addTask(ArrayList<Task> taskList, String title) {
        if (title != null && !title.trim().isEmpty()) {
            // Find the maximum ID to ensure unique IDs even after deletions
            int maxId = 0;
            for (Task task : taskList) {
                if (task.getId() > maxId) {
                    maxId = task.getId();
                }
            }
            Task task = new Task(maxId + 1, title);
            taskList.add(task);
            System.out.println("Task added: " + task);
        } else {
            System.out.println("Cannot add empty task!");
        }
    }

    // Getter for tasks
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}