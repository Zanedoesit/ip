/* Event class */
public class Event extends Task {
    protected String start;
    protected String end;

    /* Constructor that calls description and initialises start and end */
    public Event(String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    /* Return string representation and add "E" */
    @Override
    public String toString() {
        return "[E]" + getStatusIcon() + " " + description + " (from: " + start + " to: " + end + ")";
    }

    public String getStart(){
        return start;
    }

    public String getEnd(){
        return end;
    }

}
