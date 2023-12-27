import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class IstanbulKadikoyCompanyA extends Ticket implements MovieObserver{
    String description;
    double cost;
    public MovieSubject movie;
    int counter;


    public IstanbulKadikoyCompanyA(String location,double cost,MovieSubject movie){
        this.description = location + " Ticket : ";
        this.cost = cost;
        this.movie = movie;
        movie.addObserver(this);

    }


    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double cost() {
        return cost;
    }

    @Override
    public void update(ArrayList<String> locCom, ArrayList<Ticket> ticketCosts, ArrayList<String> time, ArrayList<String> companysMovieNames, int number, String city, ConcreteMovieSubject movie, String fileName, ArrayList<String> companysMovieNames_menu, ArrayList<String> time_menu) throws FileNotFoundException {

        if(counter == 0){
            createMenu(locCom,time,companysMovieNames,fileName,companysMovieNames_menu,time_menu);

            for (int i = 0; i < locCom.size(); i++) {

                CompanyStore value = Main.FindCompany(locCom.get(i));
                if (locCom.get(i).contains(city)) {
                    Ticket ticketAntalya = value.orderTicket(locCom.get(i), 0, movie);
                    ticketCosts.add(ticketAntalya);
                    number = Main.TicketList(number, ticketAntalya, time.get(i), companysMovieNames.get(i));
                    companysMovieNames_menu.add(companysMovieNames.get(i));
                    time_menu.add(time.get(i));


                }
            }


        }
        counter++;

    }

    private void createMenu(ArrayList<String> locCom, ArrayList<String> time, ArrayList<String> companysMovieNames, String fileName, ArrayList<String> companysMovieNames_menu, ArrayList<String> time_menu) throws FileNotFoundException {

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        locCom.clear();
        time.clear();
        companysMovieNames_menu.clear();
        time_menu.clear();
        companysMovieNames.clear();
        String city = "";
        while (scanner.hasNextLine()) {
            String[] arrOfStr = scanner.nextLine().split(" ");
            city = arrOfStr[0];
            locCom.add(city + " " + arrOfStr[1]);
            time.add(arrOfStr[2]);
            companysMovieNames.add(arrOfStr[3]);

        }
        scanner.close();
    }
}
