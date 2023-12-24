public abstract class CompanyStore {

    public Ticket orderTicket(String location, double cost){
        Ticket desiredTicket;
        desiredTicket = createTicket(location,cost);

        return desiredTicket;
    }

    abstract Ticket createTicket(String location, double cost);
}
