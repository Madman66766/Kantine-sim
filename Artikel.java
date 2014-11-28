  
/**
 * Dit is de Artikel class
 * 
 * @author (Serkan Orhan 328095) 
 * @version (1.0)
 */
public class Artikel
{
    private String naam;
    private int prijs;
    
    /**
     * Lege constructor voor leertaak 2
     */
    public Artikel()
    {
        naam = "Onbekend";
        prijs = 0;
    }

    /**
     * Constructor for objects of class Artikel
     */
    public Artikel(String naam, int prijs)
    {
        this.naam = naam;
        this.prijs = prijs;
    }

    /**
     * getter voor NaamArtikel
     */
    public String getNaam()
    {
        return naam;
    }
    
    /**
     * getter voor PrijsArtikel
     */
    public int getPrijs()
    {
        return prijs;
    }
    
    /**
     * setter voor NaamArtikel
     */
    public void setNaamArtikel(String naam)
    {
        this.naam = naam;
    }
    
    /**
     * setter voor PrijsArtikel
     */
    public void setPrijsArtikel(int prijs)
    {
        this.prijs = prijs;
    }
    
    public void drukAf()
    {
        System.out.println("Naam artikel: " + getNaam());
        System.out.println("Prijs artikel: " + getPrijs());
    }
}
