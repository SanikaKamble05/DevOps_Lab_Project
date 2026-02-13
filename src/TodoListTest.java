import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

public class TodoListTest {

    public TodoListTest() {}

    @Test
    public void test() {
        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(new Task(1, "Learn Java"));
        tasks.add(new Task(2, "Complete DevOps project"));

        TodoList.deleteTask(tasks, 1);

        assertEquals(1, tasks.size());
        assertEquals(2, tasks.get(0).getId());
    }
}
