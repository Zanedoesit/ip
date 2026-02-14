package bob;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TaskTest {

    @Test
    public void testMarkAsDone() {
        Task task = new Task("test task");
        assertFalse(task.isDone);
        task.markAsDone();
        assertTrue(task.isDone);
    }

    @Test
    public void testGetStatusIcon() {
        Task task = new Task("test task");
        assertEquals("[]", task.getStatusIcon());
        task.markAsDone();
        assertEquals("[X]", task.getStatusIcon());
    }
}