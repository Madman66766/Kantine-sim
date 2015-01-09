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
    public boolean betaal(double tebetalen) {
        if(saldo >= tebetalen) {
            saldo -= tebetalen;
            return true;
        } else if((saldo + kredietLimiet) >= tebetalen) {
            kredietLimiet -= (tebetalen - saldo);
            saldo = 0.0;
            return true;
        }
        return false;
    }
}