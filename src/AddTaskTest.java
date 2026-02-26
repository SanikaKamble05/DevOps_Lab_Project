import org.junit.*;
import static org.junit.Assert.*;

public class AddTaskTest {
    
    private AddTask add_var;

    @Before
    public void setUp() {
        // Initialize object before each test
        add_var = new AddTask();
    }

    @After
    public void tearDown() { 
        // Clear object after each test
        add_var = null;
    }

    @Test
    public void addtest1() {
        // Test adding one valid task
        add_var.addTask("Buy Milk", "12/12/2024");

        Assert.assertEquals(1, add_var.getTasks().size());
        Assert.assertEquals("Buy Milk", add_var.getTasks().get(0).getTitle());
        // Verify the due date is correctly stored as string
        Assert.assertEquals("12/12/2024", add_var.getTasks().get(0).getDueDate());
    }
    
    @Test
    public void addtest2() {
        // Test adding multiple tasks
        add_var.addTask("Read Book", "01/01/2025");
        add_var.addTask("Go Jogging", "02/01/2025");

        Assert.assertEquals(2, add_var.getTasks().size());
        Assert.assertEquals("Read Book", add_var.getTasks().get(0).getTitle());
        Assert.assertEquals("Go Jogging", add_var.getTasks().get(1).getTitle());
        Assert.assertEquals("01/01/2025", add_var.getTasks().get(0).getDueDate());
        Assert.assertEquals("02/01/2025", add_var.getTasks().get(1).getDueDate());
    }

    @Test
    public void addtest3() {
        // Test adding empty title (should not add)
        add_var.addTask("", "12/12/2024");
        Assert.assertEquals(0, add_var.getTasks().size());
    }
    
    @Test
    public void addtest4() {
        // Test adding null title (should not add)
        add_var.addTask(null, "12/12/2024");
        Assert.assertEquals(0, add_var.getTasks().size());
    }  

    @Test
    public void addtest_nullDate() {
        // Test adding a task with null due date
        add_var.addTask("Read Book", null);
        Assert.assertEquals(1, add_var.getTasks().size());
        Assert.assertNull(add_var.getTasks().get(0).getDueDate());
    }
}