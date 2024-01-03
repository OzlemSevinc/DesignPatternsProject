public class CompanyB extends CompanyStore {



    @Override
    Ticket createTicket(String location, double cost, MovieSubject movie) {


            if (location.contains("Istanbul-Kadikoy CompanyB")) {
                return new IstanbulKadikoyCompanyB(location, 150, movie);

            }


        return null;

    }
}
