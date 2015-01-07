
/**
 * Write a description of class KantineMedewerker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KantineMedewerker extends Persoon
{
    private boolean magAchterKassa;
    private String medewerkerNummer;
    
    /**
     * Constructor for KantineMedewerker
     */
    public KantineMedewerker() {
        super();
        magAchterKassa = false;
        medewerkerNummer = "";
    }
    
    /**
     * Override voor methode drukAf() in Persoon
     */
    public void drukAf() {
        System.out.println(magAchterKassa);
        System.out.println(medewerkerNummer);
    }
    
    /**
     * Setter voor magAchterKassa
     * 
     * @param bool Of de kantinemedewerker achter de kassa mag of niet.
     */
    public void setMagAchterKassa(boolean bool) {
        magAchterKassa = bool;
    }
    
    /**
     * Getter voor magAchterKassa
     * 
     * @return magAchterKassa
     */
    public boolean getMagAchterKassa() {
        return magAchterKassa;
    }
    
    /**
     * Setter voor medewerkerNummer
     * 
     * @param i Medewerkernummer
     */
    public void setMedewerkerNummer(String s) {
        medewerkerNummer = s;
    }
    
    /**
     * Getter voor medewerkerNummer
     * 
     * @return medewerkerNummer
     */
    public String getMedewerkerNummer() {
        return medewerkerNummer;
    }
}
