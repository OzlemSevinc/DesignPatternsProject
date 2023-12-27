public class Candy extends SnacksAndBeveragesDecorator{

    Ticket ticket;
    double cost;

    public Candy(Ticket ticket,double cost){
        this.ticket = ticket;
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return ticket.getDescription()+" Candy,";
    }

    @Override
    public double cost() {
        return cost+ ticket.cost();
    }
}
