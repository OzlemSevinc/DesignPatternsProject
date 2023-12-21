public class Soda extends SnacksAndBeveragesDecorator{

    Ticket ticket;

    public Soda(Ticket ticket){
        this.ticket = ticket;
    }

    @Override
    public String getDescription() {
        return ticket.getDescription()+" Soda,";
    }

    @Override
    public double cost() {
        return 30+ ticket.cost();
    }
}
