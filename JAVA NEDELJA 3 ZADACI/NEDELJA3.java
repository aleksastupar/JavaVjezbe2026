
/* Zadatak 1
public class NEDELJA3 {

    public static void main(String[] args) {

        Televizor tv = new Televizor(1, "RTCG", 5);

        tv.ispisi();

        tv.pojacajTon();

        tv.ispisi();
    }
}

class Televizor {

    private int brojKanala;
    private String nazivKanala;
    private int jacinaTona;

    public Televizor(int brojKanala, String nazivKanala, int jacinaTona) {
        setBrojKanala(brojKanala);
        setNazivKanala(nazivKanala);
        setJacinaTona(jacinaTona);
    }

    public int getBrojKanala() {
        return brojKanala;
    }

    public void setBrojKanala(int brojKanala) {
        if (brojKanala >= 1) {
            this.brojKanala = brojKanala;
        }
    }

    public String getNazivKanala() {
        return nazivKanala;
    }

    public void setNazivKanala(String nazivKanala) {
        this.nazivKanala = nazivKanala;
    }

    public int getJacinaTona() {
        return jacinaTona;
    }

    public void setJacinaTona(int jacinaTona) {
        if (jacinaTona >= 0 && jacinaTona <= 10) {
            this.jacinaTona = jacinaTona;
        }
    }

    public void pojacajTon() {
        if (jacinaTona < 10) {
            jacinaTona++;
        } else {
            System.out.println("Ton je vec na maksimumu.");
        }
    }

    public void ispisi() {
        System.out.println("Broj kanala: " + brojKanala);
        System.out.println("Naziv kanala: " + nazivKanala);
        System.out.println("Jacina tona: " + jacinaTona);
    }
}

 
public class NEDELJA3 {

    public static void main(String[] args) {

        Zaposleni z1 = new Zaposleni("Marko", "Markovic", 12, 750);
        Zaposleni z2 = new Zaposleni("Petar", "Petrovic", 5, 900);
        Zaposleni z3 = new Zaposleni("Jovan", "Jovanovic", 15, 700);

        z1.provjeriPlatu();
        z2.provjeriPlatu();
        z3.provjeriPlatu();

        z1.ispisi();
        z2.ispisi();
        z3.ispisi();
    }
}

class Zaposleni {

    private String ime;
    private String prezime;
    private int godineStaza;
    private double plata;

    public Zaposleni(String ime, String prezime, int godineStaza, double plata) {
        this.ime = ime;
        this.prezime = prezime;
        this.godineStaza = godineStaza;
        this.plata = plata;
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

    public int getGodineStaza() {
        return godineStaza;
    }

    public void setGodineStaza(int godineStaza) {
        this.godineStaza = godineStaza;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public void provjeriPlatu() {
        if (plata < 800 && godineStaza > 10) {
            plata = plata + plata * 0.06;
        }
    }

    public void ispisi() {
        System.out.println(ime + " " + prezime +
                ", godine staza: " + godineStaza +
                ", plata: " + plata);
    }
}

*/

