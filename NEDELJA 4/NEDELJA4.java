/* 
  Zadatak 1.
  
import java.util.Scanner;
import java.util.Random;

public class NEDELJA4 {

    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        System.out.print("Unesite duzinu niza: ");
        int n = unos.nextInt();

        double[] niz = napraviNiz(n);

        System.out.println("Pocetni niz:");
        ispisiNiz(niz);

        izmijeniNiz(niz);

        System.out.println("\nIzmijenjeni niz:");
        ispisiNiz(niz);
    }

    static double[] napraviNiz(int n) {

        Random random = new Random();
        double[] niz = new double[n];

        for (int i = 0; i < n; i++) {
            niz[i] = random.nextInt(10) + 1;
        }

        return niz;
    }

    static void izmijeniNiz(double[] niz) {

        for (int i = 0; i < niz.length; i++) {

            if (niz[i] % 2 == 0) {
                niz[i] = -niz[i];
            } else {
                niz[i] = 1.0 / niz[i];
            }
        }
    }

    static void ispisiNiz(double[] niz) {

        for (int i = 0; i < niz.length; i++) {
            System.out.print(niz[i] + " ");
        }
    }
}
Zadatak 2.

import java.util.Scanner;

public class NEDELJA4 {

    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        System.out.print("Unesite duzinu niza: ");
        int n = unos.nextInt();

        int[] niz = new int[n];

        System.out.println("Unesite elemente niza:");
        for (int i = 0; i < n; i++) {
            niz[i] = unos.nextInt();
        }

        AnalizaNiza analiza = new AnalizaNiza();

        double prosjek = analiza.nadjiParniPozitivniProsjek(niz);

        System.out.println("Prosjek pozitivnih parnih brojeva je: " + prosjek);
    }
}


class AnalizaNiza {

    public double nadjiParniPozitivniProsjek(int[] niz) {

        int suma = 0;
        int brojac = 0;

        for (int i = 0; i < niz.length; i++) {

            if (niz[i] > 0 && niz[i] % 2 == 0) {
                suma = suma + niz[i];
                brojac++;
            }
        }

        if (brojac == 0) {
            return 0;
        }

        return (double) suma / brojac;
    }
}
*/

    import java.util.Scanner;

public class NEDELJA4 {

    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        double[] temperature = new double[5];

        System.out.println("Unesite 5 temperatura:");
        for (int i = 0; i < temperature.length; i++) {
            temperature[i] = unos.nextDouble();
        }

        EvidencijaTemperatura evidencija = new EvidencijaTemperatura(temperature);

        System.out.println("Duzina niza: " + temperature.length);

        System.out.println("Unesene temperature:");
        evidencija.ispisi();

        System.out.print("Unesite temperaturu za provjeru i uklanjanje: ");
        double trazena = unos.nextDouble();

        if (evidencija.postoji(trazena)) {
            System.out.println("Temperatura se nalazi u nizu.");
            evidencija.ukloni(trazena);
        } else {
            System.out.println("Temperatura se ne nalazi u nizu.");
        }

        System.out.println("Azurirani niz:");
        evidencija.ispisi();

        System.out.println("Prosjecna temperatura: "
                + evidencija.prosjecnaTemperatura(evidencija.getTemperature()));

        System.out.println("Maksimalna temperatura: "
                + evidencija.maksimalnaTemperatura(evidencija.getTemperature()));
    }
}


class EvidencijaTemperatura {

    private double[] temperature;

    public EvidencijaTemperatura(double[] temperature) {
        this.temperature = temperature;
    }

    public double[] getTemperature() {
        return temperature;
    }

    public void setTemperature(double[] temperature) {
        this.temperature = temperature;
    }

    public void ispisi() {
        for (int i = 0; i < temperature.length; i++) {
            System.out.print(temperature[i] + " ");
        }
        System.out.println();
    }

    public boolean postoji(double vrijednost) {

        for (int i = 0; i < temperature.length; i++) {
            if (temperature[i] == vrijednost) {
                return true;
            }
        }

        return false;
    }

    public void ukloni(double vrijednost) {

        int brojac = 0;

        for (int i = 0; i < temperature.length; i++) {
            if (temperature[i] != vrijednost) {
                brojac++;
            }
        }

        double[] noviNiz = new double[brojac];

        int j = 0;

        for (int i = 0; i < temperature.length; i++) {
            if (temperature[i] != vrijednost) {
                noviNiz[j] = temperature[i];
                j++;
            }
        }

        temperature = noviNiz;
    }

    public double prosjecnaTemperatura(double[] niz) {

        double suma = 0;

        for (int i = 0; i < niz.length; i++) {
            suma = suma + niz[i];
        }

        return suma / niz.length;
    }

    public double maksimalnaTemperatura(double[] niz) {

        double max = niz[0];

        for (int i = 1; i < niz.length; i++) {
            if (niz[i] > max) {
                max = niz[i];
            }
        }

        return max;
    }
}