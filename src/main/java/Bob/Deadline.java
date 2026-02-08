package Bob;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/* Bob.Deadline class */
public class Deadline extends Task {
    protected LocalDate date;

    /* Call description from Bob.Task but initialise date */
    public Deadline (String description, String dateString) {
        super(description);
        /* Parse date */
        this.date = LocalDate.parse(dateString);
    }

    /* Return string representation and add [D] in front */
    @Override
    public String toString() {
        String formattedDate = date.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        return "[D]" + getStatusIcon() + " " + description + " (by: " + formattedDate + ")";
    }

    /* Get deadline date */
    public LocalDate getDate(){
        return date;
    }
}
