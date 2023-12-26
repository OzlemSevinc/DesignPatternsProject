public class ConcreteMovieObserver implements MovieObserver {
    private String userName;
    private String userCity;


    public ConcreteMovieObserver(String userName, String userCity, MovieSubject subject) {
        this.userName = userName;
        this.userCity = userCity;
        subject.addObserver(this);
    }

    @Override
    public void update(String movieName, String city) {
        if (userCity.equalsIgnoreCase(city)) {
            System.out.println("Notification for " + userName + ": New movie added - " + movieName);
        }
    }
}