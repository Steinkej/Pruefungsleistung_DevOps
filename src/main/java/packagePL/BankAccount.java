package packagePL;

import java.util.ArrayList;

/**
 * Klasse, die eine Kontoliste, eine Kreditliste und ein Konto-Objekt erstellt.
 *
 * @author Gruppe3
 * @version 1.0
 * @see java.util.ArrayList
 */
public class BankAccount {
    public String owner;
    public String iban;
    public double balance;
    public ArrayList<Kredit> kredite = new ArrayList<Kredit>();

    /**
     * Weist die Parameter für ein Objekt der Klasse BankAccount zu.
     * @param owner Eigentümer des Kontos.
     * @param iban Iban für die Identifizierung des Kontos.
     * @param balance Kontostand des Kontos.
     */
    public BankAccount(String owner, String iban, double balance) {
        this.balance = balance;
        this.iban = iban;
        this.owner = owner;
    }
}
