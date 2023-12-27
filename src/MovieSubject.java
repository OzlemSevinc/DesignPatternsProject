import java.util.ArrayList;

public interface MovieSubject {
    void addObserver(MovieObserver observer);
    void removeObserver(MovieObserver observer);
    Boolean notifyObservers(ArrayList<String> locCom, ArrayList<Ticket> ticketCosts, ArrayList<String> time, ArrayList<String> companysMovieNames, int number, String city, ConcreteMovieSubject movie, String fileName, ArrayList<String> companysMovieNames_menu, ArrayList<String> time_menu);
}
