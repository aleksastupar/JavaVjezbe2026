
/* Zadatak 1: */

import java.util.ArrayList;

public class NEDELJA7 {

    public static void main(String[] args) {

    }
}


abstract class Vozilo {

    private int id;
    private double maxBrzina;

    public Vozilo(int id, double maxBrzina) {
        this.id = id;
        this.maxBrzina = maxBrzina;
    }

    public int getId() {
        return id;
    }

    public double getMaxBrzina() {
        return maxBrzina;
    }

    public void info() {
        System.out.println("ID: " + id);
        System.out.println("Maksimalna brzina: " + maxBrzina);
    }

    public abstract double izracunajVrijemeDostave(double udaljenostKm);
}


interface Ekonomican {

    double potrosnjaPoKm();
}


class Bicikl extends Vozilo implements Ekonomican {

    public Bicikl(int id, double maxBrzina) {
        super(id, maxBrzina);
    }

    public double izracunajVrijemeDostave(double udaljenostKm) {
        return udaljenostKm / getMaxBrzina();
    }

    public double potrosnjaPoKm() {
        return 0;
    }
}


class Motor extends Vozilo implements Ekonomican {

    public Motor(int id, double maxBrzina) {
        super(id, maxBrzina);
    }

    public double izracunajVrijemeDostave(double udaljenostKm) {
        return udaljenostKm / getMaxBrzina();
    }

    public double potrosnjaPoKm() {
        return 0.03;
    }
}


class Automobil extends Vozilo {

    public Automobil(int id, double maxBrzina) {
        super(id, maxBrzina);
    }

    public double izracunajVrijemeDostave(double udaljenostKm) {
        return udaljenostKm / getMaxBrzina();
    }
}


class TestZadatka1 {

    public static void main(String[] args) {

        ArrayList<Vozilo> vozila = new ArrayList<Vozilo>();

        vozila.add(new Bicikl(1, 25));
        vozila.add(new Motor(2, 100));
        vozila.add(new Automobil(3, 150));

        double udaljenost = 10;

        for (int i = 0; i < vozila.size(); i++) {

            Vozilo v = vozila.get(i);

            v.info();

            System.out.println("Vrijeme dostave: "
                    + v.izracunajVrijemeDostave(udaljenost)
                    + " h");

            if (v instanceof Ekonomican) {

                Ekonomican e = (Ekonomican) v;

                System.out.println("Potrosnja za " + udaljenost
                        + " km: "
                        + e.potrosnjaPoKm() * udaljenost);
            }

            System.out.println();
        }
    }
}