import java.util.*;

public class KantineAanbod {
    // interne opslag voorraad
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

    /*
     * Private methode om de lijst van artikelen te krijgen op basis van de    
     * naam van het artikel. Retourneert null als artikel niet bestaat.
     */
    private ArrayList<Artikel> getArrayList(String productnaam) {
         return aanbod.get(productnaam); 
    }
    
    private int getBeginHoeveelheid(String naam) {
        return beginHoeveelheid.get(naam);
    }

    /**
     * Private methode om een Artikel van de stapel artikelen af te pakken. 
     * Retourneert null als de stapel leeg is.
     */
    private Artikel getArtikel(ArrayList<Artikel> stapel) {
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
            stapel.remove(0);
            if(stapel.size() < 1000) {
                for(int i = stapel.size(); i < getBeginHoeveelheid(a.getNaam()); i++) {
                    stapel.add(a);
                }
                hoeVaakGevuld.put(a.getNaam(), (hoeVaakGevuld.get(a.getNaam()) + 1));
                System.err.println("Voorraad voor " + a.getNaam() + " was bijgevuld. (" + hoeVaakGevuld.get(a.getNaam()) + ")");
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
