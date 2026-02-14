package bob;

/**
 * This is the Main class for the Bob chatbot
 * Starts chatbot and manages the main run loop
 */

public class Bob {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructor class with specified file path for storage
     * @param filePath the file path where tasks will be stored
     */
    public Bob(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList();
        storage.load(tasks.getTasks());
    }

    /**
     * Run main method to keep the chatbot alive
     * Shows welcome message and continues to process until user exit
     */
    public void run() {
        ui.showWelcome();
        boolean isRunning = true;

        while (isRunning) {
            String input = ui.readCommand();

            if (input.toLowerCase().equals("bye")) {
                ui.showGoodbye();
                isRunning = false;
            }
            else {
                Parser.parse(input, tasks, ui, storage);
            }
    }
}
    /**
     *  Main method that runs the chatbot
     * @param args command line argument
     */
    public static void main(String[] args) {
        new Bob("./data/bob.txt").run();
    }


}
