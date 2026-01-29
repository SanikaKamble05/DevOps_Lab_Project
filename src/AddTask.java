import java.util.ArrayList;

public class AddTask {
    private ArrayList<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        if (task != null && !task.trim().isEmpty()) {
            tasks.add(task);
            System.out.println("Task added: " + task);
        } else {
            System.out.println("Cannot add empty task!");
        }
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public void showTasks() {
        System.out.println("Your tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public static void main(String[] args) {
        AddTask todo = new AddTask();
        java.util.Scanner sc = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task\n2. Show Tasks\n3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = sc.nextLine();
                    todo.addTask(task);
                    break;
                case 2:
                    todo.showTasks();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
