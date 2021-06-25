package packagePL;

import java.util.ArrayList;

public class BankAccount {
    public String owner;
    public String iban;
    public double balance;
    public ArrayList<Kredit> kredite = new ArrayList<Kredit>();

    public BankAccount(String owner, String iban, double balance) {
        this.balance = balance;
        this.iban = iban;
        this.owner = owner;
    }
}
