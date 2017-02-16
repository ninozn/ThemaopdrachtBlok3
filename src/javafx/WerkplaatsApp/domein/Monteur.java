package javafx.WerkplaatsApp.domein;

import java.io.Serializable;
import java.util.ArrayList;

public class Monteur implements Serializable {
    private String naam;
    private double uurloon;
    private int monteurNummer;
    private ArrayList<Werkorder> alleWerkorders = new ArrayList<Werkorder>();

    public Monteur(String naam, double uurloon, int monteurNummer) {
        this.naam = naam;
        this.uurloon = uurloon;
        this.monteurNummer = monteurNummer;
    }

    public boolean voegWerkOrderToe(Werkorder werkorder) {
        boolean b = false;
        if (!alleWerkorders.contains(werkorder)) {
            alleWerkorders.add(werkorder);
            b = true;
        }
        return b;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getUurloon() {
        return uurloon;
    }

    public void setUurloon(double uurloon) {
        this.uurloon = uurloon;
    }

    public int getMonteurNummer() {
        return monteurNummer;
    }

    public void setMonteurNummer(int monteurNummer) {
        this.monteurNummer = monteurNummer;
    }

    public ArrayList<Werkorder> geefAlleWerkorder() { //methode om de hele arraylist van werkorders op te vragen die bij een monteur hoort
        return alleWerkorders;
    }

    public boolean equals(Object obj) { //overridden versie van methode equals in klasse monteur, om zo een heel monteur object te kunnen vergelijken
        boolean b;
        if (obj instanceof Monteur) {
            b = true;
        } else {
            b = false;
        }
        b = b && (this.naam == ((Monteur) obj).naam);
        b = b && (this.monteurNummer == ((Monteur) obj).monteurNummer);
        b = b && (this.uurloon == ((Monteur) obj).uurloon);
        return b;
    }

    public String toString() {
        String s = naam + " " + monteurNummer;
        return s;
    }
}
