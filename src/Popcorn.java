public class Popcorn extends SnacksAndBeveragesDecorator{

    Ticket ticket;

    public Popcorn(Ticket ticket){
        this.ticket = ticket;
    }

    @Override
    public String getDescription() {
        return ticket.getDescription()+" Popcorn,";
    }

    @Override
    public double cost() {
        return 80+ ticket.cost();
    }
}
