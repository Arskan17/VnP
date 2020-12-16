public class Kontoverwaltung {
    Konto konto = new Konto();
    private boolean lock = false;

    public Kontoverwaltung(Konto bank) {
        this.konto = bank;
    }

    public int getKontostand() {
        return konto.getKontostand();
    }

    public void einzahlen(int summe) {
        int kontostand;
        if (!lock) {
            lock = true;
            kontostand = konto.getKontostand();
            kontostand += summe;
            konto.setKontostand(kontostand);
            lock = false;

        }
    }
    public void abheben(int summe1){
        int kontostand;
        if (!lock) {
            lock = true;
            kontostand = konto.getKontostand();
            kontostand -= summe1;
            konto.setKontostand(kontostand);
            lock = false;

        }
    }
}
