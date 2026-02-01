/* Deadline class */
public class Deadline extends Task {
    protected String date;

    /*Call description from Task but initialise date */
    public Deadline (String description, String date) {
        super(description);
        this.date = date;
    }

    /* Return string representation and add [D] in front */
    @Override
    public String toString() {
        return "[D]" + getStatusIcon() + " " + description + " (by: " + date + ")";
    }

    /* Get deadline date */
    public String getDate(){
        return date;
    }
}
