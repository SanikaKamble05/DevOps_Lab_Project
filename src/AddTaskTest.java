import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDate;

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
        add_var.addTask("Buy Milk", LocalDate.now());

        Assert.assertEquals(1, add_var.getTasks().size());
        Assert.assertEquals("Buy Milk", add_var.getTasks().get(0).getTitle());
        // Verify the due date is correctly stored
        Assert.assertEquals(LocalDate.now(), add_var.getTasks().get(0).getDueDate());
    }
    
    @Test
    public void addtest2() {
        // Test adding multiple tasks
        add_var.addTask("Read Book", LocalDate.now());
        add_var.addTask("Go Jogging", LocalDate.now());

        Assert.assertEquals(2, add_var.getTasks().size());
        Assert.assertEquals("Read Book", add_var.getTasks().get(0).getTitle());
        Assert.assertEquals("Go Jogging", add_var.getTasks().get(1).getTitle());
    }

    @Test
    public void addtest3() {
        // Test adding empty title (should not add)
        add_var.addTask("", LocalDate.now());
        Assert.assertEquals(0, add_var.getTasks().size());
    }
    
    @Test
    public void addtest4() {
        // Test adding null title (should not add)
        add_var.addTask(null, LocalDate.now());
        Assert.assertEquals(0, add_var.getTasks().size());
    }  
}

/*
//Code 1

public class AddTaskTest {
    
    private AddTask add_var;

    @BeforeEach
    public void setUp() {
        add_var = new AddTask();
    }

    @AfterEach
    public void tearDown() { 
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
    @DisplayName("Test behavior with duplicate tasks")
    public void testDuplicates() {
        add_var.addTask("Meeting", LocalDate.now());
        add_var.addTask("Meeting", LocalDate.now());
        
        // This confirms if your logic allows or blocks duplicates
        assertEquals(2, add_var.getTasks().size(), "Should allow duplicate tasks unless logic says otherwise");
    }
}
*/