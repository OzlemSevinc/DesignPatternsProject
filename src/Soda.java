public class Soda extends SnacksAndBeveragesDecorator{

    Ticket ticket;
    double cost;

    public Soda(Ticket ticket,double cost){
        this.ticket = ticket;
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return ticket.getDescription()+" Soda,";
    }

    @Override
    public double cost() {
        return cost+ ticket.cost();
    }
}
