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
    public Boolean notifyObservers() {
        if(value) {
            for (MovieObserver observer : observers) {
                observer.update();
            }
        }
        return value;
    }



}
