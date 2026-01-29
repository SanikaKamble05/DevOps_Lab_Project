import java.util.Scanner;

public class AddTaskTest {

    public static void main(String[] args) {

        AddTask addTaskModule = new AddTask();
        Scanner sc = new Scanner(System.in);

        // Test Case 1: Add a normal task
        addTaskModule.addTask("Learn Java");
        addTaskModule.addTask("Complete DevOps project");

        System.out.println("\nTasks after adding two tasks:");
        addTaskModule.showTasks();

        // Test Case 2: Add empty task
        addTaskModule.addTask(""); // should print error

        // Test Case 3: Add another task
        addTaskModule.addTask("Prepare for interviews");

        System.out.println("\nTasks after adding another task:");
        addTaskModule.showTasks();

        sc.close();
    }
}
