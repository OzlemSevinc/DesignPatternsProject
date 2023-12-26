public class CompanyA extends  CompanyStore{
    private ConcreteMovieSubject movieSubject;

    public CompanyB(String city) {
        this.movieSubject = new ConcreteMovieSubject(city);
    }
    @Override
    Ticket createTicket(String city,double cost) {

        if(city.contains("Antalya-Alanya CompanyA")){
            return new AntalyaAlanyaCompanyA(city,150,movieSubject );
        }
        else if(city.contains("Istanbul-Kadikoy CompanyA")){
            return new IstanbulKadikoyCompanyA(city,100 ,movieSubject);
        }
        /*else if (city.contains("Antalya")){
            return new Antalya(city,200 );
        }*/
        else {
            return null;
        }
    }
}
