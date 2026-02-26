import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class EditTaskTest {

    ArrayList<String> tasks; 

    @BeforeEach
    void setUp() {
        tasks = new ArrayList<>();
        tasks.add("Buy groceries | 10-02-2026");  // default task
    }

    //  Successful update (task + date)
    @Test
    void testSuccessfulUpdate() {
        // Changed date format to DD-MM-YYYY to match isValidDate method
        String input = "1\nFix car\n20-03-2026\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));

        EditTask.editTask(tasks, sc);

        assertEquals("Fix car | 20-03-2026", tasks.get(0));
    }

    // Keep existing values (blank input)
    @Test
    void testKeepExistingValues() {
        String input = "1\n\n\n";  
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));

        EditTask.editTask(tasks, sc);

        assertEquals("Buy groceries | 10-02-2026", tasks.get(0));
    }

    //  Invalid index
    @Test
    void testInvalidIndex() {
        String input = "5\n"; 
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));

        EditTask.editTask(tasks, sc);

        // Should remain unchanged
        assertEquals("Buy groceries | 10-02-2026", tasks.get(0));
    }

    // Invalid date format
    @Test
    void testInvalidDateFormat() {
        // Code expects DD-MM-YYYY, so YYYY-MM-DD will trigger the "Invalid" logic
        String input = "1\nNew Task\n2026-02-10\n"; 
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));

        EditTask.editTask(tasks, sc);

        // Fixed the expected string to include the correct space before the pipe
        assertEquals("New Task | 10-02-2026", tasks.get(0));
    }

    //  Empty task list
    @Test
    void testEmptyTaskList() {
        tasks.clear();  

        String input = "1\nTask\n01-06-2026\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));

        EditTask.editTask(tasks, sc);

        assertTrue(tasks.isEmpty());
    }
}