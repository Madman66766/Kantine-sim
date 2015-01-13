public abstract class Betaalwijze
{
    protected double saldo;
    
    /**
     * Methode om krediet te initialiseren
     * @param krediet
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
        
    }
    
    /**
     * Methode om betaling af the handelen
     * @param tebetalen
     * @return Boolean om te kijken of er voldoende saldo is
     */
    public abstract boolean betaal(double tebetalen) throws TeWeinigGeldException;
}