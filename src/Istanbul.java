public class Istanbul extends Ticket {
    String description;
    double cost;

    public Istanbul(String location,double cost){
        this.description = location + " Ticket : ";
        this.cost = cost;

    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double cost() {
        return cost;
    }
}
