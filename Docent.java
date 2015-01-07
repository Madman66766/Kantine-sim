
/**
 * Write a description of class Docent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Docent extends Persoon
{
    private String afkorting;
    private String afdeling;

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
     * Override voor drukAf() van Persoon
     */
    public void drukAf() {
        System.out.println(afkorting);
        System.out.println(afdeling);
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
}
