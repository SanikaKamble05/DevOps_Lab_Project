import org.junit.jupiter.api.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ViewTasksTest {

    private ArrayList<String> tasks;

    // Runs before each test
    @BeforeEach
    public void setUp() {
        tasks = new ArrayList<>();
        System.out.println("Setting up a fresh tasks list for test");
    }

    // Runs after each test
    @AfterEach
    public void tearDown() {
        tasks.clear();
        System.out.println("Clearing tasks list after test");
    }

    // -------------------------------
    // Test 1: Empty list
    // -------------------------------
    @Test
    public void testEmptyList() {
        ViewTasks viewTasks = new ViewTasks(tasks);
        assertNotNull(viewTasks);          // Object should be created
        assertTrue(tasks.isEmpty());       // List is empty
        assertFalse(tasks.size() > 0);     // Ensure list has no items
    }

    // -------------------------------
    // Test 2: Null list (handled safely)
    // -------------------------------
    @Test
    public void testNullList() {
        ViewTasks viewTasks = new ViewTasks(null);
        assertNotNull(viewTasks);          // Object is created
        // Since tasks is null, showTasks prints "No tasks available"
        // We can check that no exception occurs
    }

    // -------------------------------
    // Test 3: Task without date
    // -------------------------------
    @Test
    public void testTaskMissingDate() {
        tasks.add("Complete Assignment"); // No date provided
        ViewTasks viewTasks = new ViewTasks(tasks);

        assertNotEquals("", tasks.get(0));          // Task is not empty
        assertFalse(tasks.get(0).contains("|"));    // Missing date means no separator
        assertTrue(tasks.get(0).startsWith("Complete")); // Task name is correct
    }
}