/* 
Zadatak 1

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;


class Proizvod {

    private String opis;
    private String barkod;
    private String zemljaProizvodnje;
    private int godinaProizvodnje;
    private double uvoznaCijena;

    public Proizvod(String opis, String barkod, String zemljaProizvodnje,
                    int godinaProizvodnje, double uvoznaCijena) {

        this.opis = opis;
        this.barkod = barkod;
        this.zemljaProizvodnje = zemljaProizvodnje;
        this.godinaProizvodnje = godinaProizvodnje;
        this.uvoznaCijena = uvoznaCijena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getBarkod() {
        return barkod;
    }

    public void setBarkod(String barkod) {
        this.barkod = barkod;
    }

    public String getZemljaProizvodnje() {
        return zemljaProizvodnje;
    }

    public void setZemljaProizvodnje(String zemljaProizvodnje) {
        this.zemljaProizvodnje = zemljaProizvodnje;
    }

    public int getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(int godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public double getUvoznaCijena() {
        return uvoznaCijena;
    }

    public void setUvoznaCijena(double uvoznaCijena) {
        this.uvoznaCijena = uvoznaCijena;
    }

    public double maloprodajnaCijena() {
        return uvoznaCijena;
    }

    public String toString() {

        return opis
                + ", barkod: " + barkod
                + ", zemlja: " + zemljaProizvodnje
                + ", godina: " + godinaProizvodnje
                + ", uvozna cijena: " + uvoznaCijena;
    }
}


class Garderoba extends Proizvod {

    private String materijal;
    private String sezona;

    public Garderoba(String opis, String barkod, String zemljaProizvodnje,
                     int godinaProizvodnje, double uvoznaCijena,
                     String materijal, String sezona) {

        super(opis, barkod, zemljaProizvodnje,
                godinaProizvodnje, uvoznaCijena);

        this.materijal = materijal;
        this.sezona = sezona;
    }

    public String getMaterijal() {
        return materijal;
    }

    public void setMaterijal(String materijal) {
        this.materijal = materijal;
    }

    public String getSezona() {
        return sezona;
    }

    public void setSezona(String sezona) {
        this.sezona = sezona;
    }

    public double maloprodajnaCijena() {

        return getUvoznaCijena()
                + getUvoznaCijena() * 0.05;
    }

    public String toString() {

        return super.toString()
                + ", materijal: " + materijal
                + ", sezona: " + sezona;
    }
}


class HemijskiProizvod extends Proizvod {

    private double temperaturaSkladistenja;
    private boolean zapaljivo;

    public HemijskiProizvod(String opis, String barkod,
                            String zemljaProizvodnje,
                            int godinaProizvodnje,
                            double uvoznaCijena,
                            double temperaturaSkladistenja,
                            boolean zapaljivo) {

        super(opis, barkod, zemljaProizvodnje,
                godinaProizvodnje, uvoznaCijena);

        this.temperaturaSkladistenja = temperaturaSkladistenja;
        this.zapaljivo = zapaljivo;
    }

    public double getTemperaturaSkladistenja() {
        return temperaturaSkladistenja;
    }

    public void setTemperaturaSkladistenja(double temperaturaSkladistenja) {
        this.temperaturaSkladistenja = temperaturaSkladistenja;
    }

    public boolean isZapaljivo() {
        return zapaljivo;
    }

    public void setZapaljivo(boolean zapaljivo) {
        this.zapaljivo = zapaljivo;
    }

    public double maloprodajnaCijena() {

        if (zapaljivo == true) {

            return getUvoznaCijena()
                    + getUvoznaCijena() * 0.125;
        }
        else {

            return getUvoznaCijena()
                    + getUvoznaCijena() * 0.10;
        }
    }

    public String toString() {

        return super.toString()
                + ", temperatura: " + temperaturaSkladistenja
                + ", zapaljivo: " + zapaljivo;
    }
}


class Hrana extends Proizvod {

    private int brojKalorija;
    private LocalDate rokUpotrebe;

    public Hrana(String opis, String barkod,
                 String zemljaProizvodnje,
                 int godinaProizvodnje,
                 double uvoznaCijena,
                 int brojKalorija,
                 LocalDate rokUpotrebe) {

        super(opis, barkod, zemljaProizvodnje,
                godinaProizvodnje, uvoznaCijena);

        this.brojKalorija = brojKalorija;
        this.rokUpotrebe = rokUpotrebe;
    }

    public int getBrojKalorija() {
        return brojKalorija;
    }

    public void setBrojKalorija(int brojKalorija) {
        this.brojKalorija = brojKalorija;
    }

    public LocalDate getRokUpotrebe() {
        return rokUpotrebe;
    }

    public void setRokUpotrebe(LocalDate rokUpotrebe) {
        this.rokUpotrebe = rokUpotrebe;
    }

    public double maloprodajnaCijena() {

        if (rokUpotrebe.isBefore(LocalDate.now().plusMonths(6))) {

            return getUvoznaCijena()
                    + getUvoznaCijena() * 0.05;
        }
        else {

            return getUvoznaCijena()
                    + getUvoznaCijena() * 0.10;
        }
    }

    public String toString() {

        return super.toString()
                + ", kalorije: " + brojKalorija
                + ", rok upotrebe: " + rokUpotrebe;
    }
}


public class NEDELJA6 {

    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        ArrayList<Proizvod> proizvodi = new ArrayList<Proizvod>();

        proizvodi.add(new Garderoba(
                "Majica", "1111", "Italija",
                2026, 20, "Pamuk", "Ljeto"));

        proizvodi.add(new Garderoba(
                "Jakna", "2222", "Njemacka",
                2026, 80, "Koza", "Zima"));

        proizvodi.add(new HemijskiProizvod(
                "Razredjivac", "3333", "Francuska",
                2026, 30, 15, true));

        proizvodi.add(new HemijskiProizvod(
                "Deterdzent", "4444", "Srbija",
                2026, 10, 20, false));

        proizvodi.add(new Hrana(
                "Cokolada", "5555", "Belgija",
                2026, 5, 500,
                LocalDate.now().plusMonths(3)));

        proizvodi.add(new Hrana(
                "Tjestenina", "6666", "Italija",
                2026, 3, 350,
                LocalDate.now().plusMonths(10)));


        System.out.println("Svi proizvodi:");

        for (int i = 0; i < proizvodi.size(); i++) {
            System.out.println(proizvodi.get(i));
        }


        System.out.println("Maloprodajne cijene:");

        for (int i = 0; i < proizvodi.size(); i++) {

            System.out.println(
                    proizvodi.get(i).getOpis()
                    + ": "
                    + proizvodi.get(i).maloprodajnaCijena()
            );
        }


        System.out.println("Izaberite grupu:");
        System.out.println("1 - Garderoba");
        System.out.println("2 - Hemijski proizvodi");
        System.out.println("3 - Hrana");

        int izbor = unos.nextInt();

        double prosjek = prosjecnaCijena(proizvodi, izbor);

        System.out.println("Prosjecna maloprodajna cijena je: " + prosjek);
    }


    public static double prosjecnaCijena(
            ArrayList<Proizvod> proizvodi, int izbor) {

        double suma = 0;
        int brojac = 0;

        for (int i = 0; i < proizvodi.size(); i++) {

            Proizvod p = proizvodi.get(i);

            if (izbor == 1 && p instanceof Garderoba) {

                suma = suma + p.maloprodajnaCijena();
                brojac++;
            }

            else if (izbor == 2 && p instanceof HemijskiProizvod) {

                suma = suma + p.maloprodajnaCijena();
                brojac++;
            }

            else if (izbor == 3 && p instanceof Hrana) {

                suma = suma + p.maloprodajnaCijena();
                brojac++;
            }
        }

        if (brojac == 0) {
            return 0;
        }

        return suma / brojac;
    }
}
*/

