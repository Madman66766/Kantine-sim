
/**
 * Dit is de Persoon class 
 * 
 * @author (Serkan Orhan, Jari Germeraad) 
 * @version (1.0)
 */
public class Persoon
{
    private String bsn, voorNaam, achternaam;
    private int dag, maand, jaar;
    private char geslacht;
    
    /**
     * Constructor for objects with no parameters of class Persoon
     */
    public Persoon()
    {
        setBSN(null);
        setVoornaam(null);
        setAchternaam(null);
        setGeboortedatum(0, 0, 0);
        setGeslacht('O');
    }
    
    /**
     * Constructor for objects of class Persoon
     */
    public Persoon(String bsnPersoon, String voorNaamPersoon, String achternaamPersoon, int dagPersoon, int maandPersoon, int jaarPersoon, char geslachtPersoon)
    {
        setBSN(bsnPersoon);
        setVoornaam(voorNaamPersoon);
        setAchternaam(achternaamPersoon);
        setGeboortedatum(dagPersoon, maandPersoon, jaarPersoon);
        setGeslacht(geslachtPersoon);
    }
    
    /**
     * Checks if (day >= 1 && day <= 28) for schrikkeljaar
     */
    private Boolean checkDays(int dag) {
        if(this.dag == 29) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Checks if jaar is a schrikkeljaar and returns true if (days >= 1 && days <= 29)
     */
    private Boolean isSchrikkelJaarValid(int dag, int jaar) {
        if(this.dag < 1 && this.dag > 29) {
            return false;
        }
        if(this.jaar % 4 == 0) {
            if(this.jaar % 100 == 0) {
                if(this.jaar % 400 == 0) {
                    return true;
                } else {
                    return checkDays(this.dag);
                }
            } else {
                return true;
            }
        } else {
            return checkDays(this.dag);
        }
    }
    
    /**
     * Prints error message.
     */
    private void error() {
        System.out.println("An error occurred. Please try again.");
    }
    
    /**
     * Checks if date is correct for day, month and year.
     */
    private Boolean checkDate(int dag, int maand, int jaar) {
        if(this.jaar < 1900 || this.jaar > 2100) {
            return false;
        }
        if(this.dag < 1){
            return false;
        }
        if(this.maand < 1 || this.maand > 12) {
            return false;
        }
        switch(this.maand) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(this.dag > 31) {
                    return false;
                }
                break;
            case 2:
                if(!isSchrikkelJaarValid(this.dag, this.jaar)) {
                    return false;
                }
                break;
            default:
                if(this.dag > 30) {
                    return false;
                }
                break;
        }
        return true;
    }

    /**
     * setter voor BSN
     */
    public void setBSN(String newBsn)
    {
        if(newBsn.length() == 9) {
            bsn = newBsn;
        } else {
            bsn = "";
            error();
        }
    }
    
    /**
     * setter voor voorNaam
     */
    public void setVoornaam(String newVoorNaam)
    {
        if(newVoorNaam == "") {
            voorNaam = "";
        } else {
            voorNaam = newVoorNaam;
            error();
        }
    }
    
    /**
     * setter voor achternaam
     */
    public void setAchternaam(String achterNaam)
    {
        
        if(achterNaam == "")
        {
            achternaam = "";
        }
        else
        {
            achternaam = achterNaam;
            error();
        }
    }
    
    /**
     * setter voor de geboortedatum(dag, maand, jaar)
     */
    public void setGeboortedatum(int dagDatum, int maandDatum, int jaarDatum)
    {
        if(checkDate(dagDatum, maandDatum, jaarDatum)) {
            dag = dagDatum;
            maand = maandDatum;
            jaar = jaarDatum;
        } else {
            dag = 0;
            maand = 0;
            jaar = 0;
            error();
        }
    }
    
    /**
     * private set dag 0 maand 0 jaar 0
     */
    private void setDatumnull()
    {
        dag = 0;
        maand = 0;
        jaar = 0;
    }
    
    /**
     * setter voor geslacht
     */
    public void setGeslacht(char geslachtGeslacht)
    {
        if(geslachtGeslacht == 'M' || geslachtGeslacht == 'V')
        {
            geslacht = geslachtGeslacht;
        }
        else
        {
            geslacht = 'O';
            error();
        }
    }
    
     /**
     * Getter voor geboortedatum
     * @return Geboortedatum
     */
     public String getGeboortedatum() {
        String temp;
        if (dag == 0 && maand == 0 && jaar == 0) 
        {
            temp = "Onbekend";
        } 
        else 
        {
            temp = dag + "/" + maand + "/" + jaar;
        }
        return temp;
    }
    
    /**
     * Getter voor voorNaam
     */
    public String getVoornaam()
    {
        return voorNaam;
    }
    
    /**
     * Getter voor achternaam
     */
    public String getAchternaam()
    {
        return achternaam;
    }
    
    /**
     * Getter voor Burgerservicenummer
     */
    public String getBSN()
    {
        return bsn;
    }
    
    /**
     * Getter voor geslacht
     */
    public String getGeslacht()
    {
        String temp;
        temp = "Onbekend";
        if(geslacht == 'M')
        {
            temp = "Man";
        }
        
        if(geslacht == 'V')
        {
            temp = "Vrouw";
        }
        
        if(geslacht == 'O')
        {
            temp = "Onbekend";
        }
        return temp;
    }
    
    /**
     * Print de details van de persoon af
     */
    public void drukAf()
    {
        System.out.println("Voornaam: " + getVoornaam());
        System.out.println("Achternaam: " + getAchternaam());
        System.out.println("Burgerservicenummer: " + getBSN());
        System.out.println("Geboortedatum: " + getGeboortedatum());
        System.out.println("Geslacht: " + getGeslacht());
    }
}
