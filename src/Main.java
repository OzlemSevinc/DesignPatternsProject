import java.io.*;
import java.util.*;
//import com.google.common.collect.ArrayListMultimap;
//import com.google.common.collect.Multimap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String baseFileName = args[0];
        // java Main C:\Users\dell\IdeaProjects\DesignPatternsProject\text.txt
//text.txt
        File file = new File(baseFileName);
       // File file = new File("text.txt");

        Scanner sc = new Scanner(System.in);
        //Users: 1 'means' Admin, 2 'means' user

        ArrayList<String> threeElementMap = new ArrayList<>();
        threeElementMap.add("1 asl");
        threeElementMap.add("2 ozl Antalya");

        //ArrayList<String>

        // Değer ekleme
        //threeElementMap.put(1, "2"); //asl@gmail.com
        //threeElementMap.put(2, "1 Antalya");  //ozl@gmail.com

       //javac Main.java
        //java Main



        /*

        - TODO çift terminal dene
         */
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

        System.out.println("Are you registered on the site?");
        String response = sc.nextLine();



        if(response.toUpperCase().equals("YES")) {
            //Antalya-Alanya CompanyA 10:30 Mucize
            System.out.println("Please enter your email?");
            String email = sc.nextLine();
            String usersCity = usersCity(threeElementMap,email);

            System.out.println("Please enter your password?");
            String password = sc.nextLine();

            if(!usersCity.equals("Admin")){
                ConcreteMovieSubject movie = new ConcreteMovieSubject(false);

                CreatingMenu(sc,locCom,ticketCosts,time,companysMovieNames,number,usersCity,movie);
            }
            else {
                // Istanbul-Kadıkoy CompanyB 13:00 Barbie
                System.out.println("Please write the new movie information.");
                String data = sc.nextLine();

                String newMovie = FindingCity(data);
                AddingLineToTextFile("text.txt",data);
                ConcreteMovieSubject movie = new ConcreteMovieSubject(true);


                if(data.contains("Istanbul") && data.contains("CompanyA")){
                    IstanbulKadikoyCompanyA d1 = new IstanbulKadikoyCompanyA("",0,movie);
                }else if (data.contains("Istanbul") && data.contains("CompanyB")){
                    IstanbulKadikoyCompanyB b1 = new IstanbulKadikoyCompanyB("",0,movie);
                }
                else if (data.contains("Antalya") && data.contains("CompanyA")) {
                    AntalyaAlanyaCompanyA a1 = new AntalyaAlanyaCompanyA("",0, movie);
                }
                //Hangi şehre eklenecekse o şehrin observar'a eklenmesi gerek
                //CreatingAdminPart();
            }


        }
        /*
        else {
            System.out.println("Which city do you want to choose");
            System.out.println("1 - Antalya");
            System.out.println("2 - Istanbul");
            System.out.println("3 - Eskisehir");
            System.out.println("If you want to exit please enter 0");
            int choice = sc.nextInt();
            CreatingMenuWhoIsntMember(sc,locCom,ticketCosts,time,companysMovieNames,number);

        }

         */
    }

    public static String FindingCity(String data) {
        if(data.contains("Istanbul")){
            return "Istanbul";

        } else if (data.contains("Antalya")) {
            return "Antalya";

        }

        return null;

    }

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

    public static String usersCity(ArrayList<String> txt, String email) {

        for (int i = 0; i < txt.size(); i++) {
            if(txt.get(i).contains("Antalya") && txt.get(i).contains(email)){
                return "Antalya";

            } else if (txt.get(i).contains("Istanbul")&& txt.get(i).contains(email)) {
                return "Istanbul";
            }

        }
        //Collection<String> values = txt.get(2);
/*
        for (String value : values) {
            if (value.contains(email)) {
                if (value.contains("Istanbul")) {
                    return "Istanbul";
                } else if (value.contains("Antalya")) {
                    return "Antalya";
                }

            }
        }
        */


        return "Admin";
    }

    private static void CreatingMenuWhoIsntMember(Scanner sc, ArrayList<String> locCom, ArrayList<Ticket> ticketCosts, ArrayList<String> time, ArrayList<String> companysMovieNames, int number) {

    }

    public static void CreatingMenu(Scanner sc, ArrayList<String> locCom, ArrayList<Ticket> ticketCosts, ArrayList<String> time, ArrayList<String> companysMovieNames, int number, String city, ConcreteMovieSubject movie) {


       // int choice = sc.nextInt();
        int counter = 0;


        while (true) {
            movie.notifyObservers();

            for (int i = 0; i < locCom.size(); i++) {

                CompanyStore value = FindCompany(locCom.get(i));
                if (locCom.get(i).contains(city)) {
                    Ticket ticketAntalya = value.orderTicket(locCom.get(i), 0,movie);
                    ticketCosts.add(ticketAntalya);
                    number = TicketList(number, ticketAntalya, time.get(i), companysMovieNames.get(i));



                }
            }


            System.out.println("Please enter your choice If you want to exit please enter 0");
            movie.notifyObservers();
            int ticketChoice = sc.nextInt();
            movie.notifyObservers();
            if(ticketChoice == 0){
                break;
            }
            System.out.println("Would you like to beverage?");
            int beverageChoice = -1;

            while (true) {
                System.out.println("1 - Popcorn");
                System.out.println("2 - Soda");
                System.out.println("3 - Candy");
                System.out.println("Please enter a choice? Or If you want to exit please enter 0");
                beverageChoice = sc.nextInt();
                if (beverageChoice == 0)
                    break;
                System.out.println("How many do you want? ");
                int amount = sc.nextInt();

                if (beverageChoice == 1) {
                    ticketCosts.add(ticketChoice - 1, BuyingPopcorn(ticketCosts.get(ticketChoice - 1), amount));


                } else if (beverageChoice == 2) {
                    ticketCosts.add(ticketChoice - 1, BuyingSoda(ticketCosts.get(ticketChoice), amount));


                } else if (beverageChoice == 3) {
                    ticketCosts.add(ticketChoice - 1, BuyingCandy(ticketCosts.get(ticketChoice), amount));


                }
            }

            System.out.println("Ticket : " + companysMovieNames.get(ticketChoice - 1) + " " + ticketCosts.get(ticketChoice - 1).getDescription() + " " + "cost= " + ticketCosts.get(ticketChoice - 1).cost()
                    + " at: " + time.get(ticketChoice - 1));

            number = 1;


            //ticketCosts.clear();
        }



    }

    public static int printingMovieList(CompanyStore value, ArrayList<Ticket> ticketCosts, String locCom, ConcreteMovieSubject movie,
                                        String time, String companysMovieNames, int number) {
        Ticket ticketAntalya = value.orderTicket(locCom, 0,movie);
        ticketCosts.add(ticketAntalya);
        number = TicketList(number, ticketAntalya, time, companysMovieNames);
        return number;
    }

    private static Ticket BuyingCandy(Ticket aFloat, int amount) {
        if(aFloat.getDescription().contains("CompanyA")) {

            for (int i = 0; i < amount; i++) {
                aFloat = new Candy(aFloat,10);
            }
        }
        else if (aFloat.getDescription().contains("CompanyB")){
            for (int i = 0; i < amount; i++) {
                aFloat = new Candy(aFloat,15);
            }
        }
        return aFloat;
    }

    private static Ticket BuyingSoda(Ticket aFloat, int amount) {
        if(aFloat.getDescription().contains("CompanyA")) {

            for (int i = 0; i < amount; i++) {
                aFloat = new Soda(aFloat,20);
            }
        }
        else if (aFloat.getDescription().contains("CompanyB")){
            aFloat = new Soda(aFloat,15);
        }

        return aFloat;
    }

    private static Ticket BuyingPopcorn(Ticket aFloat, int amount) {
        if(aFloat.getDescription().contains("CompanyA")){
            for (int i = 0; i < amount; i++) {
                aFloat = new Popcorn(aFloat,50);
            }
        }
        else if (aFloat.getDescription().contains("CompanyB")){
            for (int i = 0; i < amount; i++) {
                aFloat = new Popcorn(aFloat,60);
            }

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



}

