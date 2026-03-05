package test.java;
import org.junit.jupiter.api.*;

import main.java.AddTask;

import static org.junit.jupiter.api.Assertions.*;

public class AddTaskTest {

    private AddTask add_var;

    @BeforeEach
    void setUp() {
        // Initialize object before each test
        add_var = new AddTask();
    }

    @AfterEach
    void tearDown() {
        // Clear object after each test
        add_var = null;
    }

    @Test
    void addtest1() {
        // Test adding one valid task
        add_var.addTask("Buy Milk", "12/12/2024");

        assertEquals(1, add_var.getTasks().size());
        assertEquals("Buy Milk", add_var.getTasks().get(0).getTitle());
        // Verify the due date is correctly stored as string
        assertEquals("12/12/2024", add_var.getTasks().get(0).getDueDate());
    }

    @Test
    void addtest2() {
        // Test adding multiple tasks
        add_var.addTask("Read Book", "01/01/2025");
        add_var.addTask("Go Jogging", "02/01/2025");

        assertEquals(2, add_var.getTasks().size());
        assertEquals("Read Book", add_var.getTasks().get(0).getTitle());
        assertEquals("Go Jogging", add_var.getTasks().get(1).getTitle());
        assertEquals("01/01/2025", add_var.getTasks().get(0).getDueDate());
        assertEquals("02/01/2025", add_var.getTasks().get(1).getDueDate());
    }

    @Test
    void addtest3() {
        // Test adding empty title (should not add)
        add_var.addTask("", "12/12/2024");
        assertEquals(0, add_var.getTasks().size());
    }

    @Test
    void addtest4() {
        // Test adding null title (should not add)
        add_var.addTask(null, "12/12/2024");
        assertEquals(0, add_var.getTasks().size());
    }

    @Test
    void addtest_nullDate() {
        // Test adding a task with null due date
        add_var.addTask("Read Book", null);

        assertEquals(1, add_var.getTasks().size());
        assertNull(add_var.getTasks().get(0).getDueDate());
    }
}