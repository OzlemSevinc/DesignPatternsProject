public class IstanbulKadikoyCompanyB extends Ticket {
    String description;
    double cost;


    public IstanbulKadikoyCompanyB(String location, double cost){
        this.cost = cost;

        this.description = location+" Ticket : ";

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
