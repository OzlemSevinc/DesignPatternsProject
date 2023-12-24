public class Eskisehir extends Ticket {
    String description;
    double cost;


    public Eskisehir(String location, double cost){
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
