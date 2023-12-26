public class CompanyB extends CompanyStore {
    private ConcreteMovieSubject movieSubject;

    public CompanyB(String city) {
        this.movieSubject = new ConcreteMovieSubject(city);
    }

    @Override
    Ticket createTicket(String location, double cost) {

        if(location.contains("Istanbul-Kadiköy CompanyB")){
            return new IstanbulKadikoyCompanyB( location,150, movieSubject );

        }/*
        else if(location.contains("Eskisehir")){
            return new Eskisehir(location,100 );
        }
        else if (location.contains("Antalya")){
            return new Antalya(location,200 );
        }*/
        else {
            return null;
        }
    }
}
