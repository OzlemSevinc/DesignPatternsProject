import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<Ticket> ticketCosts = new ArrayList<>();
    public static ArrayList<String> companysMovieNames_menu = new ArrayList<>();
    public static ArrayList<String> time_menu = new ArrayList<>();
    public static ArrayList<String> locCom = new ArrayList<>();
    public static ArrayList<String> time = new ArrayList<>();
    public static ArrayList<String> companysMovieNames = new ArrayList<>();
    public static Set<String> movieNames = new HashSet<>();
    public static void main(String[] args) throws FileNotFoundException {
         String baseFileName = args[0];

        File file = new File(baseFileName);
        //File file = new File("text.txt");

        Scanner sc = new Scanner(System.in);
        //Users: 1 'means' Admin, 2 'means' user
        //Add 2 users as admin and normal user
        ArrayList<String> threeElementMap = new ArrayList<>();
        threeElementMap.add("1 admin");
        threeElementMap.add("2 ozl Antalya");
        threeElementMap.add("2 mlk Istanbul");


        String city = "";
        int number = 1;

        //Read data from file
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



            System.out.println("Please enter your email?");
            String email = sc.nextLine();
            String usersCity = usersCity(threeElementMap,email);

            System.out.println("Please enter your password?");
            String password = sc.nextLine();

            //User type control
            if(!usersCity.equals("Admin")){
                ConcreteMovieSubject movie = new ConcreteMovieSubject(false);

                CreatingMenu(sc,locCom,ticketCosts,time,companysMovieNames,number,usersCity,movie,
                        companysMovieNames_menu,time_menu,baseFileName);
            }
            else {

                AddingMovie(sc,baseFileName);



            }



    }
    //Method for admin to add new movie
    public static void AddingMovie(Scanner sc, String baseFileName) {
        System.out.println("Please write the new movie information.");
        String data = sc.nextLine();


        AddingLineToTextFile(baseFileName,data);
        ConcreteMovieSubject movie = new ConcreteMovieSubject(true);


        if(data.contains("Istanbul") && data.contains("CompanyA")){
            IstanbulKadikoyCompanyA d1 = new IstanbulKadikoyCompanyA("",0,movie);
        }else if (data.contains("Istanbul") && data.contains("CompanyB")){
            IstanbulKadikoyCompanyB b1 = new IstanbulKadikoyCompanyB("",0,movie);
        }
        else if (data.contains("Antalya") && data.contains("CompanyA")) {
            AntalyaAlanyaCompanyA a1 = new AntalyaAlanyaCompanyA("",0, movie);
        }
    }

    //Add new movie to text file
    public static void AddingLineToTextFile(String filePath, String data) {


        try {

            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            bufferedWriter.write(data);
            bufferedWriter.newLine();


            bufferedWriter.flush();
            bufferedWriter.close();

            System.out.println("Data added to file");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    //Checks user's city
    public static String usersCity(ArrayList<String> txt, String email) {

        for (int i = 0; i < txt.size(); i++) {
            if(txt.get(i).contains("Antalya") && txt.get(i).contains(email)){
                return "Antalya";

            } else if (txt.get(i).contains("Istanbul")&& txt.get(i).contains(email)) {
                return "Istanbul";
            }

        }

        return "Admin";
    }

    //Creates the menu for user
    public static void CreatingMenu(Scanner sc, ArrayList<String> locCom, ArrayList<Ticket> ticketCosts, ArrayList<String> time, ArrayList<String> companysMovieNames, int number, String city, ConcreteMovieSubject movie, ArrayList<String> companysMovieNames_menu, ArrayList<String> time_menu, String baseFileName) {


        while (true) {
            Boolean result = movie.notifyObservers( locCom, ticketCosts, time, companysMovieNames, number, city, movie,  baseFileName,companysMovieNames_menu,time_menu);
            if (!result) {
                System.out.println(locCom.size()+ " ");

                for (int i = 0; i < locCom.size(); i++) {

                    CompanyStore value = FindCompany(locCom.get(i));
                    if (locCom.get(i).contains(city)) {
                        Ticket ticketAntalya = value.orderTicket(locCom.get(i), 0, movie);
                        ticketCosts.add(ticketAntalya);
                        companysMovieNames_menu.add(companysMovieNames.get(i));
                        time_menu.add(time.get(i));
                        number = TicketList(number, ticketAntalya, time.get(i), companysMovieNames.get(i));



                    }
                }
            }





            System.out.println("Please enter your movie choice. If you want to exit please enter 0.");


            int ticketChoice = sc.nextInt();

            if(ticketChoice == 0){
                break;
            }
            Ticket lastTicket = ticketCosts.get(ticketChoice-1);
            System.out.println("Would you like to add snacks or beverages?");
            int beverageChoice = -1;

            while (true) {
                System.out.println("1 - Popcorn");
                System.out.println("2 - Soda");
                System.out.println("3 - Candy");
                System.out.println("Please enter your choice. If you want to exit please enter 0");
                beverageChoice = sc.nextInt();
                if (beverageChoice == 0)
                    break;
                System.out.println("How many do you want? ");
                int amount = sc.nextInt();

                if (beverageChoice == 1) {
                    lastTicket = BuyingPopcorn(lastTicket, amount);



                } else if (beverageChoice == 2) {
                    lastTicket = BuyingSoda(lastTicket, amount);



                } else if (beverageChoice == 3) {
                    lastTicket = BuyingCandy(lastTicket, amount);



                }
            }


            System.out.println("Ticket : " + companysMovieNames_menu.get(ticketChoice - 1) + " " + lastTicket.getDescription() + " " + "cost= " + lastTicket.cost()
                    + " at: " + time_menu.get(ticketChoice - 1));
            ticketCosts.clear();
            number = 1;



        }



    }
    //Methods for calculating multiple snacks or beverages
    private static Ticket BuyingCandy(Ticket ticket, int amount) {
        if(ticket.getDescription().contains("CompanyA")) {

            for (int i = 0; i < amount; i++) {
                ticket = new Candy(ticket,10);
            }
        }
        else if (ticket.getDescription().contains("CompanyB")){
            for (int i = 0; i < amount; i++) {
                ticket = new Candy(ticket,15);
            }
        }
        return ticket;
    }

    private static Ticket BuyingSoda(Ticket ticket, int amount) {
        if(ticket.getDescription().contains("CompanyA")) {

            for (int i = 0; i < amount; i++) {
                ticket = new Soda(ticket,20);
            }
        }
        else if (ticket.getDescription().contains("CompanyB")){
            ticket = new Soda(ticket,15);
        }

        return ticket;
    }

    private static Ticket BuyingPopcorn(Ticket ticket, int amount) {
        if(ticket.getDescription().contains("CompanyA")){
            for (int i = 0; i < amount; i++) {
                ticket = new Popcorn(ticket,50);
            }
        }
        else if (ticket.getDescription().contains("CompanyB")){
            for (int i = 0; i < amount; i++) {
                ticket = new Popcorn(ticket,60);
            }

        }


        return ticket;
    }




    public static CompanyStore FindCompany(String s) {
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
    //Prints ticket information
    public static int TicketList(int number, Ticket ticketCity, String time, String movieName) {

        System.out.println(number + "- " + movieName + " " + ticketCity.getDescription() + " " + "cost= " + ticketCity.cost() + " at: " + time);
        number = number +1;



        return number;


    }



}

