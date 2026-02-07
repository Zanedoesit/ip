import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/* Event class */
public class Event extends Task {
    protected LocalDate start;
    protected LocalDate end;

    /* Constructor that calls description and initialises start and end */
    public Event(String description, String startString, String endString) {
        super(description);
        this.start = LocalDate.parse(startString);
        this.end = LocalDate.parse(endString);
    }

    /* Return string representation and add [E] */
    @Override
    public String toString() {
        /* add format date */
        String formattedStart = start.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        String formattedEnd = end.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        return "[E]" + getStatusIcon() + " " + description + " (from: " + formattedStart + " to: " + formattedEnd + ")";
    }

    public LocalDate getStart(){
        return start;
    }

    public LocalDate getEnd(){
        return end;
    }

}
