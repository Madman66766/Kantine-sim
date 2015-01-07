import java.util.LinkedList;

public class KassaRij {
    public LinkedList<Persoon> kassaRij;
    /**
     * Constructor
     */
    public KassaRij() {
        kassaRij = new LinkedList<Persoon>(); 
    }
    
    /**
     * Persoon sluit achter in de rij aan
     * @param persoon
     */
    public void sluitAchteraan(Persoon persoon) {
        kassaRij.add(persoon);
    }
    
    /**
     * Indien er een rij bestaat, de eerste Persoon uit
     * de rij verwijderen en retourneren. 
     * Als er niemand in de rij staat geeft deze null terug.
     * @return Eerste persoon in de rij of null
     */
    public Persoon eerstePersoonInRij() {
        if(kassaRij == null || kassaRij.size() == 0) {
            return null;
        }
        Persoon p = kassaRij.get(0);
        kassaRij.remove(0);
        return p;
    }
    
    /**
     * Methode kijkt of er personen in de rij staan. 
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        if(kassaRij == null || kassaRij.size() == 0) {
            return false;
        }
        return true;
    }
}