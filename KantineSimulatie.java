import java.util.*;

public class KantineSimulatie {
    // kantine
    private Kantine kantine;
    // kantineaanbod
    private KantineAanbod kantineaanbod;
    // random generator
    private Random random;
    // aantal artikelen
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
    
    private static final int STUDENT_KANS = 89;
    private static final int DOCENT_KANS = 10;
    //private static final int KANTINEMEDEWERKER_KANS = 1;
    /**
     * Constructor
     */
    public KantineSimulatie(){
        kantine=new Kantine();
        random=new Random();
        int[] hoeveelheden=getRandomArray(
                AANTAL_ARTIKELEN,MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod=new KantineAanbod(artikelnamen, artikelprijzen,
            hoeveelheden);
        kantine.setKantineAanbod(kantineaanbod);
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
        return random.nextInt(max-min+1)+min;
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

    /**
     * Deze methode simuleert een aantal dagen in het
     * verloop van de kantine
     * @param dagen
     */
    public void simuleer(int dagen) {
        int[] aantalPerDag = new int[dagen];
        double[] omzetPerDag = new double[dagen];
        // for lus voor dagen
        for(int i=0;i<dagen;i++) {
            if(kantine.getKassaRij().kassaRij == null) {
                System.out.println("Kassarij is null");
                return;
            }
            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen=getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);
            // laat de personen maar komen...
            for(int j=0;j<aantalpersonen;j++) {
                int kans = getRandomValue(0, 100);
                if(kans <= STUDENT_KANS) {
                    Student student = new Student();
                    behandelPersoon(student);
                } else if (j <= (STUDENT_KANS + DOCENT_KANS)) {
                    Docent docent = new Docent();
                    behandelPersoon(docent);
                } else {
                    KantineMedewerker kantineMedewerker = new KantineMedewerker();
                    behandelPersoon(kantineMedewerker);
                }
            }
            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();
            // druk de dagtotalen af en hoeveel personen binnen
            // zijn gekomen
            System.out.println("[Dag " + (i + 1) + "]Aantal klanten: " + aantalpersonen);
            System.out.println("[Dag " + (i + 1) + "]Aantal verkochte artikelen: " + kantine.getKassa().getAantalArtikelen());
            System.out.println("[Dag " + (i + 1) + "]Hoeveelheid geld in kassa: " + kantine.getKassa().getGeldInKassa());
            // reset de kassa voor de volgende dag
            omzetPerDag[i] = kantine.getKassa().getGeldInKassa();
            aantalPerDag[i] = kantine.getKassa().getAantalArtikelen();
            kantine.getKassa().resetKassa();
        }
        System.out.println("[Periode Gemiddelde]Aantal: " + Administratie.berekenGemiddeldAantal(aantalPerDag));
        System.out.println("[Periode Gemiddelde]Omzet: €" + Administratie.berekenGemiddeldeOmzet(omzetPerDag));
        for(int i = 0; i < Administratie.DAYS_IN_WEEK; i++) {
            System.out.println("[Periode Getallen Dag " + (i + 1) + "]Omzet: " + Administratie.berekenDagOmzet(omzetPerDag)[i]);
        }
    }
    
    /**
     * Behandelt de persoon, geeft hem een dienblad, vult deze en zet hem achterin de rij.
     */
    public void behandelPersoon(Persoon persoon) {
        Dienblad dienblad = new Dienblad();
        persoon.pakDienblad(dienblad);
        int aantalartikelen=getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
        int[] tepakken=getRandomArray(aantalartikelen, 0, AANTAL_ARTIKELEN-1);
        String[] artikelen=geefArtikelNamen(tepakken);
        kantine.loopPakSluitAan(persoon, artikelen);
        //persoon.drukAf();
    }
}