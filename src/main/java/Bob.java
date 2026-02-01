import java.util.Scanner;
import java.util.ArrayList;
/*
This is the skeleton code for the BOB chatbot

 */

public class Bob {
    public static void main(String[] args) {
        /* Status for loop to be used to keep the chat alive */
        boolean status = true;
        String logo = " ____   ___   ____ \n"
                + "|  ) / _ \\ |  )\n"
                + "|  _ \\| | |   _ \\\n"
                + "| |_) | |_|  |_) |\n"
                + "|____/ \\___/ |____/ \n";

        /* Create a task arraylist to store objects */
        ArrayList<Task> tasks = new ArrayList<>();

        /* Creates a scanner to read input from user */
        Scanner scan = new Scanner(System.in);
        /* Greeting message */
        System.out.println("Hello from\n" + logo +
                "------------------------------------\n"
                + "Hi! I'm BOB\n"
                + "What can I do for you today?\n\n");
        /* Loop to keep chat alive until bye is entered */
        while (status) {
            /* Gets input from user */
            String input = scan.nextLine();

            /*Check if bye is typed regardless of Capslock and exit */
            if (input.toLowerCase().equals("bye")) {
                System.out.println("------------------------------------\n"
                        + "Bye. See you soon!\n\n"
                        + "\n------------------------------------");
                status = false;
            }

            /* Prints list of task if user asks for it */
            else if(input.toLowerCase().equals("list")){
                System.out.println("------------------------------------");
                for (int i = 0; i < tasks.size(); i ++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
                System.out.println("------------------------------------");
            }

            /* Check if user types in mark and gets the number of the marked task */
            else if (input.toLowerCase().startsWith("mark ")) {
                int taskNumber = Integer.parseInt(input.substring(5)) - 1;
                tasks.get(taskNumber).markAsDone();
                System.out.println("------------------------------------\n"
                        + "Nice! I've marked this task as done:\n"
                        + tasks.get(taskNumber)
                        + "\n------------------------------------\n");
            }

            /* Else unmark and gets number of unmakred task */
            else if(input.toLowerCase().startsWith("unmark ")) {
                int taskNumber = Integer.parseInt(input.substring(7)) - 1;
                tasks.get(taskNumber).markAsNotDone();
                System.out.println("------------------------------------\n"
                        + "Ok, I've marked this task as not done yet:\n"
                        + tasks.get(taskNumber)
                        + "\n------------------------------------\n");
            }

            else if (input.toLowerCase().startsWith("todo ")) {
                String taskDescription = input.substring(5);
                tasks.add(new ToDo(taskDescription));
                System.out.println("------------------------------------\n"
                        + "Got it. I've added this task:\n"
                        + tasks.get(tasks.size()-1).toString() + "\n"
                        + "Now you have " + Integer.toString(tasks.size()) + " tasks in the list.\n"
                        + "------------------------------------\n");

            } else if (input.toLowerCase().startsWith("deadline ")) {
                String[] parts = input.substring(9).split(" /by ");
                        if (parts.length == 2){
                            String taskDescription = parts[0];
                            String date = parts[1];
                            tasks.add(new Deadline(taskDescription, date));
                            System.out.println("------------------------------------\n"
                                + "Got it. I've added this task:\n"
                                +  tasks.get(tasks.size()-1).toString() + "\n"
                                + "Now you have " + Integer.toString(tasks.size()) + " tasks in the list.\n"
                                + "------------------------------------\n");
                        }
            } else if (input.toLowerCase().startsWith("event ")) {
                String[] parts = input.substring(6).split(" /from | /to ");
                if (parts.length == 3){
                    String taskDescription = parts[0];
                    String start = parts[1];
                    String end = parts[2];
                    tasks.add(new Event (taskDescription, start , end));
                    System.out.println("------------------------------------\n"
                            + "Got it. I've added this task:\n"
                            + tasks.get(tasks.size()-1).toString() + "\n"
                            + "Now you have " + Integer.toString(tasks.size()) + " tasks in the list.\n"
                            + "------------------------------------\n");
                }

            }

            /* Else, add the task and print out what was added */
            else {
                tasks.add(new Task(input));
                System.out.println("------------------------------------\n"
                        + "added: " + tasks.get(tasks.size()-1).toString()
                        + "\n------------------------------------\n");
            }
        }
    }
}