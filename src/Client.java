import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static AddTask addTask = new AddTask();

    public static void main(String[] args) {
        int choice;
        
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    editTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Exit the program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
        
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== TODO LIST MENU ===");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Edit Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.println("======================");
    }

    private static void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        addTask.addTask(tasks, title);
    }

    private static void viewTasks() {
        ViewTasks.viewTasks(tasks);
    }

    private static void editTask() {
        EditTask.editTask(tasks);
    }

    private static void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to delete.");
            return;
        }

        System.out.println("Current Tasks:");
        ViewTasks.viewTasks(tasks);
        
        System.out.print("Enter task number to delete: ");
        int taskNo = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        if (taskNo < 1 || taskNo > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }
        
        int taskId = tasks.get(taskNo - 1).getId();
        TodoList.deleteTask(tasks, taskId);
    }
}
