
/**
 * Write a description of class KantineMedewerker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KantineMedewerker extends Persoon implements KortingskaartHouder
{
    private boolean magAchterKassa;
    private String medewerkerNummer;
    private static final double KORTINGS_PERCENTAGE = 0.35;
    
    /**
     * Constructor for KantineMedewerker
     */
    public KantineMedewerker() {
        super();
        magAchterKassa = false;
        medewerkerNummer = "";
    }
    
    /**
     * Override voor methode toString()
     */
    public String toString() {
        return super.toString() + "\nMedewerkernummer: " + medewerkerNummer + "\nMag achter de kassa: "
                + magAchterKassa;
    }
    
    /**
     * Setter voor magAchterKassa
     * 
     * @param bool Of de kantinemedewerker achter de kassa mag of niet.
     */
    public void setMagAchterKassa(boolean magAchterKassa) {
        this.magAchterKassa = magAchterKassa;
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
    
    /**
     * Implementatie voor geefKortingsPercentage()
     */
    public double geefKortingsPercentage() {
        return KORTINGS_PERCENTAGE;
    }
    
    /**
     * Implementatie voor heeftMaximum()
     */
    public boolean heeftMaximum() {
        return false;
    }
    
    /**
     * Implementatie voor geefMaximum()
     */
    public double geefMaximum() {
        return 0.0;
    }
}
