public abstract class Ticket {
    String description = " Ticket description";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
