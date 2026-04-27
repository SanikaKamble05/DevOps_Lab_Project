public class Task {

    private int id;
    private String title;
    private String dueDate;
    private String priority;   // NEW
    private String category;   // NEW

    // Constructor
    public Task(int id, String title, String dueDate, String priority, String category) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return id + ". " + title +
               " (Due: " + dueDate +
               ", Priority: " + priority +
               ", Category: " + category + ")";
    }
}