public class Main {
    public static void main(String[] args) {

        Ticket antalyaA = new AntalyaCompanyA();
        System.out.println(antalyaA.getDescription() + " $" +
                antalyaA.cost());

        Ticket eskisehirB = new EskisehirCompanyB();

        eskisehirB = new Candy(eskisehirB);
        eskisehirB = new Popcorn(eskisehirB);

        System.out.println(eskisehirB.getDescription() + " $" +
                eskisehirB.cost());

        Ticket istanbulA = new IstanbulCompanyA();
        istanbulA = new Popcorn(istanbulA);
        istanbulA = new Popcorn(istanbulA);
        istanbulA = new Soda(istanbulA);

        System.out.println(istanbulA.getDescription() + " $" +
                istanbulA.cost());




    }
}