import java.util.Stack;
/**
 * Write a description of class Dienblad here.
 * 
 * @author Serkan Orhan, Jari Germeraad 
 * @version 1-12-2014
 */
public class Dienblad 
{
   public Stack<Artikel> artikelen;
   /**
    * Constructor
    */
   public Dienblad() 
   {
       artikelen = new Stack<Artikel>();
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
   public int getTotaalPrijs() 
   {
       int totaal = 0;
       for(Artikel a : artikelen)
       {
           totaal += a.getPrijs();
       }
       return totaal;
   }
}
