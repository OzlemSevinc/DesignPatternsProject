public abstract class CompanyStore{

    public Ticket orderTicket(String location, double cost, MovieSubject movie){
        Ticket desiredTicket;
        desiredTicket = createTicket(location,cost,movie);

        return desiredTicket;
    }

    abstract Ticket createTicket(String location, double cost,  MovieSubject movie);
}
