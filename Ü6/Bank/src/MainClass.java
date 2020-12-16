public class MainClass {
    public static void main(String[] args) {
        Kontoverwaltung konto = new Kontoverwaltung(new Konto());
        Kunde kunde1 = new Kunde(konto);
        Kunde kunde2 = new Kunde(konto);
        kunde1.start();
        kunde2.start();
    }
}
