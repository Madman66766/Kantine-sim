
/**
 * Dit is de Persoon class 
 * 
 * @author (Serkan Orhan, Jari Germeraad) 
 * @version (1.0)
 */
public class Persoon
{
    private String burgerservicenummer, voornaam, achternaam;
    private int dag, maand, jaar;
    private char geslacht;
    
    /**
     * Constructor for objects of class Persoon
     */
    public Persoon(String bsnPersoon, String voornaamPersoon, String achternaamPersoon, int dagPersoon, int maandPersoon, int jaarPersoon, char geslachtPersoon)
    {
        burgerservicenummer = bsnPersoon;
        voornaam = voornaamPersoon;
        achternaam = achternaamPersoon;
        dag = dagPersoon;
        maand = maandPersoon;
        jaar = jaarPersoon;
        geslacht = geslachtPersoon;
        setBSN(burgerservicenummer);
        setVoornaam(voornaamPersoon);
        setAchternaam(achternaamPersoon);
        setGeboortedatum(dagPersoon, maandPersoon, jaarPersoon);
        setGeslacht(geslachtPersoon);
    }

    /**
     * setter voor BSN
     */
    public void setBSN(String bsn)
    {
        if(bsn.length() == 9)
        {
         
          burgerservicenummer = bsn;
          System.out.println("BSN is veranderd naar: " + bsn);
        }
        else
        {
            burgerservicenummer = "";
            System.out.println("BSN is veranderd naar: " + "Onbekend");
        }
           
    }
    
    /**
     * setter voor voornaam
     */
    public void setVoornaam(String voorNaam)
    {
        
        if(voorNaam == "")
        {
            voornaam = "";
            System.out.println("Voornaam niet ingevuld");
        }
        else
        {
            voornaam = voorNaam;
            System.out.println("Voornaam veranderd naar: " + voornaam);
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
            System.out.println("Achternaam niet ingevuld");
        }
        else
        {
            achternaam = achterNaam;
            System.out.println("Achternaam veranderd naar: " + achternaam);
        }
    }
    
    /**
     * setter voor de geboortedatum(dag, maand, jaar)
     */
    public void setGeboortedatum(int dagDatum, int maandDatum, int jaarDatum)
    {
        if(dagDatum >= 1)
        {
            dag = dagDatum;
        }
        else
        {
            setDatumnull();
        }
        
        if(maandDatum >= 1 && maandDatum <= 12)
        {
            maand = maandDatum;
        }
        else
        {
            setDatumnull();
        }
        
        if(jaarDatum >= 1900 && jaarDatum <= 2100)
        {
            jaar = jaarDatum;
        }
        else
        {
            setDatumnull();
        }
        
        switch(maandDatum)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
            if(dagDatum <= 31)
            {
                dag = dagDatum;
            }
            else
            {
                setDatumnull();
            }
            break;
            
            case 2:
            if(jaarDatum % 4 == 0) 
            {
                if((jaarDatum % 100 == 0) && (jaarDatum % 400 != 0))
                {
                    if(dagDatum <= 28)
                    {
                        dag = dagDatum;
                    }
                    else
                    {
                        setDatumnull();
                    }
                }
                else
                {
                    if(dagDatum <= 29)
                    {
                        dag = dagDatum;
                    }
                    else
                    {
                        setDatumnull();
                    }
                }
            }
            else
            {
                if(dagDatum <= 28)
                {
                    dag = dagDatum;
                }
                else
                {
                    setDatumnull();
                }
            }
            break;
            
            case 4:
            case 6:
            case 9:
            case 11:
            if(dagDatum <= 30)
            {
                dag = dagDatum;
            }
            else
            {
                setDatumnull();
            }
            break;
            
            default:
             setDatumnull();
            break;
            
        }
        
        if(dag == 0 && maand == 0 && jaar == 0){
            System.out.println("Er is een fout opgetreden met de datum probeer opnieuw");
        }
        else
        {
            System.out.println(" Dag: " + dag + " Maand: " + maand + " Jaar: " + jaar);
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
            System.out.println("Geslacht: " + geslacht);
        }
        else
        {
            geslacht = 'O';
            System.out.println("Geslacht: Onbekend");
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
     * Getter voor voornaam
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
        return burgerservicenummer;
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
