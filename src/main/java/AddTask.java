package main.java;
import java.util.ArrayList;

public class AddTask {
    private ArrayList<Task> tasks = new ArrayList<>();
    
    // Logic method: For JUnit Tests
    public void addTask(String title, String dueDate) {
        if (title != null && !title.trim().isEmpty()) {
            Task task = new Task(tasks.size() + 1, title, dueDate);
            tasks.add(task);
        }
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}