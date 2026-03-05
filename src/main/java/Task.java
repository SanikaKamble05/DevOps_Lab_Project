package main.java;
public class Task {

    private int id;
    private String title;
    private String dueDate;

    // Updated constructor
    public Task(int id, String title, String dueDate) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // Getter for the date as String
    public String getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return id + ". " + title + " (Due: " + dueDate + ")";
    }
}