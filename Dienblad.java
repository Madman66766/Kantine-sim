import java.util.ArrayList;
/**
 * Write a description of class Dienblad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dienblad 
{
    private ArrayList<Artikel> artikelen;
   /**
    * Constructor
    */
   public Dienblad() 
   {
       artikelen = new ArrayList<Artikel>();
   }
   
   /**
    * Methode om artikel aan dienblad toe te voegen* @param artikel
    */
   public void voegToe(Artikel artikel) 
   {
       artikelen.add(artikel);
   }
   
   /**
    * Methode om aantal artikelen op dienblad te tellen
    * @return Het aantal artikelen
    */
   public int getAantalArtikelen() 
   { 
       return artikelen.size();
   }
   
   /**
    * Methode om de totaalprijs van de artikelen
    * op dienblad uit te rekenen
    * @return De totaalprijs
    */
   // public double getTotaalPrijs() 
   //{
       
   //}
}
