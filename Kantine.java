public class Kantine {
    public Kassa kassa;
    public KassaRij kassaRij;
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
    public void loopPakSluitAan() {
         Artikel artikel1 = new Artikel("Banaan", 50);
         Artikel artikel2 = new Artikel("Appel", 40);
         Dienblad dienblad1 = new Dienblad();
         dienblad1.voegToe(artikel1);
         dienblad1.voegToe(artikel2);
         Persoon persoon1 = new Persoon("000000000", "Henk", "Visser", 8, 11, 1996, 'M');
         persoon1.pakDienblad(dienblad1);
         kassaRij.sluitAchteraan(persoon1);
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
    public int hoeveelheidGeldInKassa() {
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
}