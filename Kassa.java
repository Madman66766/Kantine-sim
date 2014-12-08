import java.util.ArrayList;
import java.util.LinkedList;

public class Kassa {
    public KassaRij kassaRij;
    public int aantalArtikelen = 0;
    public int geldInKassa = 0;
    
    /**
     * Constructor
     */
    public Kassa(KassaRij kassaRij) {
        this.kassaRij = kassaRij;
    }
    
    /**
     * vraag het aantal artikelen en de totaalprijs op.
     * De implementatie wordt later vervangen 
     * door een echte betaling door de persoon. 
     * @param persoon die moet afrekenen
     */
    public void rekenAf(Persoon persoon) {
        if(persoon.getDienblad() == null) {
            return;
        }
        int aantal = 0;
        int totaal = 0;
        for(Artikel a : persoon.getDienblad().artikelen) {
            aantal++;
            totaal += a.getPrijs();
        }
        aantalArtikelen += aantal;
        geldInKassa += totaal;
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
    public int getGeldInKassa() {
        return geldInKassa;
    }
    
    /**
     * Reset de waarden van het aantal gepasseerde artikelen en 
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        aantalArtikelen = 0;
        geldInKassa = 0;
    }
}