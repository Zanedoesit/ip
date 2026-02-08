package Bob;/* Bob.Parser class to par user input
and determines the command type */


import java.time.DateTimeException;
import java.time.LocalDate;

public class Parser {

    /* parse with helper methods */
    public static void parse(String input, TaskList tasks, Ui ui, Storage storage){
        if (input.toLowerCase().equals("list")){
            ui.showTaskList(tasks.getTasks());

        } else if (input.toLowerCase().startsWith("mark ")) {
            handleMark(input, tasks, ui, storage);

        } else if (input.toLowerCase().startsWith("unmark ")) {
            handleUnmark(input, tasks, ui, storage);

        } else if (input.toLowerCase().startsWith("todo ")) {
            handleTodo(input, tasks, ui, storage);

        } else if (input.toLowerCase().startsWith("deadline ")) {
            handleDeadline(input, tasks, ui, storage);

        } else if (input.toLowerCase().startsWith("event ")) {
            handleEvent(input, tasks, ui, storage);

        } else if (input.toLowerCase().startsWith("delete ")) {
            handleDelete(input, tasks, ui, storage);

        }else {
            Task task = new Task(input);
            tasks.addTask(task);
            storage.save(tasks.getTasks());
            ui.showMessage("added: " + task);
        }

    }

    /* handleMark helper method */
    private static void handleMark(String input, TaskList tasks, Ui ui, Storage storage) {
        try { /* replace original printing code with ui */
            int taskNumber = Integer.parseInt(input.substring(5)) - 1;
            if (taskNumber < 0 || taskNumber >= tasks.size()) {
                ui.showError("Bob.Task number is out of range please try again.");
            } else { /* mark task as done */
                tasks.getTask(taskNumber).markAsDone();
                storage.save(tasks.getTasks());
                ui.showTaskMarked(tasks.getTask(taskNumber));
            }
        } catch (NumberFormatException e) {
            /* replace print with ui method */
            ui.showError("Please enter a valid task number. ");
        }
    }

    /* handleUnmark helper method */
    private static void handleUnmark(String input, TaskList tasks, Ui ui, Storage storage){
        try {
            int taskNumber = Integer.parseInt(input.substring(7)) - 1;
            if (taskNumber < 0 || taskNumber >= tasks.size()) {
                ui.showError("Bob.Task number is out of range please try again.");
            } else { /* add unmarked task */
                tasks.getTask(taskNumber).markAsNotDone();
                storage.save(tasks.getTasks());
                ui.showTaskUnmarked(tasks.getTask(taskNumber));
            }
          /* Change print to Bob.Ui method */
        } catch (NumberFormatException e){
            ui.showError("Please enter a valid task number.");
        }
    }

    /* handleTodo helper method */
    private static void handleTodo(String input, TaskList tasks, Ui ui, Storage storage) {
        String taskDescription = input.substring(5).trim();
        if (taskDescription.isEmpty()){
            ui.showError("Please fill up the task todo.");
        }
        else{
            Task task = new ToDo(taskDescription);
            tasks.addTask(task);
            storage.save(tasks.getTasks());
            ui.showTaskAdded(task,tasks.size());
        }
    }

    /* handleDeadline helper with
     updated Bob.Ui methods */
    private static void handleDeadline(String input, TaskList tasks, Ui ui, Storage storage) {
        String[] parts = input.substring(9).split(" /by ");
        if (parts.length != 2) {
            ui.showError("Bob.Deadline format is wrong.\n"
                    + "Try: deadline <task> /by yyyy-mm-dd");
        } else {
            String taskDescription = parts[0].trim();
            String dateString = parts[1].trim();

            /* Check for empty task or date */
            if (taskDescription.isEmpty() || dateString.isEmpty()) {
                ui.showError("Bob.Task description or deadline is empty. Please fill it up.");
            } else {
                try {/* parse to check format */
                    LocalDate.parse(dateString);

                    Task task = new Deadline(taskDescription, dateString);
                    tasks.addTask(task);
                    storage.save(tasks.getTasks());
                    ui.showTaskAdded(task, tasks.size());
                } catch (DateTimeException e) {
                    ui.showError("Invalid date format! Please use yyyy-mm-dd format (e.g. 2019-10-15)");
                }
            }
        }

    }
    private static void handleEvent(String input, TaskList tasks, Ui ui, Storage storage){
        String[] parts = input.substring(6).split(" /from | /to ");
        if (parts.length != 3){
            ui.showError("Bob.Event format is wrong.\n"
            + "Try: event <task> /from yyyy-mm-dd /to yyyy-mm-dd");
        }
        else {
            String taskDescription = parts[0].trim();
            String start = parts[1].trim();
            String end = parts[2].trim();

            if(taskDescription.isEmpty() || start.isEmpty() || end.isEmpty()){
                ui.showError("Bob.Task description or start or end time should not be empty.");
            }
            else{
                try {
                    LocalDate.parse(start);
                    LocalDate.parse(end);

                    Task task = new Event(taskDescription, start, end);
                    tasks.addTask(task);
                    storage.save(tasks.getTasks());
                    ui.showTaskAdded(task, tasks.size());
                } catch (DateTimeException e) {
                    ui.showError("Invalid date/time format! Please use yyyy-mm-dd (e.g. 2019-10-15)");
                }
            }
        }
    }

    /* handleDelete helper method */
    private static void handleDelete(String input, TaskList tasks, Ui ui, Storage storage){
        try {
            int taskNumber = Integer.parseInt(input.substring(7)) - 1;
            /* Check if tasknumber out of range */
            if (taskNumber < 0 || taskNumber >= tasks.size()){
                ui.showError("Bob.Task number is out of range please try again.");
            }
            else {
                Task deletedTask = tasks.deleteTask(taskNumber);
                storage.save(tasks.getTasks());
                ui.showTaskDeleted(deletedTask, tasks.size());
            }
        } catch (NumberFormatException e){
            ui.showError("Please enter a valid task number.");
        }
    }
}

