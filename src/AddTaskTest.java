import java.beans.Transient;
import org.junit.*;

public class AddTaskTest {
    @Test
    public void addtest1() {
        AddTask add_var = new AddTask();

        add_var.addTask("Buy Milk");
        Assert.assertEquals(1, add_var.getTasks().size());
        Assert.assertEquals("Buy Milk", add_var.getTasks().get(0).getTitle());
    }
    
    @Test
    public void addtest2() {
        AddTask add_var = new AddTask();
        add_var.addTask("Read Book");
        add_var.addTask("Go Jogging");
        Assert.assertEquals(2, add_var.getTasks().size());
        Assert.assertEquals("Read Book", add_var.getTasks().get(0).getTitle());
        Assert.assertEquals("Go Jogging", add_var.getTasks().get(1).getTitle());
    }

    @Test
    public void addtest3() {
        AddTask add_var = new AddTask();
        add_var.addTask("");
        Assert.assertEquals(0, add_var.getTasks().size());
    }
    
}
