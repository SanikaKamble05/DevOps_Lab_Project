public class AddTaskTest {

    public static void main(String[] args) {

        // Use AddTask class (not AddTaskModule)
        AddTask addTaskModule = new AddTask();

        // Test Case 1: Add tasks
        addTaskModule.addTask("Learn Java");
        addTaskModule.addTask("Complete DevOps project");

        // Display tasks after adding two tasks
        System.out.println("\nTasks after adding two tasks:");
        for (Task t : addTaskModule.getTasks()) {
            System.out.println(t);
        }

        // Test Case 2: Add empty task
        addTaskModule.addTask(""); // should print error

        // Test Case 3: Add another task
        addTaskModule.addTask("Prepare for interviews");

        // Display tasks after adding another task
        System.out.println("\nTasks after adding another task:");
        for (Task t : addTaskModule.getTasks()) {
            System.out.println(t);
        }
    }
}
