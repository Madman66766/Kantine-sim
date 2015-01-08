import java.util.*;

public class KantineAanbod {
    private HashMap<String, ArrayList<Artikel>> aanbod;
    private HashMap<String, Integer> beginHoeveelheid;
    private HashMap<String, Integer> hoeVaakGevuld;
    
    /**
     * Constructor. Het eerste argument is een lijst met artikelnamen,
     * het tweede argument is een lijst met prijzen en het derde argument
     * is een lijst met hoeveelheden. Let op: de dimensies van de drie arrays
     * moeten wel gelijk zijn!
     */
    public KantineAanbod(String[] artikelnaam, double[] prijs, int[] hoeveelheid) {
        aanbod=new HashMap<String, ArrayList<Artikel>>();
        beginHoeveelheid = new HashMap<String, Integer>();
        hoeVaakGevuld = new HashMap<String, Integer>();
        for(int i=0;i<artikelnaam.length;i++) 
        {
            ArrayList<Artikel> artikelen=new ArrayList<Artikel>();
            for(int j=0;j<hoeveelheid[i];j++) 
            {
                artikelen.add(new Artikel(artikelnaam[i], prijs[i]));
            }
            aanbod.put(artikelnaam[i], artikelen);
            beginHoeveelheid.put(artikelnaam[i], hoeveelheid[i]);
            hoeVaakGevuld.put(artikelnaam[i], 0);
        }
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
}
