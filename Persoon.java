
/**
 * Dit is de Persoon class 
 * 
 * @author (Serkan Orhan, Jari Germeraad) 
 * @version (1.0)
 */
public class Persoon
{
    private String bsn, voornaam, achternaam;
    private int dag, maand, jaar;
    private char geslacht;
    public Dienblad dienblad;
    
    /**
     * Constructor for objects with no parameters of class Persoon
     */
    public Persoon()
    {
        setBSN("");
        setVoornaam(null);
        setAchternaam(null);
        setGeboortedatum(0, 0, 0);
        setGeslacht('O');
        dienblad = null;
    }
    
    /**
     * Constructor for objects of class Persoon
     */
    public Persoon(String bsn, String voornaam, String achternaam, int dag, int maand, int jaar, char geslacht)
    {
        setBSN(bsn);
        setVoornaam(voornaam);
        setAchternaam(achternaam);
        setGeboortedatum(dag, maand, jaar);
        setGeslacht(geslacht);
        dienblad = null;
    }
    
    /**
     * 
     */
    public Dienblad getDienblad() {
        return dienblad;
    }
    
    /**
     * Methode om dienblad te koppelen aan een persoon
     * @param dienblad
     */
    public void pakDienblad(Dienblad dienblad) {
        this.dienblad = dienblad;
    }
    
    /**
     * Checks if (day >= 1 && day <= 28) for schrikkeljaar
     */
    private Boolean isNot29(int dag) {
        if(dag == 29) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Checks if jaar is a schrikkeljaar and returns true if (days >= 1 && days <= 29)
     */
    private Boolean isSchrikkelJaarValid(int dag, int jaar) {
        if(dag < 1 && dag > 29) {
            return false;
        }
        if(jaar % 4 == 0) {
            if(jaar % 100 == 0) {
                if(jaar % 400 == 0) {
                    return true;
                } else {
                    return isNot29(dag);
                }
            } else {
                return true;
            }
        } else {
            return isNot29(dag);
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
        if(jaar < 1900 || jaar > 2100) {
            return false;
        }
        if(dag < 1){
            return false;
        }
        if(maand < 1 || maand > 12) {
            return false;
        }
        switch(maand) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(dag > 31) {
                    return false;
                }
                break;
            case 2:
                if(!isSchrikkelJaarValid(dag, jaar)) {
                    return false;
                }
                break;
            default:
                if(dag > 30) {
                    return false;
                }
                break;
        }
        return true;
    }

    /**
     * setter voor BSN
     */
    public void setBSN(String bsn)
    {
        if(bsn.length() == 9) {
            this.bsn = bsn;
        } else {
            this.bsn = "";
            
        }
    }
    
    /**
     * setter voor voorNaam
     */
    public void setVoornaam(String voornaam)
    {
        if(voornaam == "") {
            this.voornaam = "";
        } else {
            this.voornaam = voornaam;
        }
    }
    
    /**
     * setter voor achternaam
     */
    public void setAchternaam(String achternaam)
    {
        
        if(achternaam == "")
        {
            this.achternaam = "";
        }
        else
        {
            this.achternaam = achternaam;
        }
    }
    
    /**
     * setter voor de geboortedatum(dag, maand, jaar)
     */
    public void setGeboortedatum(int dag, int maand, int jaar)
    {
        if(checkDate(dag, maand, jaar)) {
            this.dag = dag;
            this.maand = maand;
            this.jaar = jaar;
        } else {
            dag = 0;
            maand = 0;
            jaar = 0;
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
    public void setGeslacht(char geslacht)
    {
        if(geslacht == 'M' || geslacht == 'V')
        {
            this.geslacht = geslacht;
        }
        else
        {
            this.geslacht = 'O';
            
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
        return voornaam;
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
