public class KantineSimulatie {
    private Kantine kantine;
    /**
     * Constructor
     */
    public KantineSimulatie() {
         kantine = new Kantine();
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
            Kantine kantine = new Kantine();
            //Verschrikkelijk fix, maar het werkt...
            
            // per dag nu even vast 10+i personen naar binnen
            // laten gaan, wordt volgende week veranderd...
            // for lus voor personen
            for(int j=0;j<10+i;j++){
                kantine.loopPakSluitAan();
            }
            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();
            // toon dagtotalen (artikelen en geld in kassa)
            System.out.println("[Dag: " + (i + 1) + "]Artikelen: " + kantine.kassa.aantalArtikelen + ", Geld: " + tweeDecimalen(kantine.kassa.geldInKassa));
            // reset de kassa voor de volgende dag
            kantine.resetKassa();
        }
    }
}