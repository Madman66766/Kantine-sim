
public class Pinpas extends Betaalwijze {
    private double kredietLimiet;
    /**
     * Methode om kredietlimiet te zetten
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietLimiet) {
        this.kredietLimiet = kredietLimiet;
    }

    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        if(saldo >= tebetalen) {
            saldo -= tebetalen;
        } else if((saldo + kredietLimiet) >= tebetalen) {
            saldo -= tebetalen;
        } else {
            throw new TeWeinigGeldException("kan niet betalen.");
        }
    }
}