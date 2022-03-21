package ch.hslu.ad.Bank;

/**
 * Bankauftrag, der der von einem Quell-Bankkonto einen Betrag an ein Ziel-Bankkonto überweist. Die
 * Überweisung wird in Mircoüberweisungen aufgeteilt.
 */
public final class AccountTask implements Runnable {

    private final BankAccount source;
    private final BankAccount target;
    private final int amount;

    /**
     * Erzeugt ein Bankauftrag für eine Überweisung von einem Bankkonto auf ein anderes Bankkonto.
     * @param source Quell-Bankkonto
     * @param target Ziel-Bankkonto
     * @param amount zu überweisender Betrag
     */
    public AccountTask(final BankAccount source, final BankAccount target, final int amount) {
        this.source = source;
        this.target = target;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int n = 0; n < amount; n++) {
            source.transfer(target, 1);
        }
    }

}
