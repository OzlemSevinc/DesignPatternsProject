import javax.security.auth.Subject;
import javax.swing.*;

public class IstanbulKadikoyCompanyA extends Ticket implements MovieObserver{
    String description;
    double cost;
    public MovieSubject movie;

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
    public void update() {
        JOptionPane.showMessageDialog(null, "New movie added.", "Uyarı", JOptionPane.WARNING_MESSAGE);

    }
}
