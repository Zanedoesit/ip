package Bob;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {

    @Test
    public void testAddTask() {
        TaskList taskList = new TaskList();
        Task task = new ToDo("read book");
        taskList.addTask(task);
        assertEquals(1, taskList.size());
    }

    @Test
    public void testDeleteTask() {
        TaskList taskList = new TaskList();
        Task task1 = new ToDo("read book");
        Task task2 = new ToDo("return book");
        taskList.addTask(task1);
        taskList.addTask(task2);
        assertEquals(2, taskList.size());

        taskList.deleteTask(0);
        assertEquals(1, taskList.size());
    }

}