import java.beans.Transient;
import org.junit.*;
import java.time.LocalDate; // Added for date comparison

public class AddTaskTest {
    
    @Test
    public void addtest1() {
        AddTask add_var = new AddTask();

        add_var.addTask("Buy Milk", LocalDate.now());
        Assert.assertEquals(1, add_var.getTasks().size());
        Assert.assertEquals("Buy Milk", add_var.getTasks().get(0).getTitle());
        
        // Verifying that the date was set correctly
        Assert.assertEquals(LocalDate.now(), add_var.getTasks().get(0).getDueDate());
    }
    
    @Test
    public void addtest2() {
        AddTask add_var = new AddTask();
    
        add_var.addTask("Read Book", LocalDate.now());
        add_var.addTask("Go Jogging", LocalDate.now());
        
        Assert.assertEquals(2, add_var.getTasks().size());
        Assert.assertEquals("Read Book", add_var.getTasks().get(0).getTitle());
        Assert.assertEquals("Go Jogging", add_var.getTasks().get(1).getTitle());
    }

    @Test
    public void addtest3() {
        AddTask add_var = new AddTask();
        // Empty string test
        add_var.addTask("", LocalDate.now());
        Assert.assertEquals(0, add_var.getTasks().size());
    }
    
    @Test
    public void addtest4() {
        AddTask add_var = new AddTask();
        // Null test
        add_var.addTask(null, LocalDate.now());
        Assert.assertEquals(0, add_var.getTasks().size());
    }
}