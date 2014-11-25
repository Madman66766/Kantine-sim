
/**
 * Dit is de Artikel class
 * 
 * @author (Serkan Orhan 328095) 
 * @version (1.0)
 */
public class Artikel
{
    private String naam;
    private Double prijs;

    /**
     * Constructor for objects of class Artikel
     */
    public Artikel(String naamArtikel, Double prijsArtikel)
    {
        naam = naamArtikel;
        prijs = prijsArtikel;
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
    public Double getPrijs()
    {
        return prijs;
    }
    
    /**
     * setter voor NaamArtikel
     */
    public void setNaamArtikel(String Naam)
    {
        naam = Naam;
    }
    
    /**
     * setter voor PrijsArtikel
     */
    public void setPrijsArtikel(Double Prijs)
    {
        prijs = Prijs;
    }
    
    public void drukAf()
    {
        System.out.println("Naam artikel: " + getNaam());
        System.out.println("Prijs artikel: " + getPrijs());
    }
}
