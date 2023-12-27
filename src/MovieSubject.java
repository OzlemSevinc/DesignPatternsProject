public interface MovieSubject {
    void addObserver(MovieObserver observer);
    void removeObserver(MovieObserver observer);
    Boolean notifyObservers();
}
