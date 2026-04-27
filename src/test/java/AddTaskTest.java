import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddTaskTest {

    private AddTask add_var;

    // Runs before each test case
    @BeforeEach
    void setUp() {
        add_var = new AddTask();
    }

    // Runs after each test case
    @AfterEach
    void tearDown() {
        add_var = null;
    }

    @Test
    // Test case 1: Add a single valid task
    void addtest1() {
        add_var.addTask("Buy Milk", "12/12/2024");

        // Check if one task is added
        assertEquals(1, add_var.getTasks().size());

         // Check if title is correct
        assertEquals("Buy Milk", add_var.getTasks().get(0).getTitle());

        // Check if due date is correct
        assertEquals("12/12/2024", add_var.getTasks().get(0).getDueDate());
    }

    @Test
    // Test case 2: Add multiple tasks
    void addtest2() {
        add_var.addTask("Read Book", "01/01/2025");
        add_var.addTask("Go Jogging", "02/01/2025");

        // Check total number of tasks
        assertEquals(2, add_var.getTasks().size());

        // Verify titles of both tasks
        assertEquals("Read Book", add_var.getTasks().get(0).getTitle());
        assertEquals("Go Jogging", add_var.getTasks().get(1).getTitle());
    }

    @Test
    // Test case 3: Empty title should not be added
    void addtest3() {
        add_var.addTask("", "12/12/2024");
        assertEquals(0, add_var.getTasks().size());
    }

    @Test
    // Test case 4: Null title should not be added
    void addtest4() {
        add_var.addTask(null, "12/12/2024");
        assertEquals(0, add_var.getTasks().size());
    }

    @Test
    // Test case 5: Allow null due date
    void addtest_nullDate() {
        add_var.addTask("Read Book", null);

        assertEquals(1, add_var.getTasks().size());
        assertNull(add_var.getTasks().get(0).getDueDate());
    }

    // Test case 6: Test priority and category feature
    @Test
    void addtest_priority_category() {
        add_var.addTask("Study", "15/01/2025", "HIGH", "Study");

        assertEquals("HIGH", add_var.getTasks().get(0).getPriority());
        assertEquals("Study", add_var.getTasks().get(0).getCategory());
    }
}