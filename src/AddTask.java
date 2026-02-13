import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AddTask {
    private ArrayList<Task> tasks = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // For Interactive User
    public void addTask() {
        System.out.print("Enter task title: ");
        String title = sc.nextLine();

        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dateInput = sc.nextLine();

        try {
            LocalDate dueDate = LocalDate.parse(dateInput);
            addTask(title, dueDate); 
        } catch (Exception e) {
            System.out.println("Error: Invalid date format. Please use YYYY-MM-DD.");
        }
    }
    
    // Logic method: For JUnit Tests
    public void addTask(String title, LocalDate dueDate) {
        if (title != null && !title.trim().isEmpty()) {
            Task task = new Task(tasks.size() + 1, title, dueDate);
            tasks.add(task);
        }
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}