package javafx.WerkplaatsApp.domein;

import java.util.*;

import javafx.WerkplaatsApp.domein.Artikel;

import java.io.*;

public class Bedrijf {
    private Parkeerplaats deParkeerplaats;
    private ArrayList<Werkorder> deWerkorders = new ArrayList<Werkorder>();
    private ArrayList<Dienst> deDiensten = new ArrayList<Dienst>();
    private ArrayList<Klant> deKlanten = new ArrayList<Klant>();
    private ArrayList<Monteur> deMonteurs = new ArrayList<Monteur>();
    private ArrayList<Factuur> deFacturen = new ArrayList<Factuur>();
    private ArrayList<Betaling> deBetalingen = new ArrayList<Betaling>();
    private ArrayList<Artikel> deArtikelen = new ArrayList<Artikel>();
    private ArrayList<Auto> deAutos = new ArrayList<Auto>();
    private ArrayList<Bestelling> deBestelling = new ArrayList<Bestelling>();

    public Bedrijf() { // hieronder worden objecten aangemaakt zodat we kunnen testen
        Werkorder w1 = new Werkorder(werkordernummer(), "Algemene periodieke keuring");
        deWerkorders.add(w1);
        Monteur m1 = new Monteur("Bob de Bouwer", 30.00, 123);
        Monteur m2 = new Monteur("Felix de Fixer", 42.50, 456);
        Monteur m3 = new Monteur("Carlos de Car", 25.00, 789);
        Klant k1 = new Klant(111, "Hans", "Worst", "Straat", "0000AA", "Utrecht", 123, "a@a.nl");
        Auto a1 = new Auto("11-22-AA", "WOLOTGF35X2123456", "Ford", "Focus");
        Artikel ar1 = new Onderdeel("Band", 70.00, "Bandenhok", 1, 40);
        deArtikelen.add(ar1);
        Artikel ar2 = new Onderdeel("Motorolie 1L", 40.00, "F6", 2, 20);
        deArtikelen.add(ar2);
        Bestelling b1 = new Bestelling(1, 249, 300);
        deBestelling.add(b1);
        a1.setDeKlant(k1);
        Date dat = new Date();
        a1.setVolgendOnderhoud(dat);
        deAutos.add(a1);
        deKlanten.add(k1);
        deMonteurs.add(m1);
        deMonteurs.add(m2);
        deMonteurs.add(m3);
        Onderhoudsbeurt ob1 = new Onderhoudsbeurt(1, "Band vervangen", 0.25);
        deDiensten.add(ob1);
        Onderhoudsbeurt ob2 = new Onderhoudsbeurt(2, "Klein onderhoud", 1.00);
        deDiensten.add(ob2);
        Onderhoudsbeurt ob3 = new Onderhoudsbeurt(3, "Groot onderhoud", 3.00);
        deDiensten.add(ob3);
    }

    public ArrayList<Werkorder> geefAlleWerkorders(Monteur z) {  // alle werkorders weergeven
        ArrayList<Werkorder> hulp = null;
        hulp = z.geefAlleWerkorder();
        return hulp;
    }

    public Werkorder zoekWerkorder(int nr) {            //werkorder zoeken op werkordernummer
        Werkorder gezochte = null;
        for (Werkorder w : deWerkorders) {
            if (w.getWONummer() == nr) {
                gezochte = w;
            }
        }
        return gezochte;
    }

    public int werkordernummer() {                //werkordernummer genereren
        int i;
        if (deWerkorders.size() == 0 || deWerkorders == null) {
            i = 1;
            return i;
        }
        i = deWerkorders.size() + 1;
        return i;
    }

    public int klantnummer() {            //klantnummer genereren
        int i;
        if (deKlanten.size() == 0 || deKlanten == null) {
            i = 1;
            return i;
        } else {
            i = deKlanten.size() + 1;
        }
        return i;
    }

    public boolean voegWerkOrderToe(Werkorder w) { //werkorder aanmaken als deze nog niet bestaat
        boolean b = false;
        if (!deWerkorders.contains(w)) {
            deWerkorders.add(w);
            b = true;
        }
        return b;
    }

    public ArrayList geefAlleMonteurs() {        //geef alle monteurs
        return deMonteurs;
    }

    public Auto zoekAuto(String s) {
        Auto gezochte = null;
        for (Auto a : deAutos) {
            if (a.getKenteken().equals(s)) {
                gezochte = a;
            }
        }
        return gezochte;
    }

