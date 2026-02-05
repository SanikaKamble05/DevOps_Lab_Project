import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.junit.*;

public class editTaskTest { // Class name should ideally start with Uppercase

    @Test
    void testEditTask_SuccessfulUpdate() {
        // 1. Setup initial data
        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("Buy groceries | 2026-02-10");
        
        // 2. Mock User Input
        // 1: Select task, Fix car: new desc, 2026-03-15: new date
        String simulatedInput = "1\nFix car\n2026-03-15\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in); 

        // 3. Execute
        EditTask.editTask(tasks);

        // 4. Assert
        assertEquals(1, tasks.size());
        assertEquals("Fix car | 2026-03-15", tasks.get(0));
    }

    @Test
    void testEditTask_KeepExistingValues() {
        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("Study Java | 2026-02-05");

        // Mock User Input: 1, then two empty enters
        String simulatedInput = "1\n \n \n"; 
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        EditTask.editTask(tasks);

        // Assert: Should remain the same
        assertEquals("Study Java | 2026-02-05", tasks.get(0));
    }
}