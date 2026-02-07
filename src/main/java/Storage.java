import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

/* Storage class code that handles saving and loading tasks */
public class Storage {
    private String filePath;

    /* Constructor for storage */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void load(ArrayList<Task> tasks){
        try {
            /* Handle case where data folder and file doesn't exist
            at the start by creating it */
            File folder = new File("data");
            if (folder.exists() == false) {
                folder.mkdir();
            }

            File file = new File(filePath);
            if (file.exists() == false) {
                file.createNewFile();
                return;
            }

            /* Read the file using BufferedReader
                and handle each case with helper methods */
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("[T]")) {
                    loadToDo(tasks, line);
                } else if (line.startsWith("[D]")) {
                    loadDeadline(tasks, line);
                } else if (line.startsWith("[E]")) {
                    loadEvent(tasks, line);
                }
            }
            reader.close();
        } catch (IOException e){
            System.out.println("Error loading: " + e.getMessage());
        }
    }

    /* loadToDo helper method */
    private void loadToDo(ArrayList<Task> tasks, String line) {
        /* Check if task is done */
        boolean isDone = line.contains("[X]");
        String description = line.substring(7);

        Task task = new ToDo(description);
        if (isDone){
            task.markAsDone();
        }
        tasks.add(task);
    }

    /* loadDeadline helper */
    private void loadDeadline(ArrayList<Task> tasks, String line){
        boolean isDone = line.contains("[X]");
        int byIndex = line.indexOf(" (by: ");
        String description = line.substring(7, byIndex);
        String date = line.substring(byIndex + 6, line.length() - 1);

        Task task = new Deadline(description, date);
        if (isDone){
            task.markAsDone();
        }
        tasks.add(task);
    }

    /* loadEvent helper*/
    private void loadEvent(ArrayList<Task> tasks, String line){
        boolean isDone = line.contains("[X]");
        int fromIndex = line.indexOf(" (from: ");
        String description = line.substring(7, fromIndex);
        int toIndex = line.indexOf(" to: ");
        String start = line.substring(fromIndex + 8, toIndex);
        String end = line.substring(toIndex + 5, line.length() - 1);

        Task task = new Event(description, start, end);
        if (isDone){
            task.markAsDone();
        }
        tasks.add(task);
    }

    public void save(ArrayList<Task> tasks){
        try {
            FileWriter writer = new FileWriter(filePath);

            for (int i = 0; i < tasks.size(); i ++){
                writer.write(tasks.get(i).toString() + "\n");
            }
            writer.close();
        } catch (IOException e){
            System.out.println("Error saving: " + e.getMessage());
        }
    }
}