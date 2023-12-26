public interface MovieSubject {
    void addObserver(MovieObserver observer);
    void removeObserver(MovieObserver observer);
    void notifyObservers(String movieName, String city);
}
