import java.util.Stack;
import java.util.Iterator;
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
   
   public Iterator<Artikel> getArtikelen() {
       Iterator<Artikel> artikelLijst = artikelen.iterator();
       return artikelLijst;
   }
   
   /**
    * Methode om artikel aan dienblad toe te voegen* @param artikel
    */
   public void voegToe(Artikel artikel) 
   {
       artikelen.add(artikel);
   }
}
