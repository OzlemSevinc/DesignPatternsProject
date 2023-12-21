public class Candy extends SnacksAndBeveragesDecorator{

    Ticket ticket;

    public Candy(Ticket ticket){
        this.ticket = ticket;
    }

    @Override
    public String getDescription() {
        return ticket.getDescription()+" Candy,";
    }

    @Override
    public double cost() {
        return 40+ ticket.cost();
    }
}
