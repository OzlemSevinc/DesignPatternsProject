import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConcreteMovieSubject implements MovieSubject {
    public List<MovieObserver> observers = new ArrayList<>();
    private Boolean value = false;


    public ConcreteMovieSubject(Boolean value) {
        this.value = value;


    }

    @Override
    public void addObserver(MovieObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(MovieObserver observer) {
        observers.remove(observer);
    }

    @Override
    public Boolean notifyObservers(ArrayList<String> locCom, ArrayList<Ticket> ticketCosts, ArrayList<String> time, ArrayList<String> companysMovieNames, int number, String city, ConcreteMovieSubject movie, String fileName, ArrayList<String> companysMovieNames_menu, ArrayList<String> time_menu) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int satirSayisi = 0;

            while (reader.readLine() != null) {
                satirSayisi++;
            }

            reader.close();
          //  List<MovieObserver> observersCopy = new ArrayList<>(observers);
            if (satirSayisi != locCom.size()){
                System.out.println("New movie added.");
                locCom.clear();
                time_menu.clear();
                companysMovieNames_menu.clear();
                time_menu.clear();
                companysMovieNames.clear();
                time.clear();
               // for (MovieObserver observer : observersCopy) {
                    this.observers.get(0).update( locCom, ticketCosts,  time_menu,  companysMovieNames,  number, city,  movie,  fileName,companysMovieNames_menu,time_menu);
               // }
                return true;

            }
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası: " + e.getMessage());
        }




        return false;
    }



}
