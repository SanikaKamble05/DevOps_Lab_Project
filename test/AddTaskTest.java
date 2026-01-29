import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class AddTaskTest {
    private AddTask todo;

    @BeforeEach
    void setUp() {
        todo = new AddTask();
    }

    @Test
    void testAddTask() {
        todo.addTask("Finish homework");
        ArrayList<String> tasks = todo.getTasks();
        assertEquals(1, tasks.size());
        assertEquals("Finish homework", tasks.get(0));
    }

    @Test
    void testAddEmptyTask() {
        todo.addTask(""); // empty task
        ArrayList<String> tasks = todo.getTasks();
        assertEquals(0, tasks.size());
    }

    @Test
    void testMultipleTasks() {
        todo.addTask("Task 1");
        todo.addTask("Task 2");
        ArrayList<String> tasks = todo.getTasks();
        assertEquals(2, tasks.size());
        assertEquals("Task 1", tasks.get(0));
        assertEquals("Task 2", tasks.get(1));
    }
}
