import java.util.ArrayList;

public class TodoTest {

    public static void main(String[] args) {

        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(new Task(1, "Learn Java"));
        tasks.add(new Task(2, "Complete DevOps project"));

        System.out.println("Tasks before deletion:");
        printTasks(tasks);

        // Test Case 1: Delete existing task
        TodoList.deleteTask(tasks, 1);

        System.out.println("\nTasks after deleting task with ID 1:");
        printTasks(tasks);

        // Test Case 2: Delete non-existing task
        TodoList.deleteTask(tasks, 99);
    }

    public static void printTasks(ArrayList<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task.getId() + " - " + task.getTitle());
        }
    }
}