    public Klant zoekKlant(int nr) {    //zoek klant op klantnnummer
        Klant gezochte = null;
        for (Klant k : deKlanten) {
            if (k.getKlantnummer() == nr) {
                gezochte = k;
            }
        }
        return gezochte;
    }

    public Klant zoekKlant(Klant k) {        //zoek klant op naw gegevens
        Klant gezochte = null;
        if (deKlanten.contains(k)) {
            gezochte = k;
        }
        return gezochte;
    }

    public boolean voegKlantToe(Klant k) {        //voeg klant toe
        boolean b = false;
        if (!deKlanten.contains(k)) {
            deKlanten.add(k);
            b = true;
        }
        return b;
    }

    public Artikel zoekArtikel(int nr) {            //zoek artikel op nummer
        Artikel gezochte = null;
        for (Artikel a : deArtikelen) {
            if (a.getArtNummer() == nr) {
                gezochte = a;
            }
        }
        return gezochte;
    }

    public boolean voegArtikelToe(Artikel a) {            //voeg artikel toe
        boolean b = false;
        if (!deArtikelen.contains(a)) {
            deArtikelen.add(a);
            b = true;
        }
        return b;
    }

    public boolean verwijderArtikel(Artikel a) {            //verwijder artikel
        boolean b = false;
        Artikel hulp = zoekArtikel(a.getArtNummer());
        if (hulp != null) {
            deArtikelen.remove(a);
            b = true;
        }
        return b;
    }

    public boolean voegMonteurToe(Monteur m) {        //monteur aanmaken
        boolean b = true;
        Monteur hulp = m;
        if (hulp != null) {
            for (Monteur mon : deMonteurs) {
                if (m.equals(hulp)) {
                    b = false;
                }
            }
            if (b = true) {
                deMonteurs.add(m);
            }
        }
        return b;
    }

    public boolean zoekMonteur(int nr) {            //zoek monteur op monteurnummer
        boolean b = false;
        for (Monteur mon : deMonteurs) {
            if (mon.getMonteurNummer() == nr) {
                b = true;
            }
        }
        return b;
    }

    public int bestelnummer()        //genereer bestelnummer
    {
        int i = deBestelling.size() + 1;
        return i;
    }

    public boolean maakBestelling(int artnr, int aantal)        //  maak bestelling zet onderdeel op bestellijst
    {                                                            //en voeg artikel bij aan de voorraad(alsof het geleverd is)
        Artikel a = null;
        a = (Onderdeel) zoekArtikel(artnr);
        Bestelling b = new Bestelling(bestelnummer(), artnr, aantal);
        deBestelling.add(b);
        a.setAantal(aantal);

        return true;
    }

    public void saveObjectToFile(String fileName, ArrayList objectListToSave) throws IOException {
        FileOutputStream ois = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(ois);
        oos.writeObject(objectListToSave);
        oos.close();
    }

    public void save(Object obj) throws IOException
    {
        if (obj instanceof Klant) {
            saveObjectToFile("Klanten.obj", deKlanten);
        }

        if (obj instanceof Auto) {
            saveObjectToFile("Autos.obj", deAutos);
        }

        if (obj instanceof Werkorder) {
            saveObjectToFile("Werkorders.obj", deWerkorders);
        }

        if (obj instanceof Artikel) {
            saveObjectToFile("Artikelen.obj", deArtikelen);
        }

        if (obj instanceof Monteur) {
            saveObjectToFile("Monteurs.obj", deMonteurs);
        }

        if (obj instanceof Factuur) {
            saveObjectToFile("Facturen.obj", deFacturen);
        }

        if (obj instanceof Betaling) {
            saveObjectToFile("Betalingen.obj", deBetalingen);
        }

        if (obj instanceof Dienst) {
            saveObjectToFile("Diensten.obj", deDiensten);
        }

        if (obj instanceof Parkeerplaats) {
            FileOutputStream ois = new FileOutputStream("Parkeerplaats.obj");
            ObjectOutputStream oos = new ObjectOutputStream(ois);
            oos.writeObject(deParkeerplaats);
            oos.close();
        }

        if (obj instanceof Bestelling) {
            FileOutputStream ois = new FileOutputStream("Bestelling.obj");
            ObjectOutputStream oos = new ObjectOutputStream(ois);
            oos.writeObject(deBestelling);
            oos.close();
        }
    }

    public String geefAlleArtikelen() {
        String s = "";
        for (Artikel a : deArtikelen) {
            s += a.toString() + "\n";
        }
        return s;
    }

    public String geefAlleBestellingen() {
        String s = "";
        for (Bestelling b : deBestelling) {
            s += b.toString() + "\n";

        }
        return s;

    }
}
