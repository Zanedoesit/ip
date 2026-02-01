/* ToDo class */
public class ToDo extends Task {
    /* Call constructor from Task */
    public ToDo(String description){
        super(description);
    }

    /* Return as string representation and add "[T]" in front */
    @Override
    public String toString(){
        return "[T]" + getStatusIcon() + " " + description;
    }
}
