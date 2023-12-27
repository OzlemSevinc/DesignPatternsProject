import javax.swing.*;

public class AntalyaAlanyaCompanyA extends Ticket implements MovieObserver{
    String description;
    double cost;
    public MovieSubject movie;

    public AntalyaAlanyaCompanyA(String location, double cost, MovieSubject movie){
        this.cost = cost;
        this.description = location+" Ticket : ";
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
