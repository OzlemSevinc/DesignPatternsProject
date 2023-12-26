import java.util.ArrayList;
import java.util.List;

public class ConcreteMovieSubject implements MovieSubject {
    private List<MovieObserver> observers = new ArrayList<>();
    private String city;


    public ConcreteMovieSubject(String city) {
        this.city = city;

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
    public void notifyObservers(String movieName, String city) {
        for (MovieObserver observer : observers) {
            observer.update(movieName, city);
        }
    }
}
