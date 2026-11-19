
/* ZADATAK 1 


import javax.swing.JOptionPane;

public class NEDELJA9 {

    public static void main(String[] args) {

        String ime = JOptionPane.showInputDialog("Unesite ime:");
        String prezime = JOptionPane.showInputDialog("Unesite prezime:");
        String godinaTekst = JOptionPane.showInputDialog("Unesite godinu rodjenja:");

        int godina = Integer.parseInt(godinaTekst);

        String podaci = "Ime: " + ime
                + "\nPrezime: " + prezime
                + "\nGodina rodjenja: " + godina
                + "\n\nDa li su uneseni podaci tacni?";

        int potvrda = JOptionPane.showConfirmDialog(
                null,
                podaci,
                "Pregled i potvrda unosa",
                JOptionPane.YES_NO_OPTION
        );

        if (potvrda == JOptionPane.YES_OPTION) {

            String email = ime + "." + prezime + "." + godina + "@kompanija.me";

            JOptionPane.showMessageDialog(
                    null,
                    "Vasa e-mail adresa je: " + email,
                    "Email",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
        else {

            JOptionPane.showMessageDialog(
                    null,
                    "Otkazano."
            );
        }
    }v
}


ZADATAK 2 

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class NEDELJA9 extends JFrame {

    private JTextField eur;
    private JTextField usd;
    private JTextField gbp;

    private double eurUsd;
    private double eurGbp;
    private double usdGbp;

    public NEDELJA9() {

        setTitle("Konverzija valuta");
        setSize(300, 180);
        setLayout(new GridLayout(3, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        eur = new JTextField();
        usd = new JTextField();
        gbp = new JTextField();

        add(new JLabel("EUR"));
        add(eur);

        add(new JLabel("USD"));
        add(usd);

        add(new JLabel("GBP"));
        add(gbp);

        ucitajKurseve();

        ActionListener listener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {

                    if (e.getSource() == eur) {

                        double iznos = Double.parseDouble(eur.getText());

                        usd.setText("" + iznos * eurUsd);
                        gbp.setText("" + iznos * eurGbp);
                    }

                    else if (e.getSource() == usd) {

                        double iznos = Double.parseDouble(usd.getText());

                        eur.setText("" + iznos / eurUsd);
                        gbp.setText("" + iznos * usdGbp);
                    }

                    else if (e.getSource() == gbp) {

                        double iznos = Double.parseDouble(gbp.getText());

                        eur.setText("" + iznos / eurGbp);
                        usd.setText("" + iznos / usdGbp);
                    }

                }
                catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Neispravan unos."
                    );
                }
            }
        };

        eur.addActionListener(listener);
        usd.addActionListener(listener);
        gbp.addActionListener(listener);

        setVisible(true);
    }


    public void ucitajKurseve() {

        try {

            String tekst = Files.readString(Paths.get("rates.json"));

            tekst = tekst.replace("{", "");
            tekst = tekst.replace("}", "");
            tekst = tekst.replace("\"", "");

            String[] redovi = tekst.split(",");

            for (int i = 0; i < redovi.length; i++) {

                String[] dio = redovi[i].trim().split(":");

                String naziv = dio[0].trim();
                double vrijednost = Double.parseDouble(dio[1].trim());

                if (naziv.equals("EUR_USD")) {
                    eurUsd = vrijednost;
                }

                else if (naziv.equals("EUR_GBP")) {
                    eurGbp = vrijednost;
                }

                else if (naziv.equals("USD_GBP")) {
                    usdGbp = vrijednost;
                }
            }
        }
        catch (IOException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Fajl rates.json nije pronadjen."
            );
        }
    }


    public static void main(String[] args) {

        new NEDELJA9();
    }
}


ZADATAK 3 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NEDELJA9 extends JFrame implements ActionListener {

    private JTextField pojam;
    private JTextField definicija;

    private JRadioButton podrazumijevani;
    private JRadioButton engleski;
    private JRadioButton spanski;

    private JCheckBox ignorisi;

    private JButton dodaj;
    private JButton pronadji;

    private JLabel rezultat;

    public NEDELJA9() {

        setTitle("Rjecnik pojmova");
        setSize(450, 300);
        setLayout(new GridLayout(7, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pojam = new JTextField();
        definicija = new JTextField();

        podrazumijevani = new JRadioButton("Podrazumijevani");
        engleski = new JRadioButton("Engleski");
        spanski = new JRadioButton("Spanski");

        ButtonGroup jezici = new ButtonGroup();

        jezici.add(podrazumijevani);
        jezici.add(engleski);
        jezici.add(spanski);

        podrazumijevani.setSelected(true);

        ignorisi = new JCheckBox("Ignorisi velika i mala slova");

        dodaj = new JButton("Dodaj");
        pronadji = new JButton("Pronadji");

        rezultat = new JLabel("Definicija:");

        dodaj.addActionListener(this);
        pronadji.addActionListener(this);

        add(new JLabel("Pojam:"));
        add(pojam);

        add(new JLabel("Definicija:"));
        add(definicija);

        add(podrazumijevani);
        add(engleski);

        add(spanski);
        add(ignorisi);

        add(dodaj);
        add(pronadji);

        add(rezultat);

        setVisible(true);
    }


    public String izabraniJezik() {

        if (engleski.isSelected()) {
            return "Engleski";
        }

        if (spanski.isSelected()) {
            return "Spanski";
        }

        return "Podrazumijevani";
    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == dodaj) {

            if (pojam.getText().isEmpty()
                    || definicija.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Popunite sva polja."
                );

                return;
            }

            try {

                FileWriter fw = new FileWriter("pojmovi.txt", true);

                fw.write(
                        izabraniJezik() + ";"
                        + pojam.getText() + ";"
                        + definicija.getText() + "\n"
                );

                fw.close();

                JOptionPane.showMessageDialog(
                        null,
                        "Pojam je dodat."
                );

            }
            catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        "Greska pri upisu u fajl."
                );
            }
        }


        if (e.getSource() == pronadji) {

            if (pojam.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Unesite pojam."
                );

                return;
            }

            try {

                Scanner sc = new Scanner(new File("pojmovi.txt"));

                boolean pronadjen = false;

                while (sc.hasNextLine()) {

                    String linija = sc.nextLine();

                    String[] djelovi = linija.split(";");

                    String jezik = djelovi[0];
                    String trazeniPojam = djelovi[1];
                    String definicijaPojma = djelovi[2];

                    boolean istiPojam;

                    if (ignorisi.isSelected()) {

                        istiPojam = trazeniPojam.equalsIgnoreCase(
                                pojam.getText()
                        );
                    }
                    else {

                        istiPojam = trazeniPojam.equals(
                                pojam.getText()
                        );
                    }

                    if (jezik.equals(izabraniJezik())
                            && istiPojam) {

                        rezultat.setText(
                                "Definicija: " + definicijaPojma
                        );

                        pronadjen = true;
                        break;
                    }
                }

                sc.close();

                if (pronadjen == false) {
                    rezultat.setText("Pojam nije pronadjen.");
                }

            }
            catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        "Greska pri citanju fajla."
                );
            }
        }
    }


    public static void main(String[] args) {

        new NEDELJA9();
    }
}