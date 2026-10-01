/*
 * Zadatak 1:
 * Potrebno je pronaci sifru koja otvara vrata na osnovu poznatog
 * trocifrenog broja. Sifra se dobija tako sto se od zbira cifara
 * tog broja oduzme proizvod njegovih cifara.
 

import java.util.Scanner;

public class NEDELJA2 {

	public static void main(String[] args) {
		
		Scanner unos = new Scanner(System.in);
		
		System.out.print("Unesite trocifreni broj: ");
		int broj = unos.nextInt();
		
		int prvaCifra = broj/100;
		int drugaCifra = (broj/10) % 10;
		int trecaCifra = broj % 10;
		
		int zbir = prvaCifra + drugaCifra + trecaCifra;
		int proizvod = prvaCifra * drugaCifra * trecaCifra;
		
		int sifra = proizvod - zbir;
		
		System.out.print("Sifra je :" + sifra);
		

	}

}




Zadatak 2. Potrebno je napisati program kojim ce te provjeriti da li ce zavjesa prekriti prozor. 
Poznato je da je oblik zavjese i prozora pravougaonik. 
Za zavjese i prozor je poznata gornja lijeva i donja desna koordinata.

/*

import java.util.Scanner;

public class NEDELJA2 {

    public static boolean prekrivaProzor(int zx1, int zy1, int zx2, int zy2,
                                         int px1, int py1, int px2, int py2) {

        return zx1 <= px1 && zy1 >= py1 && zx2 >= px2 && zy2 <= py2;
    }

    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        System.out.println("Unesite koordinate zavjese:");
        int zx1 = unos.nextInt();
        int zy1 = unos.nextInt();
        int zx2 = unos.nextInt();
        int zy2 = unos.nextInt();

        System.out.println("Unesite koordinate prozora:");
        int px1 = unos.nextInt();
        int py1 = unos.nextInt();
        int px2 = unos.nextInt();
        int py2 = unos.nextInt();

        if (prekrivaProzor(zx1, zy1, zx2, zy2, px1, py1, px2, py2)) {
            System.out.println("Zavjesa prekriva prozor.");
        } else {
            System.out.println("Zavjesa ne prekriva prozor.");
        }
    }
}
        
Zadatak 3.

import java.util.Scanner;

public class NEDELJA2 {

    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        System.out.print("Unesite duzinu dijagonale monitora: ");
        double dijagonala = unos.nextDouble();

        System.out.print("Unesite prvi broj aspect ratio-a: ");
        double a = unos.nextDouble();

        System.out.print("Unesite drugi broj aspect ratio-a: ");
        double b = unos.nextDouble();

        double k = dijagonala / Math.sqrt(a * a + b * b);

        double sirina = a * k;
        double visina = b * k;

        double povrsina = sirina * visina;

        System.out.println("Povrsina monitora je: " + povrsina);
    }
}
        
Zadatak 4.

import java.util.Scanner;

public class NEDELJA2 {

    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        System.out.print("Unesite broj x: ");
        int x = unos.nextInt();

        System.out.print("Unesite stepen n: ");
        int n = unos.nextInt();

        int rezultat = 1;

        for (int i = 0; i < n; i++) {
            rezultat = rezultat * x;
        }

        System.out.println("Rezultat je: " + rezultat);
    }
}
        
 Zadatak 5.

import java.util.Scanner;

public class NEDELJA2 {

    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        System.out.print("Unesite cijene 3 proizvoda: ");
        double a = unos.nextDouble();
        double b = unos.nextDouble();
        double c = unos.nextDouble();

        System.out.println("Najveci zbir je: " + najveciZbir(a, b, c));
    }

    static double najveciZbir(double a, double b, double c) {

        double najveci = a + b;

        if (a + c > najveci) {
            najveci = a + c;
        }

        if (b + c > najveci) {
            najveci = b + c;
        }

        return najveci;
    }
}
        
    Zadatak 6. 

import java.util.Scanner;

public class NEDELJA2 {

    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        System.out.print("Unesite broj N: ");
        int n = unos.nextInt();

        fizzBuzz(n);
    }

    static void fizzBuzz(int n) {

        if (n % 3 == 0 && n % 5 == 0) {
            System.out.println("FizzBuzz");
        }
        else if (n % 5 == 0) {
            System.out.println("Fizz");
        }
        else if (n % 3 == 0) {
            System.out.println("Buzz");
        }
        else {
            System.out.println(n);
        }
    }
}

Zadatak 7. (8. na slici)

import java.util.Scanner;

public class NEDELJA2 {

    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        System.out.print("Unesite broj: ");
        int n = unos.nextInt();

        if (narcissistic(n)) {
            System.out.println("Da");
        } else {
            System.out.println("Ne");
        }
    }

    static boolean narcissistic(int n) {

        int broj = n;
        int pomocni = n;
        int brojCifara = 0;
        int suma = 0;

        while (pomocni > 0) {
            brojCifara++;
            pomocni = pomocni / 10;
        }

        pomocni = n;

        while (pomocni > 0) {
            int cifra = pomocni % 10;
            suma = suma + (int) Math.pow(cifra, brojCifara);
            pomocni = pomocni / 10;
        }

        return suma == broj;
    }
}
*/

import java.util.Scanner;

public class NEDELJA2 {

    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        System.out.print("Unesite koordinate drona x i y: ");
        double x = unos.nextDouble();
        double y = unos.nextDouble();

        System.out.print("Unesite broj paketa N: ");
        int n = unos.nextInt();

        double ukupnaUdaljenost = 0;

        for (int i = 0; i < n; i++) {

            System.out.print("Unesite koordinate paketa: ");
            double xi = unos.nextDouble();
            double yi = unos.nextDouble();

            if (xi > 0 && yi > 0) {
                ukupnaUdaljenost = ukupnaUdaljenost + udaljenost(x, y, xi, yi);
            }
        }

        System.out.println("Ukupna udaljenost je: " + ukupnaUdaljenost);
    }

    static double udaljenost(double x, double y, double xi, double yi) {

        return Math.sqrt((xi - x) * (xi - x) + (yi - y) * (yi - y));
    }
}