import java.util.ArrayList;

public class NEDELJA6 {

    public static void main(String[] args) {

    }
}


class Zaposleni {

    private int id;
    private String ime;
    private String prezime;
    private double plataPoSatu;
    private int ukupanBrojSati;

    public Zaposleni(int id, String ime, String prezime,
                     double plataPoSatu, int ukupanBrojSati) {

        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.plataPoSatu = plataPoSatu;
        this.ukupanBrojSati = ukupanBrojSati;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public double getPlataPoSatu() {
        return plataPoSatu;
    }

    public void setPlataPoSatu(double plataPoSatu) {
        this.plataPoSatu = plataPoSatu;
    }

    public int getUkupanBrojSati() {
        return ukupanBrojSati;
    }

    public void setUkupanBrojSati(int ukupanBrojSati) {
        this.ukupanBrojSati = ukupanBrojSati;
    }

    public double obracunajPlatu() {
        return 4 * ukupanBrojSati * plataPoSatu;
    }

    public String getTip() {
        return "Zaposleni";
    }

    public String getDodatak() {
        return "-";
    }
}


class Konobar extends Zaposleni {

    private int prekovremeniSati;

    public Konobar(int id, String ime, String prezime,
                   double plataPoSatu, int ukupanBrojSati,
                   int prekovremeniSati) {

        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);

