public class Main {
    public static void main(String[] args) {
        System.out.println("Benvenuto all'Impianto Sciistico!");
        System.out.println("Simulazione dell'impianto sciistico iniziata.");

        // Creazione degli sciatori
        Sciatore sciatoreA = new Sciatore("(1) - Panse");
        Sciatore sciatoreB = new Sciatore("(2) - Seby");
        Sciatore sciatoreC = new Sciatore("(3) - Vizzi");
        Sciatore sciatoreD = new Sciatore("(4) - Mike");

        // Avvio degli sciatori
        sciatoreA.start();
        sciatoreB.start();
        sciatoreC.start();
        sciatoreD.start();
    }
}
