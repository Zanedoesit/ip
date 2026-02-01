/* This is the code for the Task class */
public class Task {
    protected String description;
    protected boolean isDone;

    /* Constructor */
    public Task (String description) {
        this.description = description;
        this.isDone = false;
    }
    /* Mark task as done */
    public void markAsDone() {
        this.isDone = true;
    }

    /* Mark task as not done */
    public void markAsNotDone(){
        this.isDone = false;
    }

    /* Return status icon for task,
    [X] if done, [] if not done
     */
    public String getStatusIcon() {
        if (isDone){
            return "[X]";
        }  else {
            return "[]";
        }
    }

    /* return the Icon plus task */
    @Override
    public String toString(){
        return getStatusIcon() + " " + description;
    }
}
