import org.junit.jupiter.api.*; // Test, BeforeEach, AfterEach, RepeatedTest
import static org.junit.jupiter.api.Assertions.*; // assertTrue, assertFalse, assertNotEquals, assertEquals
import java.time.LocalDate;

public class AddTaskTest {
    
    private AddTask add_var;

    @BeforeEach 
    public void setUp() {
        // Runs before every test to initialize the object
        add_var = new AddTask();
    }

    @AfterEach
    public void tearDown() { 
        // Runs after every test to clean up
        add_var = null;
    }

    @Test
    @DisplayName("Test adding a valid task")
    public void addtest1() {
        add_var.addTask("Buy Milk", LocalDate.now());
        assertEquals(1, add_var.getTasks().size());
        assertEquals("Buy Milk", add_var.getTasks().get(0).getTitle());
        
        // Verifying that the date was set correctly
        assertEquals(LocalDate.now(), add_var.getTasks().get(0).getDueDate());
    }

    @RepeatedTest(2) // RepeatTest
    @DisplayName("Multiple Task Addition Test")
    public void addtest2() {
        add_var.addTask("Read Book", LocalDate.now());
        add_var.addTask("Go Jogging", LocalDate.now());
        
        assertEquals(2, add_var.getTasks().size());
        // assertNotEquals
        assertNotEquals(add_var.getTasks().get(0).getTitle(), add_var.getTasks().get(1).getTitle());
    }

    @Test
    public void addtest3() {
        add_var.addTask("", LocalDate.now());
        // assertFalse => Empty String
        assertFalse(add_var.getTasks().size() > 0, "List should be empty for empty title");
        assertEquals(0, add_var.getTasks().size());
    }
    
    @Test
    public void addtest4() {
        // Null Test
        add_var.addTask(null, LocalDate.now());
        assertEquals(0, add_var.getTasks().size());
    }

    @Test
    @DisplayName("Verify handling of null values")
    public void testException() {
        // Instead of expecting a crash, we expect the list to stay empty
        // If the size is NOT 0, JUnit will raise an exception and fail the test
        add_var.addTask(null, null);
        assertEquals(0, add_var.getTasks().size(), "Should handle null without crashing");
    }

    @Test
    public void testTitleWithOnlySpaces() {
        // Testing the !title.trim().isEmpty() part of your code
        add_var.addTask("   ", LocalDate.now());
        assertEquals(0, add_var.getTasks().size(), "Should not add a task that is just spaces");
    }

    @Test
    @DisplayName("Test behavior with duplicate tasks")
    public void testDuplicates() {
        add_var.addTask("Meeting", LocalDate.now());
        add_var.addTask("Meeting", LocalDate.now());
        
        // This confirms if your logic allows or blocks duplicates
        assertEquals(2, add_var.getTasks().size(), "Should allow duplicate tasks unless logic says otherwise");
    }
}
/*
//Code 1

import java.beans.Transient;
import org.junit.*;
import java.time.LocalDate; // Added for date comparison

public class AddTaskTest {
    
    private AddTask add_var;

    @Before
    public void setUp() {
        // This initializes add_var before every single test runs
        add_var = new AddTask();
    }
    
    @Test
    public void addtest1() {
        add_var.addTask("Buy Milk", LocalDate.now());
        Assert.assertEquals(1, add_var.getTasks().size());
        Assert.assertEquals("Buy Milk", add_var.getTasks().get(0).getTitle());
        
        // Verifying that the date was set correctly
        Assert.assertEquals(LocalDate.now(), add_var.getTasks().get(0).getDueDate());
    }
    
    @Test
    public void addtest2() {
        add_var.addTask("Read Book", LocalDate.now());
        add_var.addTask("Go Jogging", LocalDate.now());
        // Multiple testcases
        Assert.assertEquals(2, add_var.getTasks().size());
        Assert.assertEquals("Read Book", add_var.getTasks().get(0).getTitle());
        Assert.assertEquals("Go Jogging", add_var.getTasks().get(1).getTitle());
    }

    @Test
    public void addtest3() {
        // Empty string test
        add_var.addTask("", LocalDate.now());
        Assert.assertEquals(0, add_var.getTasks().size());
    }
    
    @Test
    public void addtest4() {
        // Null test
        add_var.addTask(null, LocalDate.now());
        Assert.assertEquals(0, add_var.getTasks().size());
    }
}
*/