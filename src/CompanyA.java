public class CompanyA extends  CompanyStore{




    @Override
    Ticket createTicket(String city,double cost, MovieSubject movie) {



        if (city.contains("Antalya-Alanya CompanyA")) {
                return new AntalyaAlanyaCompanyA(city, 150, movie);
        } else if (city.contains("Istanbul-Kadikoy CompanyA")) {
                return new IstanbulKadikoyCompanyA(city, 100, movie);
        }


       return  null;
    }
}
