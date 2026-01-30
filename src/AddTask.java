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
        if (title != null && !title.trim().isEmpty()) {
            Task task = new Task(tasks.size() + 1, title);
            tasks.add(task);
            System.out.println("Task added: " + task);
        } else {
            System.out.println("Cannot add empty task!");
        }
    }

    public void addTask(ArrayList<Task> taskList, String title) {
        if (title != null && !title.trim().isEmpty()) {
            Task task = new Task(taskList.size() + 1, title);
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