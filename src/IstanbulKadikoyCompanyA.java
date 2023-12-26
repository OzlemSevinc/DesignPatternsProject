public class IstanbulKadikoyCompanyA extends Ticket {
    String description;
    double cost;

    public IstanbulKadikoyCompanyA(String location,double cost){
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
