import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TodoList - Delete Task Tests")
public class TodoListTest {

    private ArrayList<Task> tasks;

    @BeforeEach
    public void setUp() {
        tasks = new ArrayList<>();
        tasks.add(new Task(1, "Learn Java"));
        tasks.add(new Task(2, "Complete DevOps project"));
        tasks.add(new Task(3, "Write JUnit tests"));
    }

    // ─── Core delete logic ────────────────────────────────────────────────────

    @Test
    @DisplayName("Should delete task by valid ID and reduce list size")
    public void testDeleteTask_reducesListSize() {
        TodoList.deleteTask(tasks, 1);
        assertEquals(2, tasks.size());
    }

    @Test
    @DisplayName("Should remove the correct task when deleting by ID")
    public void testDeleteTask_removesCorrectTask() {
        TodoList.deleteTask(tasks, 1);
        assertEquals(2, tasks.get(0).getId());
        assertEquals(3, tasks.get(1).getId());
    }

    @Test
    @DisplayName("Should return true when task is found and deleted")
    public void testDeleteTask_returnsTrueOnSuccess() {
        boolean result = TodoList.deleteTask(tasks, 2);
        assertTrue(result);
    }

    @Test
    @DisplayName("Should return false when task ID does not exist")
    public void testDeleteTask_returnsFalseWhenNotFound() {
        boolean result = TodoList.deleteTask(tasks, 999);
        assertFalse(result);
    }

    @Test
    @DisplayName("Should not modify list when deleting a non-existent ID")
    public void testDeleteTask_listUnchangedWhenIdNotFound() {
        int sizeBefore = tasks.size();
        TodoList.deleteTask(tasks, 999);
        assertEquals(sizeBefore, tasks.size());
    }

    @Test
    @DisplayName("Should delete last remaining task, leaving empty list")
    public void testDeleteTask_emptyListAfterDeletingLastTask() {
        TodoList.deleteTask(tasks, 1);
        TodoList.deleteTask(tasks, 2);
        TodoList.deleteTask(tasks, 3);
        assertTrue(tasks.isEmpty());
    }

    @Test
    @DisplayName("Should do nothing when deleting from an empty list")
    public void testDeleteTask_onEmptyList() {
        ArrayList<Task> emptyList = new ArrayList<>();
        boolean result = TodoList.deleteTask(emptyList, 1);
        assertFalse(result);
        assertTrue(emptyList.isEmpty());
    }

    @Test
    @DisplayName("Should delete task at the beginning of the list")
    public void testDeleteTask_firstElement() {
        TodoList.deleteTask(tasks, 1);
        assertEquals(2, tasks.get(0).getId());
    }

    @Test
    @DisplayName("Should delete task at the end of the list")
    public void testDeleteTask_lastElement() {
        TodoList.deleteTask(tasks, 3);
        assertEquals(2, tasks.size());
        assertEquals(2, tasks.get(tasks.size() - 1).getId());
    }

    @Test
    @DisplayName("Should delete task in the middle of the list")
    public void testDeleteTask_middleElement() {
        TodoList.deleteTask(tasks, 2);
        assertEquals(2, tasks.size());
        assertEquals(1, tasks.get(0).getId());
        assertEquals(3, tasks.get(1).getId());
    }
}
