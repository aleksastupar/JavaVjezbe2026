
/* 
 
Zadatak 1:


import java.util.Scanner;

public class NEDELJA5 {

    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        System.out.println("Unesite recenicu:");
        String recenica = unos.nextLine();

        System.out.println("Broj rijeci je: " + brojRijeci(recenica));


        System.out.println("Unesite rijec:");
        String rijec = unos.nextLine();

        brojSlova(rijec);


        System.out.println("Unesite tekst za provjeru palindroma:");
        String tekst = unos.nextLine();

        if (palindrom(tekst)) {
            System.out.println("Tekst jeste palindrom.");
        }
        else {
            System.out.println("Tekst nije palindrom.");
        }
    }


    public static int brojRijeci(String recenica) {

        recenica = recenica.trim();

        if (recenica.length() == 0) {
            return 0;
        }

        String[] rijeci = recenica.split(" ");

        int brojac = 0;

        for (int i = 0; i < rijeci.length; i++) {

            if (rijeci[i].length() > 0) {
                brojac++;
            }
        }

        return brojac;
    }


    public static void brojSlova(String rijec) {

        rijec = rijec.toLowerCase();

        int samoglasnici = 0;
        int suglasnici = 0;

        for (int i = 0; i < rijec.length(); i++) {

            char slovo = rijec.charAt(i);

            if (slovo == 'a' || slovo == 'e' || slovo == 'i'
                    || slovo == 'o' || slovo == 'u') {

                samoglasnici++;
            }
            else {
                suglasnici++;
            }
        }

        System.out.println("Broj samoglasnika: " + samoglasnici);
        System.out.println("Broj suglasnika: " + suglasnici);
    }


    public static boolean palindrom(String tekst) {

        tekst = tekst.toLowerCase();

        String bezRazmaka = "";

        for (int i = 0; i < tekst.length(); i++) {

            if (tekst.charAt(i) != ' ') {
                bezRazmaka = bezRazmaka + tekst.charAt(i);
            }
        }

        StringBuilder obrnuto = new StringBuilder(bezRazmaka);

        obrnuto.reverse();

        if (bezRazmaka.equals(obrnuto.toString())) {
            return true;
        }
        else {
            return false;
        }
    }
}

Zadatak 2:

import java.util.Scanner;

public class NEDELJA5 {,,

    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        System.out.println("Unesite string:");
        String tekst = unos.nextLine();

        System.out.println("Broj jednocifrenih negativnih brojeva je: "
                + brojNegativnih(tekst));
    }

    public static int brojNegativnih(String tekst) {

        int brojac = 0;

        for (int i = 0; i < tekst.length() - 1; i++) {

            if (tekst.charAt(i) == '-') {

                if (i + 2 == tekst.length()
                        || tekst.charAt(i + 2) == '+'
                        || tekst.charAt(i + 2) == '-') {

                    brojac++;
                }
            }
        }

        return brojac;
    }
}

Zadatak 3:

import java.util.Scanner;

public class NEDELJA5 {

    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        System.out.println("Unesite trgovine:");
        String tekst = unos.nextLine();

        System.out.println("Rezultat je: " + rezultat(tekst));
    }

    public static int rezultat(String tekst) {

        String[] trgovine = tekst.split(" ");

        int suma = 0;

        for (int i = 0; i < trgovine.length; i++) {

            char oznaka = trgovine[i].charAt(0);

            int broj = Integer.parseInt(trgovine[i].substring(1));

            if (oznaka == 'S') {
                suma = suma + broj;
            }
            else if (oznaka == 'B') {
                suma = suma - broj;
            }
        }

        return suma;
    }
}

Zadatak 4:

import java.util.Scanner;

public class NEDELJA5 {

    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        System.out.println("Unesite izraz:");
        String izraz = unos.nextLine();

        System.out.println("Rezultat je: " + izracunaj(izraz));
    }

    public static double izracunaj(String izraz) {

        int pozicija = 0;
        char operacija = ' ';

        for (int i = 0; i < izraz.length(); i++) {

            if (izraz.charAt(i) == '+'
                    || izraz.charAt(i) == '-'
                    || izraz.charAt(i) == '*'
                    || izraz.charAt(i) == '/') {

                pozicija = i;
                operacija = izraz.charAt(i);
            }
        }

        int prviBroj = Integer.parseInt(izraz.substring(0, pozicija));
        int drugiBroj = Integer.parseInt(izraz.substring(pozicija + 1));

        if (operacija == '+') {
            return prviBroj + drugiBroj;
        }
        else if (operacija == '-') {
            return prviBroj - drugiBroj;
        }
        else if (operacija == '*') {
            return prviBroj * drugiBroj;
        }
        else {
            return (double) prviBroj / drugiBroj;
        }
    }
}

Zadatak 5:


import java.util.ArrayList;

class Destinacija {

    private String naziv;
    private String drzava;
    private double ocjena;
    private double udaljenostKm;
    private int brojPosjeta;

    public Destinacija(String naziv, String drzava, double ocjena,
                       double udaljenostKm, int brojPosjeta) {

        this.naziv = naziv;
        this.drzava = drzava;
        setOcjena(ocjena);
        this.udaljenostKm = udaljenostKm;
        this.brojPosjeta = brojPosjeta;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public double getOcjena() {
        return ocjena;
    }

    public void setOcjena(double ocjena) {

        if (ocjena < 0) {
            this.ocjena = 0;
        }
        else if (ocjena > 10) {
            this.ocjena = 10;
        }
        else {
            this.ocjena = ocjena;
        }
    }

    public double getUdaljenostKm() {
        return udaljenostKm;
    }

    public void setUdaljenostKm(double udaljenostKm) {
        this.udaljenostKm = udaljenostKm;
    }

    public int getBrojPosjeta() {
        return brojPosjeta;
    }

    public void setBrojPosjeta(int brojPosjeta) {
        this.brojPosjeta = brojPosjeta;
    }

    public String toString() {

        return naziv + ", " + drzava
                + ", ocjena: " + ocjena
                + ", udaljenost: " + udaljenostKm
                + " km, posjete: " + brojPosjeta;
    }
}


public class NEDELJA5 {

    public static void main(String[] args) {

        ArrayList<Destinacija> lista = new ArrayList<Destinacija>();

        lista.add(new Destinacija("Dubrovnik", "Hrvatska", 9.2, 150, 1200));
        lista.add(new Destinacija("Rim", "Italija", 9.5, 600, 2000));
        lista.add(new Destinacija("Pariz", "Francuska", 8.8, 1500, 2500));
        lista.add(new Destinacija("Sarajevo", "BiH", 8.3, 250, 900));

        System.out.println("Destinacije sa ocjenom preko 8 i udaljenosti ispod 1000 km:");
        pronadjiDestinacije(lista);

        System.out.println("Najvise posjeta ima:");
        System.out.println(najvisePosjeta(lista));

        sortiraj(lista);

        System.out.println("Sortirano po ocjeni:");

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public static void pronadjiDestinacije(ArrayList<Destinacija> lista) {

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getOcjena() > 8
                    && lista.get(i).getUdaljenostKm() < 1000) {

                System.out.println(lista.get(i));
            }
        }
    }

    public static Destinacija najvisePosjeta(ArrayList<Destinacija> lista) {

        Destinacija najveca = lista.get(0);

        for (int i = 1; i < lista.size(); i++) {

            if (lista.get(i).getBrojPosjeta() > najveca.getBrojPosjeta()) {
                najveca = lista.get(i);
            }
        }

        return najveca;
    }

    public static void sortiraj(ArrayList<Destinacija> lista) {

        for (int i = 0; i < lista.size() - 1; i++) {

            for (int j = i + 1; j < lista.size(); j++) {

                if (lista.get(i).getOcjena() < lista.get(j).getOcjena()) {

                    Destinacija pomocna = lista.get(i);

                    lista.set(i, lista.get(j));

                    lista.set(j, pomocna);
                }
            }
        }
    }
}

*/