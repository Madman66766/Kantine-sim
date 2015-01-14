import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class Kassa {
    private KassaRij kassaRij;
    private int aantalArtikelen;
    private double geldInKassa;
    
    /**
     * Constructor
     */
    public Kassa(KassaRij kassaRij) {
        this.kassaRij = kassaRij;
        aantalArtikelen = 0;
        geldInKassa = 0.0;
    }
    
    /**
     * vraag het aantal artikelen en de totaalprijs op.
     * De implementatie wordt later vervangen 
     * door een echte betaling door de persoon. 
     * @param persoon die moet afrekenen
     */
    public void rekenAf(Persoon persoon) {
        if(persoon == null) {
            return;
        }
        if(persoon.getDienblad() == null) {
            return;
        }
        int aantal = 0;
        double totaal = 0;
        Iterator<Artikel> itr = persoon.getDienblad().getArtikelen();
        while(itr.hasNext()) {
            Artikel i = itr.next();
            aantal++;
            if(i == null)
            {
                System.err.println("artikel i was null");
            }
            totaal += i.getPrijs();
        }
        if(persoon instanceof KortingskaartHouder) {
            totaal = checkKorting(persoon, totaal);
        }
        try {
            persoon.getBetaalwijze().betaal(totaal);
            aantalArtikelen += aantal;
            geldInKassa += totaal;
        } catch (TeWeinigGeldException twge) {
            System.err.println("Exception: (" + persoon.getNaam() + ") " + twge.toString());
        }
    }
    
    /**
     * Geeft het aantal artikelen dat de kassa 
     * heeft gepasseerd, 
     * vanaf het moment dat de methode resetKassa 
     * is aangeroepen.
     * @return aantal artikelen
     */
    public int getAantalArtikelen() {
        return aantalArtikelen;
    }
    
    /**
     * Geeft het totaalbedrag van alle artikelen die
     * de kassa zijn gepasseerd, vanaf het moment dat de methode
     * resetKassa is aangeroepen.
     * @return hoeveelheid geld in de kassa
     */
    public double getGeldInKassa() {
        return geldInKassa;
    }
    
    /**
     * Reset de waarden van het aantal gepasseerde artikelen en 
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        aantalArtikelen = 0;
        geldInKassa = 0.0;
    }
    
    /**
     * Berekent het bedrag wat de persoon als korting mag nemen.
     */
    private double checkKorting(Persoon persoon, double totaal) {
        KortingskaartHouder kortingskaartHouder = (KortingskaartHouder)persoon;
        double max = kortingskaartHouder.geefMaximum();
        double kortingsPercentage = kortingskaartHouder.geefKortingsPercentage();
        if((kortingskaartHouder.heeftMaximum())) {
            if(totaal * kortingsPercentage >= max) {
                return max;
            }
        }
        return (totaal * kortingsPercentage);
    }
}