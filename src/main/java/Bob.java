import java.util.Scanner;

/*
This is the skeleton code for the BOB chatbot

 */

public class Bob {
    public static void main(String[] args) {
        String logo = " ____   ___   ____ \n"
                + "| __ ) / _ \\ | __ )\n"
                + "|  _ \\| | | ||  _ \\\n"
                + "| |_) | |_| || |_) |\n"
                + "|____/ \\___/ |____/ \n";
        /*Creates a scanner to read input from user */
        Scanner scan = new Scanner(System.in);
        System.out.println( "Hello from\n" + logo +
                            "------------------------------------\n"
                            + "Hi! I'm BOB\n"
                            + "What can I do for you today?\n\n");
        /*Gets input from user to type and press Enter */
        String input = scan.nextLine();
        /*Checks for the bye message and ensures that it is not uppercase or lowercase sensitive */
        if (input.toLowerCase().equals("bye")) {
                           System.out.println("------------------------------------\n"
                            + "Bye. See you soon!\n\n"
                            + "\n------------------------------------");
        }
        /*Else, echo the user */
        else{
            System.out.println("------------------------------------\n"
                                + input
                                + "\n------------------------------------\n");
        }
    }
}
