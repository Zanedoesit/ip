import java.util.Scanner;
import java.util.ArrayList;
/*
This is the skeleton code for the BOB chatbot

 */

public class Bob {
    public static void main(String[] args) {
        /* Status for loop to be used to keep the chat alive */
        boolean status = true;
        String logo = " ____   ___   ____\n"
                + "|  ) / _ \\ |  )\n"
                + "|  _ \\| | |   _ \\\n"
                + "| |_) | |_|  |_) |\n"
                + "|____/ \\___/ |____/\n";

        /* Add storage */
        Storage storage = new Storage("data/tasks.txt");


        /* Create a task arraylist to store objects */
        ArrayList<Task> tasks = new ArrayList<>();

        /* load from file */
        storage.load(tasks);

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

                /* add save before exit */
                storage.save(tasks);

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

            /* Check if user types in mark and gets the number of the
            marked task and handle if number is out of range or invalid */
            else if (input.toLowerCase().startsWith("mark ")) {
                try {
                    int taskNumber = Integer.parseInt(input.substring(5)) - 1;
                    if (taskNumber < 0 || taskNumber >= tasks.size()) {
                        System.out.println("------------------------------------\n"
                                + "ERROR! Task number is out of range please try again. \n"
                                + "------------------------------------\n");
                    }
                    else{ /* mark task as done */
                        tasks.get(taskNumber).markAsDone();
                        storage.save(tasks);
                        System.out.println("------------------------------------\n"
                                + "Nice! I've marked this task as done:\n"
                                + tasks.get(taskNumber)
                                + "\n------------------------------------\n");
                    }
                } catch (NumberFormatException e){
                    System.out.println("------------------------------------\n"
                            + "ERROR! Please enter a valid task number. \n"
                            + "------------------------------------\n");
                }
            }

            /* Else unmark and gets number of unmakred task */
            else if (input.toLowerCase().startsWith("unmark ")) {
                try {
                    int taskNumber = Integer.parseInt(input.substring(7)) - 1;
                    if (taskNumber < 0 || taskNumber >= tasks.size()) {
                        System.out.println("------------------------------------\n"
                                + "ERROR! Task number is out of range please try again. \n"
                                + "------------------------------------\n");
                    } else { /* add unmarked task */
                        tasks.get(taskNumber).markAsNotDone();
                        storage.save(tasks);
                        System.out.println("------------------------------------\n"
                                + "Ok, I've marked this task as not done yet:\n"
                                + tasks.get(taskNumber)
                                + "\n------------------------------------\n");
                    }
                } catch (NumberFormatException e){
                    System.out.println("------------------------------------\n"
                            + "ERROR! Please enter a valid task number. \n"
                            + "------------------------------------\n");
                }
            }

            else if (input.toLowerCase().startsWith("todo")) {
                String taskDescription = input.substring(4).trim();
                /* check if task description has text behind */
                if (taskDescription.isEmpty()){
                    System.out.println("------------------------------------\n"
                            + "ERROR! Please fill up the task todo. \n"
                            + "------------------------------------\n");
                }
                else { /* If task has text add */
                    tasks.add(new ToDo(taskDescription));
                    storage.save(tasks);
                    System.out.println("------------------------------------\n"
                            + "Got it. I've added this task:\n"
                            + tasks.get(tasks.size() - 1).toString() + "\n"
                            + "Now you have " + Integer.toString(tasks.size()) + " tasks in the list.\n"
                            + "------------------------------------\n");
                }

            } else if (input.toLowerCase().startsWith("deadline ")) {
                String[] parts = input.substring(9).split(" /by ");
                /* Changed Error format message */
                if (parts.length != 2){
                    System.out.println("------------------------------------\n"
                            + "Error! Deadline format is wrong.\n"
                            + "Try: deadline <your task> by yyyy-mm-dd \n"
                            + "------------------------------------\n");
                }
                else{ /* Check if task description and deadline is filled */
                    String taskDescription = parts[0].trim();
                    String date = parts[1].trim();
                    if (taskDescription.isEmpty() || date.isEmpty()){
                        System.out.println("------------------------------------\n"
                                + "Error! Task description or deadline is empty"
                                + "Please fill it up"
                                + "------------------------------------\n");
                    }
                    else{ /* Add try catch block with error handling */
                        try{
                            tasks.add(new Deadline(taskDescription, date));
                            storage.save(tasks);
                            System.out.println("------------------------------------\n"
                                    + "Got it. I've added this task:\n"
                                    + tasks.get(tasks.size() - 1).toString() + "\n"
                                    + "Now you have " + Integer.toString(tasks.size()) + " tasks in the list.\n"
                                    + "------------------------------------\n");
                        } catch (Exception e){
                            System.out.println("------------------------------------\n"
                                    + "Error! Please use the date format yyyy-mm-dd (e.g. 2019-10-15)\n"
                                    + "------------------------------------\n");
                        }
                    }
                }
            }
            else if (input.toLowerCase().startsWith("event ")) {
                String[] parts = input.substring(6).split(" /from | /to ");
                if (parts.length != 3) {
                    /* Change date format for error message */
                    System.out.println("------------------------------------\n"
                            + "Error! Event format is wrong. \n"
                            + "Try: event <your task> /from yyyy-mm-dd /to yyyy-mm-dd \n"
                            + "------------------------------------\n");
                } else{ /* check for task description and start/end date */
                    String taskDescription = parts[0].trim();
                    String start = parts[1].trim();
                    String end = parts[2].trim();
                    if (taskDescription.isEmpty() || start.isEmpty() || end.isEmpty()){
                        System.out.println("------------------------------------\n"
                                + "Error! Task description or start or end date should not be empty. \n"
                                + "------------------------------------\n");
                    }
                    else { /* Add try and catch for format */
                        try {
                            tasks.add(new Event(taskDescription, start, end));
                            storage.save(tasks);
                            System.out.println("------------------------------------\n"
                                    + "Got it. I've added this task:\n"
                                    + tasks.get(tasks.size() - 1).toString() + "\n"
                                    + "Now you have " + Integer.toString(tasks.size()) + " tasks in the list.\n"
                                    + "------------------------------------\n");
                        } catch (Exception e) {
                            System.out.println("------------------------------------\n"
                                    + "Error! Event format is wrong. \n"
                                    + "Please use date format yyyy-mm-dd (e.g. 2019-10-15)\n"
                                    + "------------------------------------\n");
                        }
                    }
                }
            }
            /* Check for delete */
            else if (input.toLowerCase().startsWith("delete ")) {
                int taskNumber = Integer.parseInt(input.substring(7)) - 1;
                Task deletedTask = tasks.get(taskNumber);
                tasks.remove(taskNumber);
                storage.save(tasks);
                System.out.println("------------------------------------\n"
                        + "Alright. I've removed this task: \n"
                        + deletedTask + "\n"
                        + "Now you have " + tasks.size() + " tasks in the list. \n"
                        + "------------------------------------\n");
            }
            /* Else, add the task and print out what was added */
            else {
                tasks.add(new Task(input));
                storage.save(tasks);
                System.out.println("------------------------------------\n"
                        + "added: " + tasks.get(tasks.size()-1).toString()
                        + "\n------------------------------------\n");
            }
        }
    }
}