        this.prekovremeniSati = prekovremeniSati;
    }

    public int getPrekovremeniSati() {
        return prekovremeniSati;
    }

    public void setPrekovremeniSati(int prekovremeniSati) {
        this.prekovremeniSati = prekovremeniSati;
    }

    public double obracunajPlatu() {

        double redovnaPlata =
                4 * getUkupanBrojSati() * getPlataPoSatu();

        double prekovremenaPlata =
                4 * prekovremeniSati * getPlataPoSatu() * 1.20;

        return redovnaPlata + prekovremenaPlata;
    }

    public String getTip() {
        return "Konobar";
    }

    public String getDodatak() {
        return prekovremeniSati + " prekovremenih sati";
    }
}


class Kuvar extends Zaposleni {

    public Kuvar(int id, String ime, String prezime,
                 double plataPoSatu, int ukupanBrojSati) {

        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
    }

    public double obracunajPlatu() {

        return 1500
                + 4 * getUkupanBrojSati() * getPlataPoSatu();
    }

    public String getTip() {
        return "Kuvar";
    }
}


class Menadzer extends Zaposleni {

    private double bonus;

    public Menadzer(int id, String ime, String prezime,
                    double plataPoSatu, int ukupanBrojSati,
                    double bonus) {

        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);

        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double obracunajPlatu() {

        return 1300
                + 4 * getUkupanBrojSati() * getPlataPoSatu()
                + bonus;
    }

    public String getTip() {
        return "Menadzer";
    }

    public String getDodatak() {
        return "Bonus: " + bonus + " EUR";
    }
}


class Restoran {

    private String naziv;
    private String adresa;
    private String pib;
    private ArrayList<Zaposleni> zaposleni;

    public Restoran(String naziv, String adresa, String pib) {

        this.naziv = naziv;
        this.adresa = adresa;
        this.pib = pib;

        zaposleni = new ArrayList<Zaposleni>();
    }

    public void dodajZaposlenog(Zaposleni z) {
        zaposleni.add(z);
    }

    public void ukloniZaposlenog(int id) {

        for (int i = 0; i < zaposleni.size(); i++) {

            if (zaposleni.get(i).getId() == id) {
                zaposleni.remove(i);
                return;
            }
        }
    }

    public Zaposleni pronadjiZaposlenog(int id) {

        for (int i = 0; i < zaposleni.size(); i++) {

            if (zaposleni.get(i).getId() == id) {
                return zaposleni.get(i);
            }
        }

        return null;
    }

    public void generisiObracunPlata() {

        System.out.println(
                "ID\tIme i prezime\tTip\tSati\tDodatak\tPlata");

        for (int i = 0; i < zaposleni.size(); i++) {

            Zaposleni z = zaposleni.get(i);

            System.out.println(
                    z.getId() + "\t"
                    + z.getIme() + " " + z.getPrezime() + "\t"
                    + z.getTip() + "\t"
                    + z.getUkupanBrojSati() + "\t"
                    + z.getDodatak() + "\t"
                    + z.obracunajPlatu() + " EUR"
            );
        }
    }

    public double ukupniTrosakPlata() {

        double ukupno = 0;

        for (int i = 0; i < zaposleni.size(); i++) {
            ukupno = ukupno
                    + zaposleni.get(i).obracunajPlatu();
        }

        return ukupno;
    }
}


// OVO JE SAMO ZA TESTIRANJE ZADATKA

class TestZadatka {

    public static void main(String[] args) {

        Konobar k1 = new Konobar(
                1, "Marko", "Markovic", 8, 40, 5);

        Konobar k2 = new Konobar(
                2, "Nikola", "Nikolic", 7, 40, 3);

        Kuvar ku1 = new Kuvar(
                3, "Petar", "Petrovic", 10, 40);

        Kuvar ku2 = new Kuvar(
                4, "Ivan", "Ivanovic", 9, 40);

        Menadzer m1 = new Menadzer(
                5, "Milan", "Milic", 12, 40, 300);


        Restoran restoran =
                new Restoran("Restoran M", "Podgorica", "12345678");

        restoran.dodajZaposlenog(k1);
        restoran.dodajZaposlenog(k2);
        restoran.dodajZaposlenog(ku1);
        restoran.dodajZaposlenog(ku2);
        restoran.dodajZaposlenog(m1);

        restoran.generisiObracunPlata();

        System.out.println();

        System.out.println("Ukupan trosak plata: "
                + restoran.ukupniTrosakPlata() + " EUR");
    }
}