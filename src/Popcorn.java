public class Popcorn extends SnacksAndBeveragesDecorator{
    double cost;

    Ticket ticket;

    public Popcorn(Ticket ticket,double cost){
        this.ticket = ticket;
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return ticket.getDescription()+" Popcorn,";
    }

    @Override
    public double cost() {
        return cost+ ticket.cost();
    }
}
