import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface MovieObserver {
    void update(ArrayList<String> locCom, ArrayList<Ticket> ticketCosts, ArrayList<String> time, ArrayList<String> companysMovieNames, int number, String baseFileName, ConcreteMovieSubject movie, String fileName, ArrayList<String> companysMovieNames_menu, ArrayList<String> time_menu) throws FileNotFoundException;
}