/**
 * Bevat methode's voor styling.
 * 
 * @author Jari Germeraad
 * @version 07-01-2015
 */

public class Styling
{
    /**
     * Constructor voor Styling
     * 
     * Private, omdat we geen instantie van Styling willen.
     */
    private Styling() {
        
    }
    
    /**
     * Get de naam van de dag met de passende dag ID.
     * 
     * @return String
     */
    public static String getDagNaam(int i) {
        switch(i) {
            case 1:
                return "Maandag";
            case 2:
                return "Dinsdag";
            case 3:
                return "Woensdag";
            case 4:
                return "Donderdag";
            case 5:
                return "Vrijdag";
            case 6:
                return "Zaterdag";
            case 7:
                return "Zondag";
        }
        return "Onbekend";
    }
}