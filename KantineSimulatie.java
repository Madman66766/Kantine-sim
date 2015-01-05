import java.util.*;
public class KantineSimulatie {
    private Kantine kantine;
    private KantineAanbod kantineaanbod;
    private Random random;
    private static final int AANTAL_ARTIKELEN=4;
    // artikelen
    private static final String[] artikelnamen=
        new String[] {"Koffie","Broodje pindakaas", "Broodje kaas",
            "Appelsap"};
    
    // prijzen
    private static double[] artikelprijzen=
        new double[]{1.50, 2.10, 1.65, 1.65};
    
    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT=10000;
    private static final int MAX_ARTIKELEN_PER_SOORT=20000;
    
    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG=50;
    private static final int MAX_PERSONEN_PER_DAG=100;
    
    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON=1;
    private static final int MAX_ARTIKELEN_PER_PERSOON=4;

    /**
     * Constructor
     */
    public KantineSimulatie() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden = getRandomArray(AANTAL_ARTIKELEN,MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod= new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);
        kantine.setKantineAanbod(kantineaanbod);
    }

    private String tweeDecimalen(int i) {
        String temp = "Error at tweeDecimalen with (int i = " + i + ")!";
        if(i <= 9) {
            temp = "0,0" + i;
        } else if (i >= 10 && i <= 99) {
            temp = "0," + i;
        } else if (i >= 100) {
            int first = i/100;
            int second = i - (first * 100);
            if(second > 9) {
                temp = first + "," + second;
            } else {
                temp = first + ",0" + second;
            }
        }
        return temp;
    }

    /**
     * Deze methode simuleert een aantal dagen in het 
     * verloop van de kantine
     * @param dagen
     */
    public void simuleer(int dagen) {
        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {
            //Verschrikkelijk fix, maar het werkt...
            
            // per dag nu even vast 10+i personen naar binnen
            // laten gaan, wordt volgende week veranderd...
            int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);
            // for lus voor personen
            for(int j = 0; j < 3; j++){
                Persoon persoon = new Persoon();
                Dienblad dienblad = new Dienblad();
                persoon.pakDienblad(dienblad);
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
                
                int[] tepakken = getRandomArray(aantalartikelen, 0, AANTAL_ARTIKELEN-1);
                
                String[] artikelen = geefArtikelNamen(tepakken);
                
                kantine.loopPakSluitAan(persoon,artikelen);
                
            }
            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();
            // toon dagtotalen (artikelen en geld in kassa)
            System.out.println("[Dag: " + (i + 1) + "]Artikelen: " + kantine.getKassa().aantalArtikelen + ", Geld: " + kantine.getKassa().getGeldInKassa());
            // reset de kassa voor de volgende dag
            kantine.getKassa().resetKassa();
        }
    }
    
    /**
     * Methode om een array van random getallen liggend tussen min en
    max
     * van de gegeven lengte te genereren
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */

    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp=new int[lengte];
        for(int i=0;i<lengte;i++) {
            temp[i]=getRandomValue(min, max);
        }
        return temp;
    }
    
    /**
     * Methode om een random getal tussen min(incl) en
     * max(incl) te genereren.
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
    
    /**
     * Methode om op basis van een array van indexen voor de array
     * artikelnamen de bijhorende array van artikelnamen te maken
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen=new String[indexen.length];
        for(int i=0;i<indexen.length;i++) {
            artikelen[i]=artikelnamen[indexen[i]];
        }
        return artikelen;
    }
}