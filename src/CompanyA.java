public class CompanyA extends  CompanyStore{
    @Override
    Ticket createTicket(String city,double cost) {

        if(city.contains("Istanbul")){
            return new Istanbul(city,150 + cost);
        }
        else if(city.contains("Eskisehir")){
            return new Eskisehir(city,100 + cost);
        }
        else if (city.contains("Antalya")){
            return new Antalya(city,200 + cost);
        }
        else {
            return null;
        }
    }
}
