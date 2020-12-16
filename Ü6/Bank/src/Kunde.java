public class Kunde extends Thread {
    Kontoverwaltung kontoverwaltung;

    public Kunde(Kontoverwaltung kontoverwaltung) {
        this.kontoverwaltung = kontoverwaltung;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            kontoverwaltung.einzahlen(500);
            try {
                sleep(30);
            } catch (InterruptedException e) {
            }
            kontoverwaltung.abheben(500);
        }
        System.out.println(kontoverwaltung.getKontostand());
    }
}
