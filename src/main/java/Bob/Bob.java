package Bob;

/*
This is the Main class for the Bob.Bob chatbot

 */

public class Bob {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /* Constructor class */
    public Bob(String filePath){
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList();
        storage.load(tasks.getTasks());
    }

    /* run method to keep the chatbot alive */
    public void run(){
        ui.showWelcome();
        boolean isRunning = true;

        while (isRunning){
            String input = ui.readCommand();

            if (input.toLowerCase().equals("bye")){
                ui.showGoodbye();
                isRunning = false;
            }
            else {
                Parser.parse(input, tasks, ui, storage);
            }
    }
}
    /* Main method that runs the chatbot */
    public static void main(String[] args){
        new Bob("./data/bob.txt").run();
    }


}
