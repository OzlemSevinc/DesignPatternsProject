import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("text.txt");
        Scanner sc = new Scanner(System.in);


        String city = "";
        int number = 1;
        ArrayList<String> locCom = new ArrayList<>();

        ArrayList<String> time = new ArrayList<>();
        ArrayList<String> companysMovieNames = new ArrayList<>();
        Set<String> movieNames = new HashSet<>();
        ArrayList<Ticket> ticketCosts = new ArrayList<>();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {

            String[] arrOfStr = scanner.nextLine().split(" ");
            city = arrOfStr[0];
            locCom.add(city + " " + arrOfStr[1]);
            time.add(arrOfStr[2]);
            companysMovieNames.add(arrOfStr[3]);
            movieNames.add(arrOfStr[3]);
        }


        scanner.close();


        System.out.println("Which city do you want to choose");
        System.out.println("1 - Antalya");
        System.out.println("2 - Istanbul");
        System.out.println("3 - Eskisehir");
        System.out.println("If you want to exit please enter 0");
        int choice = sc.nextInt();
        System.out.println("Which ticket you want?");

        while (choice != 0) {
            for (int i = 0; i < locCom.size(); i++) {
                CompanyStore value = FindCompany(locCom.get(i));


                if (choice == 1) {
                    //1: Company A 2: Company B
                    if (locCom.get(i).contains("Antalya")) {
                        Ticket ticketAntalya = value.orderTicket(locCom.get(i),0);
                        ticketCosts.add(ticketAntalya);
                        number = TicketList(number, ticketAntalya, time.get(i), companysMovieNames.get(i));
                    }

                } else if (choice == 2) {
                    if (locCom.get(i).contains("Istanbul")) {
                        Ticket ticketIstanbul = value.orderTicket(locCom.get(i), 0);
                        ticketCosts.add(ticketIstanbul);
                        number = TicketList(number, ticketIstanbul, time.get(i), companysMovieNames.get(i));
                    }
                } else if (choice == 3) {
                    if (locCom.get(i).contains("Eskisehir")) {
                        Ticket ticketEskisehir = value.orderTicket(locCom.get(i), 0);
                        ticketCosts.add(ticketEskisehir);
                        number = TicketList(number, ticketEskisehir, time.get(i), companysMovieNames.get(i));
                    }
                } else if (choice == 0) {
                    break;
                }

            }


            System.out.println("Please enter your choice If you want to exit please enter 0");
            int ticketChoice = sc.nextInt();
            System.out.println("Would you like to beverage?");
            int beverageChoice = -1;
            float totalCost = 0;
            while (beverageChoice != 0) {
                System.out.println("1 - Popcorn");
                System.out.println("2 - Soda");
                System.out.println("3 - Candy");
                System.out.println("Please enter a choice? Or If you want to exit please enter 0");
                beverageChoice = sc.nextInt();
                if(beverageChoice == 0)
                    break;
                System.out.println("How many do you want? ");
                int amount = sc.nextInt();

                if (beverageChoice == 1) {
                    ticketCosts.add(ticketChoice-1,BuyingPopcorn(ticketCosts.get(ticketChoice-1), amount));


                } else if (beverageChoice == 2) {
                    ticketCosts.add(ticketChoice-1,BuyingSoda(ticketCosts.get(ticketChoice), amount));


                } else if (beverageChoice == 3) {
                    ticketCosts.add(ticketChoice-1,BuyingCandy(ticketCosts.get(ticketChoice), amount));


                } else if (beverageChoice == 0) {
                    beverageChoice = 0;
                }

            }

            System.out.println("Ticket : "+companysMovieNames.get(ticketChoice-1) + " " + ticketCosts.get(ticketChoice-1).getDescription() + " " + "cost= " + ticketCosts.get(ticketChoice-1).cost()
                    + " at: " + time.get(ticketChoice-1));

            number = 0;


            ticketCosts.clear();
        }
    }

    private static Ticket BuyingCandy(Ticket aFloat, int amount) {

        for (int i = 0; i < amount; i++) {
            aFloat = new Candy(aFloat);
        }
        return aFloat;
    }

    private static Ticket BuyingSoda(Ticket aFloat, int amount) {
        for (int i = 0; i < amount; i++) {
            aFloat = new Soda(aFloat);
        }
        return aFloat;
    }

    private static Ticket BuyingPopcorn(Ticket aFloat, int amount) {
        for (int i = 0; i < amount; i++) {
            aFloat = new Popcorn(aFloat);
        }
        return aFloat;
    }




    private static CompanyStore FindCompany(String s) {
        if (s.contains("CompanyA")){
            return new CompanyA();

        }
        else if(s.contains("CompanyB")){
            return new CompanyB();
        }
        else {
            return null;

        }
    }

    private static int TicketList(int number, Ticket ticketCity, String time, String movieName) {

        System.out.println(number + "- " + movieName + " " + ticketCity.getDescription() + " " + "cost= " + ticketCity.cost() + " at: " + time);
        number = number +1;



        return number;


    }

/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Film Gösterme Sayfası");
            frame.setSize(600, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel mainPanel = new JPanel(new BorderLayout());

            // Üst kısım: Şehir seçme combo box'ı
            JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            String[] sehirler = {"Istanbul", "Antalya", "Eskisehir"};
            JComboBox<String> sehirComboBox = new JComboBox<>(sehirler);
            topPanel.add(new JLabel("City: "));
            topPanel.add(sehirComboBox);
            mainPanel.add(topPanel, BorderLayout.NORTH);

            // Film listesi ve posterlerini göstermek için panel
            JPanel filmPanel = new JPanel(new GridLayout(0, 2, 10, 10)); // 2 sütunlu grid layout
            String[] filmListesi = {"Mucize", "AvengersInfinityWar"};
            for (String film : filmListesi) {
                JPanel filmBilgiPanel = new JPanel(new BorderLayout());

                // Film başlığı label'ı
                JLabel filmBasligiLabel = new JLabel(film);
                filmBasligiLabel.setFont(new Font("Arial", Font.BOLD, 14));
                filmBilgiPanel.add(filmBasligiLabel, BorderLayout.NORTH);

                // Film poster resmi (Projenizdeki resim yolunuza göre güncelleyin)
                ImageIcon filmPosterIcon = new ImageIcon("C:\\Users\\dell\\IdeaProjects\\DesignPatternsProject\\src\\Pictures\\" + film + ".png"); // Resim yolu, projenize göre güncellenmeli
                Image originalImage = filmPosterIcon.getImage();
                Image scaledImage = originalImage.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
                ImageIcon scaledFilmPosterIcon = new ImageIcon(scaledImage);
                JLabel filmPosterLabel = new JLabel(scaledFilmPosterIcon);
                filmBilgiPanel.add(filmPosterLabel, BorderLayout.CENTER);

                // Film bilgileri label'ı
                JLabel filmBilgiLabel = new JLabel("<html>Yönetmen: John Doe<br>Yıl: 2020<br>Tür: Aksiyon</html>");
                filmBilgiPanel.add(filmBilgiLabel, BorderLayout.SOUTH);

                filmPanel.add(filmBilgiPanel);
            }
            mainPanel.add(new JScrollPane(filmPanel), BorderLayout.CENTER);

            frame.add(mainPanel);
            frame.setVisible(true);
        });
    }

    */

}

