package Bob;

import java.util.ArrayList;

/* Bob.TaskList class */
public class TaskList {
    private ArrayList<Task> tasks;

    /* Constructor class */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask (Task task){
        tasks.add(task);
    }

    public Task deleteTask(int index) {
        return tasks.remove(index);
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public int size(){
        return tasks.size();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void markTask(int index){
        tasks.get(index).markAsDone();
    }

    public void unmarkTask(int index){
        tasks.get(index).markAsNotDone();
    }

}
