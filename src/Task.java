import java.time.LocalDate;

public class Task {

    private int id;
    private String title;
    private LocalDate dueDate; // Added date field

    // Updated constructor
    public Task(int id, String title, LocalDate dueDate) {
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

    // Getter for the date
    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return id + ". " + title + " (Due: " + dueDate + ")";
    }
}