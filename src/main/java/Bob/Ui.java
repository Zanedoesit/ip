package Bob;

import java.util.Scanner;
import java.util.ArrayList;
/**
 * Ui class to handle interaction with user
 */
public class Ui {
    private Scanner scanner;

    /**
     *  Constructor class
     */
    public Ui(){
        this.scanner = new Scanner(System.in);
    }

    /**
     *  Welcome message with BOB logo when the program starts
     */
    public void showWelcome(){
        String logo = " ____   ___   ____\n"
                + "|  ) / _ \\ |  )\n"
                + "|  _ \\| | |   _ \\\n"
                + "| |_) | |_|  |_) |\n"
                + "|____/ \\___/ |____/\n";
        System.out.println("Hello from\n" + logo +
                "------------------------------------\n"
                + "Hi! I'm BOB\n"
                + "What can I do for you today?\n\n");
    }

    /**
     * Display goodbye message after user exits
     */
    public void showGoodbye() {
        System.out.println("------------------------------------\n"
                + "Bye. See you soon!\n\n"
                + "\n------------------------------------");
    }

    /**
     * Reads a command from the user
     * @return the command entered by the user
     */
    public String readCommand () {
        return scanner.nextLine();
    }

    /**
     * Displays message to the user
     * @param message the message to display
     */
    public void showMessage (String message){
        System.out.println("------------------------------------\n"
                + message + "\n"
                + "------------------------------------\n");
    }

    /**
     * Displays error message to the user with the specific error
     * @param error the error message to display
     */
    public void showError (String error){
        System.out.println("------------------------------------\n"
                + "Error" + error + "\n"
                + "------------------------------------\n");
    }

    /**
     * Display all tasks in the task list
     * @param tasks the ArrayList of tasks to display
     */
    public void showTaskList (ArrayList<Task> tasks){
        System.out.println("------------------------------------\n");
        for (int i = 0; i <tasks.size(); i++){
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println("------------------------------------\n");
    }

    /**
     * Display confirmation after task is added
     * @param task the task added
     * @param taskCount the total number of tasks in the list
     */
    public void showTaskAdded (Task task, int taskCount){
        System.out.println("------------------------------------\n"
                + "Got it. I've added this task: \n"
                + task + "\n"
                + "Now you have " + taskCount + " tasks in the lis.\n"
                + "------------------------------------\n");
    }

    /**
     * Display confirmation after task is deleted
     * @param task the task deleted
     * @param taskCount the total number of tasks in the list
     */
    public void showTaskDeleted (Task task, int taskCount){
        System.out.println("------------------------------------\n"
                + "Alright. I've removed this task: \n"
                + task + "\n"
                + "Now you have " + taskCount + " tasks in the lis.\n"
                + "------------------------------------\n");
    }

    /**
     * Display a confirmation message for task marked
     * @param task the task marked as done
     */
    public void showTaskMarked(Task task) {
        System.out.println("------------------------------------\n"
                + "Nice! I've marked this task as done:\n"
                + task + "\n"
                + "------------------------------------\n");
    }

    /**
     * Display a confirmation message for task unmarked
     * @param task the task marked as not done
     */
    public void showTaskUnmarked(Task task){
        System.out.println("------------------------------------\n"
                + "Ok, I've marked this task as not done yet:\n"
                + task + "\n"
                + "------------------------------------\n");
    }

}
