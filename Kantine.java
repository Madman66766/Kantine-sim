public class Kantine {
    private Kassa kassa;
    private KassaRij kassaRij;
    private KantineAanbod kantineaanbod;
    private Persoon persoon;

    /**
     * Constructor
     */
    public Kantine() {
        kassaRij=new KassaRij();
        kassa=new Kassa(kassaRij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad
     * gemaakt en aan elkaar
     * gekoppeld. Maak twee Artikelen aan en plaats 
     * deze op het dienblad. 
     * Tenslotte sluit de Persoon zich aan bij de rij 
     * voor de kassa.
     */
    public void loopPakSluitAan(Persoon persoon, String[] artikelnamen) {
        for(int i = 0; i < artikelnamen.length; i++)
        {
            persoon.getDienblad().voegToe(kantineaanbod.getArtikel(artikelnamen[i]));
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
     * Deze methode telt het geld uit de kassa
     * @return hoeveelheid geld in kassa
     */
    public double hoeveelheidGeldInKassa() {
        return kassa.geldInKassa;
    }

    /**
     * Deze methode geeft het aantal gepasseerde artikelen.
     * @return het aantal gepasseerde artikelen
     */
    public int aantalArtikelen(){
        return kassa.aantalArtikelen;
    }

    /**
     * Returns Kassa type kassa
     * @returns kassa
     */
    public Kassa getKassa() {
        return kassa;
    }

    /**
     * getter voor de kantineaanbod
     */
    public KantineAanbod getKantineAanbod()
    {
        return kantineaanbod;
    }

    /**
     * setter voor kantineaanbod
     */
    public void setKantineAanbod(KantineAanbod kantineaanbod)
    {
        this.kantineaanbod = kantineaanbod;
    }
}