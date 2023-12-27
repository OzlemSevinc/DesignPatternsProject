import javax.swing.*;

public class IstanbulKadikoyCompanyB extends Ticket implements MovieObserver {
    String description;
    double cost;
    public MovieSubject movie;


    public IstanbulKadikoyCompanyB(String location, double cost, MovieSubject movie){
        this.cost = cost;
        this.movie = movie;
        movie.addObserver(this);

        this.description = location+" Ticket : ";

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
    public void update() {
        JOptionPane.showMessageDialog(null, "New movie added.", "Uyarı", JOptionPane.WARNING_MESSAGE);

    }
}
