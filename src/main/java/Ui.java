import java.util.Scanner;
import java.util.ArrayList;
/* Ui class to handle interaction with user */
public class Ui {
    private Scanner scanner;

    /* Constructor class */
    public Ui(){
        this.scanner = new Scanner(System.in);
    }

    /* Welcome message */
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

    /* Display goodbye message */
    public void showGoodbye() {
        System.out.println("------------------------------------\n"
                + "Bye. See you soon!\n\n"
                + "\n------------------------------------");
    }

    public String readCommand () {
        return scanner.nextLine();
    }

    public void showMessage (String message){
        System.out.println("------------------------------------\n"
                + message + "\n"
                + "------------------------------------\n");
    }

    public void showError (String error){
        System.out.println("------------------------------------\n"
                + "Error" + error + "\n"
                + "------------------------------------\n");
    }

    public void showTaskList (ArrayList<Task> tasks){
        System.out.println("------------------------------------\n");
        for (int i = 0; i <tasks.size(); i++){
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println("------------------------------------\n");
    }

    public void showTaskAdded (Task task, int taskCount){
        System.out.println("------------------------------------\n"
                + "Got it. I've added this task: \n"
                + task + "\n"
                + "Now you have " + taskCount + " tasks in the lis.\n"
                + "------------------------------------\n");
    }

    public void showTaskDeleted (Task task, int taskCount){
        System.out.println("------------------------------------\n"
                + "Alright. I've removed this task: \n"
                + task + "\n"
                + "Now you have " + taskCount + " tasks in the lis.\n"
                + "------------------------------------\n");
    }

    public void showTaskMarked(Task task) {
        System.out.println("------------------------------------\n"
                + "Nice! I've marked this task as done:\n"
                + task + "\n"
                + "------------------------------------\n");
    }

    public void showTaskUnmarked(Task task){
        System.out.println("------------------------------------\n"
                + "Ok, I've marked this task as not done yet:\n"
                + task + "\n"
                + "------------------------------------\n");
    }

}
