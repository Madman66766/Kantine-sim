public class Kantine {
    private Kassa kassa;
    private KassaRij kassaRij;
    private KantineAanbod kantineAanbod;
    /**
     * Constructor
     */
    public Kantine() {
        kassaRij=new KassaRij();
        kassa=new Kassa(kassaRij);
    }
    
    /**
     * In deze methode kiest een Persoon met een dienblad
     * de artikelen in artikelnamen.
     * @param persoon
     * @artikelnamen
     */
    public void loopPakSluitAan(Persoon persoon, String[] artikelnamen) {
        for(int i = 0; i < artikelnamen.length; i++) {
            persoon.getDienblad().voegToe(kantineAanbod.getArtikel(artikelnamen[i]));
        }
        kassaRij.sluitAchteraan(persoon);
    }
    
    public KassaRij getKassaRij() {
        return kassaRij;
    }
    
    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while(kassaRij.erIsEenRij()) {
            kassa.rekenAf(kassaRij.eerstePersoonInRij());
        }
    }
    
    /**
     * Returns kantineAanbod
     * @return kantineAanbod
     */
    public KantineAanbod getKantineAanbod() {
        return kantineAanbod;
    }
    
    /**
     * Sets kantineAanbod
     * 
     * @param kantineAanbod Aanbod van kantine
     */
    public void setKantineAanbod(KantineAanbod ka) {
        kantineAanbod = ka;
    }
    
    /**
     * Returns Kassa type kassa
     * @return kassa
     */
    public Kassa getKassa() {
        return kassa;
    }
}