import java.util.ArrayList;

public class KassaRij {
    public ArrayList<Persoon> kassaRij;
    /**
     * Constructor
     */
    public KassaRij() {
        kassaRij = new ArrayList<Persoon>(); 
    }
    
    /**
     * Persoon sluit achter in de rij aan
     * @param persoon
     */
    public void sluitAchteraan(Persoon persoon) {
        if(kassaRij == null) {
            return;
        }
        kassaRij.add(persoon);
    }
    
    /**
     * Indien er een rij bestaat, de eerste Persoon uit
     * de rij verwijderen en retourneren. 
     * Als er niemand in de rij staat geeft deze null terug.
     * @return Eerste persoon in de rij of null
     */
    public Persoon eerstePersoonInRij() {
        if(kassaRij == null) {
            return null;
        }
        Persoon p = kassaRij.get(0);
        kassaRij.remove(0);
        if(kassaRij.size() == 0) {
            kassaRij = null;
        }
        return p;
    }
    
    /**
     * Methode kijkt of er personen in de rij staan. 
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        if(kassaRij == null) {
            return false;
        }
        return true;
    }
}