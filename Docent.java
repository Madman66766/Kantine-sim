
/**
 * Write a description of class Docent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Docent extends Persoon implements KortingskaartHouder
{
    private String afkorting;
    private String afdeling;
    private static final double KORTINGS_PERCENTAGE = 0.25;

    /**
     * Constructor for objects of class Docent
     */
    public Docent()
    {
        super();
        this.afkorting = "";
        this.afdeling = "";
    }
    
    /**
     * Override voor methode toString()
     */
    public String toString() {
        return super.toString() + "\nAfkorting: " + afkorting + "\nAfdeling: " + afdeling;
    }

    /**
     * getter voor afkorting
     * 
     * @return afkorting
     */
    public String getAfkorting()
    {
        return afkorting;
    }
    
    /**
     * getter voor afdeling 
     * 
     * @return afdeling
     */
    public String getAfdeling()
    {
        return afdeling;
    }
    
    /**
     * setter afkorting 
     * 
     * @param afkorting Afkorting
     */
    public void setAfkorting(String afkorting)
    {
        this.afkorting = afkorting;
    }
    
    /**
     * setter voor afdeling
     * 
     * @param afdeling Afdeling
     */
    public void setAfdeling(String afdeling)
    {
        this.afdeling = afdeling;
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
        return true;
    }
    
    /**
     * Implementatie voor geefMaximum()
     */
    public double geefMaximum() {
        return 1.0;
    }
}
