import java.util.*;
/**
 * Write a description of class Administratie here.
 * 
 * @author Serkan Orhan and Jari Germeraad 
 * @version 07-01-2015
 */
public class Administratie {
    public static final int DAYS_IN_WEEK = 7;
    
    private Administratie() {
        //Leeg
    }
    
    /**
     * Deze methode berekent van de int array aantal de
     * gemiddelde waarde
     * @param aantal
     * @return het gemiddelde
     */
    public static double berekenGemiddeldAantal(int[] aantal) {
        double gemiddelde = 0.0;
        int totaal = 0;
        for(int waarde : aantal) {
            totaal += waarde;
        }
        gemiddelde = totaal;
        gemiddelde = gemiddelde / aantal.length;
        return gemiddelde;
    }

    /**
     * Deze methode berekent van de double array omzet de
     * gemiddelde waarde
     * @param omzet
     * @return Het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        double gemiddelde = 0.0;
        double totaal = 0.0;
        for(double waarde : omzet) {
            totaal += waarde;
        }
        gemiddelde = totaal / omzet.length;
        return gemiddelde;
    }

    /**
     * Methode om dagomzet uit te rekenen
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */
    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[DAYS_IN_WEEK];
        for(int i = 0 ; i < DAYS_IN_WEEK; i++) {
            int j = 0;
            while(omzet.length > (i + (DAYS_IN_WEEK * j))) {
                temp[i]+=omzet[i+DAYS_IN_WEEK*j];
                j++;
            }
        }
        return temp;
    }
}
