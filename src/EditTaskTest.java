import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class EditTaskTest {

    ArrayList<String> tasks;
    InputStream originalIn;

    // ---------- setUp ----------
    @BeforeEach
    void setUp() {
        tasks = new ArrayList<>();
        tasks.add("Buy groceries | 2026-02-10");
        originalIn = System.in;
    }

    // ---------- tearDown ----------
    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
    }

    // ---------- Test successful update ----------
    @Test
    void testEditTask_SuccessfulUpdate() {
        String simulatedInput = "1\nFix car\n2026-03-15\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        EditTask.editTask(tasks);

        assertEquals(1, tasks.size());
        assertEquals("Fix car | 2026-03-15", tasks.get(0));
    }

    // ---------- Test keep existing values ----------
    @Test
    void testEditTask_KeepExistingValues() {
        String simulatedInput = "1\n \n \n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        EditTask.editTask(tasks);

        assertTrue(tasks.get(0).contains("Buy groceries"));
        assertTrue(tasks.get(0).contains("2026-02-10"));
        assertFalse(tasks.get(0).contains("Fix car"));
    }

    // ---------- assertNotEquals ----------
    @Test
    void testEditTask_TaskIsModified() {
        String oldTask = tasks.get(0);

        String simulatedInput = "1\nNew Task\n2026-04-01\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        EditTask.editTask(tasks);

        assertNotEquals(oldTask, tasks.get(0));
    }

    // ---------- Raise exception if test fails ----------
   @Test
void testEditTask_InvalidIndex() {
    String simulatedInput = "5\n";
    System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

    EditTask.editTask(tasks);

    // Task list stays unchanged
    assertEquals("Buy groceries | 2026-02-10", tasks.get(0));
}


    // ---------- Repeated Test ----------
    @RepeatedTest(2)
    void testEditTask_Repeated() {
        String simulatedInput = "1\nRepeat Task\n2026-05-01\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        EditTask.editTask(tasks);

        assertEquals("Repeat Task | 2026-05-01", tasks.get(0));
    }
}
