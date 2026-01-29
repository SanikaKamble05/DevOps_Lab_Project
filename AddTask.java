import java.util.ArrayList;
import java.util.Scanner;

public class AddTask {
    private ArrayList<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void showTasks() {
        System.out.println("Your tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i+1) + ". " + tasks.get(i));
        }
    }

    public static void main(String[] args) {
        AddTask todo = new AddTask();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a task to add:");
        String task = sc.nextLine();
        todo.addTask(task);
        todo.showTasks();
        sc.close();
    }
}

