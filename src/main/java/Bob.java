import java.util.Scanner;
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

            if (input.toLowerCase().equals("bye")) {
                System.out.println("------------------------------------\n"
                        + "Bye. See you soon!\n\n"
                        + "\n------------------------------------");
                status = false;
            }
            /* Else, echo the user input */
            else {
                System.out.println("------------------------------------\n"
                        + input
                        + "\n------------------------------------\n");
            }
        }
    }
}