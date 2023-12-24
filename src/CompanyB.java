public class CompanyB extends CompanyStore {

    @Override
    Ticket createTicket(String location, double cost) {

        if(location.contains("Istanbul")){
            return new Istanbul( location,150 + cost);

        }
        else if(location.contains("Eskisehir")){
            return new Eskisehir(location,100 + cost);
        }
        else if (location.contains("Antalya")){
            return new Antalya(location,200 + cost);
        }
        else {
            return null;
        }
    }
}
