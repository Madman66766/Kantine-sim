import java.util.*;

public class KantineAanbod {
    private static final int MAX_AANTAL_ARTIKELEN = 100;
    private HashMap<String, ArrayList<Artikel>> aanbod;
    private HashMap<String, Integer> beginHoeveelheid;
    private HashMap<String, Integer> hoeVaakGevuld;
    private String[] artikelNamen = new String[MAX_AANTAL_ARTIKELEN];
    private double[] artikelPrijzen = new double[MAX_AANTAL_ARTIKELEN];
    private int[] artikelHoeveelheden = new int[MAX_AANTAL_ARTIKELEN];
    private int aantalArtikelen;
    
    /**
     * Constructor. Het eerste argument is een lijst met artikelnamen,
     * het tweede argument is een lijst met prijzen en het derde argument
     * is een lijst met hoeveelheden. Let op: de dimensies van de drie arrays
     * moeten wel gelijk zijn!
     */
    public KantineAanbod() {
        aanbod=new HashMap<String, ArrayList<Artikel>>();
        beginHoeveelheid = new HashMap<String, Integer>();
        hoeVaakGevuld = new HashMap<String, Integer>();
        aantalArtikelen = 0;
    }

    /**
     * Retourneert de ArrayList voor de gegeven naam
     * 
     * @return aanbod.get(productnaam) ArrayList met alle Artikelen van hetzelfde type.
     */
    private ArrayList<Artikel> getArrayList(String productnaam) {
         return aanbod.get(productnaam); 
    }
    
    /**
     * Getter voor de beginhoeveelheid
     * 
     * @return beginHoeveelheid.get(naam) De beginhoeveelheid voor de naam van een artikel.
     */
    private int getBeginHoeveelheid(String naam) {
        return beginHoeveelheid.get(naam);
    }

    /**
     * Private methode om een Artikel van de stapel artikelen af te pakken. 
     * Retourneert null als de stapel leeg is.
     * 
     * @return a Artikel
     */
    private Artikel getArtikel(ArrayList<Artikel> stapel) {
        String naam;
        if (stapel==null) { 
            return null;
        }
        if (stapel.size() == 0)
        {
            return null;
        }
        else 
        {
            Artikel a=stapel.get(0);
            naam = a.getNaam();
            stapel.remove(0);
            if(stapel.size() < 1000) {
                double prijs = 0.0;
                for(Artikel artikel : aanbod.get(naam)) {
                    if(artikel.getNaam() == naam) {
                        prijs = artikel.getPrijs();
                    }
                }
                for(int i = stapel.size(); i < getBeginHoeveelheid(naam); i++) {
                    stapel.add(new Artikel(naam, prijs));
                }
                hoeVaakGevuld.put(naam, (hoeVaakGevuld.get(naam) + 1));
                System.err.println("Voorraad voor " + naam + " was bijgevuld. (" + hoeVaakGevuld.get(naam) + ")");
            }
            return a;
        }
    }

    /**
     * Publieke methode om een artikel via naam van de stapel te pakken.
     * Retouneert null als artikel niet bestaat of niet op voorraad is.
     * @param naam (van artikel)
     * @return artikel (of null)
     */
    public Artikel getArtikel(String naam) {
        return getArtikel(getArrayList(naam));
    }
    
    /**
     * Maakt nieuw artikel aan en voegt toe aan artikelen.
     */
    public void addArtikel(String naam, double prijs, int hoeveelheid) {
        for(int i = 0; i < artikelNamen.length; i++) {
            if(artikelNamen[i] == naam) {
                System.err.println("Er bestaat al een artikel met dezelfde naam!");
                return;
            }
        }
        ArrayList<Artikel> artikelen = new ArrayList<Artikel>();
        for(int i = 0; i < hoeveelheid; i++) {
            artikelen.add(new Artikel(naam, prijs));
        }
        aanbod.put(naam, artikelen);
        beginHoeveelheid.put(naam, hoeveelheid);
        hoeVaakGevuld.put(naam, 0);
        artikelNamen[aantalArtikelen] = naam;
        artikelPrijzen[aantalArtikelen] = prijs;
        artikelHoeveelheden[aantalArtikelen] = hoeveelheid;
        aantalArtikelen++;
    }
    
    /**
     * Returns artikel namen
     * 
     * @return artikelNamen
     */
    public String[] getArtikelNamen() {
        return artikelNamen;
    }
    
    /**
     * Returns artikel prijzen
     * 
     * @return artikelPrijzen
     */
    public double[] getArtikelPrijzen() {
        return artikelPrijzen;
    }
    
    /**
     * Returns artikel hoeveelheden
     * 
     * @return artikelHoeveelheden
     */
    public int[] getArtikelHoeveelheden() {
        return artikelHoeveelheden;
    }
    
    /**
     * Returns aantal artikelen
     * 
     * @return aantalArtikelen
     */
    public int getAantalArtikelen() {
        return aantalArtikelen;
    }
}
