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

        /* Create a storage arraylist */
        ArrayList<String> tasks = new ArrayList<>();

        /* Keep track of the number of items in the list */
        int listCounter = 0;

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
                for (int i = 0; i < listCounter; i ++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
                System.out.println("------------------------------------");
            }
            /* Else, increment the listCounter, add the task to the list & echo the user input */
            else {
                listCounter ++;
                tasks.add(input);
                System.out.println("------------------------------------\n"
                        + "added: " + input
                        + "\n------------------------------------\n");
            }
        }
    }
}