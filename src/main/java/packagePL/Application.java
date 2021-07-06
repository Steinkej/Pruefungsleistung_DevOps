package packagePL;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Klasse, die einen Banking-Service über ein CLI ermöglicht:
 * Liest zuerst Texteingaben ein, verbindet diese mit den zugehörigen Methoden und beinhaltet die für
 * Banking-Services benötigten Methoden.
 *
 * @author Gruppe3
 * @version 1.0
 * @see java.util.Scanner
 * @see java.util.ArrayList
 */

public class Application {

    public ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

    /**
     * Gibt eine Übersicht der möglichen Befehle aus.
     * Liest die Befehle von der Kommandozeile ein, leitet durch String Ausgaben die gewünschten Befehle
     * und verbindet diese, durch switch-cases, mit den Methoden.
     */
    public void Action() {

        Scanner sc = new Scanner(System.in);
        boolean condition = true;
        while (condition) {
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("|    Sie können die folgenden Befehle benutzen (Wörter einzeln eingeben):                                                                    |");
            System.out.println("|    transfer          | 1. Iban | 2. Iban    | Betrag     |                   |Überweist den bestimmten Betrag auf ein anderes Konto        |");
            System.out.println("|    deposit           | Iban    | Betrag     |                                |Zahlt den Betrag auf ihr Konto ein                           |");
            System.out.println("|    withdraw          | Iban    | Betrag     |                                |Hebt den ausgwählten Betrag von ihrem Konto ab               |");
            System.out.println("|    createaccount     | Name    | Iban       | Betrag     |                   |Erzeugt ein neues Konto mithilfe ihres Namens und einer Iban |");
            System.out.println("|    showbalance       | Iban    |                                             |Zeigt ihr Guthaben an                                        |");
            System.out.println("|    exit                                                                      |Um das Programm zu beenden                                   |");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
            String action = sc.nextLine();

            switch (action) {
                case "transfer":
                    System.out.println("Wie lautet die erste Iban?");
                    String iban1 = sc.nextLine();
                    System.out.println("Wie lautet die zweite Iban?");
                    String iban2 = sc.nextLine();
                    System.out.println("Wie viel möchten Sie überweisen?");
                    double amount = Double.parseDouble(sc.nextLine());
                    Transfer(iban1, iban2, amount);
                    break;

                case "createaccount":
                    System.out.println("Wie lautet ihr Name?");
                    String name = sc.nextLine();
                    System.out.println("Wie lautet ihre Iban?");
                    String iban = sc.nextLine();
                    System.out.println("Wie hoch ist ihr Startguthaben?");
                    double balance = Double.parseDouble(sc.nextLine());
                    CreateAccount(name, iban, balance);
                    break;
                case "withdraw":
                    System.out.println("Wie lautet ihre Iban?");
                    String ibanwithdraw = sc.nextLine();
                    System.out.println("Wie viel möchten Sie abheben?");
                    double amountwithdraw = Double.parseDouble(sc.nextLine());
                    Withdraw(ibanwithdraw, amountwithdraw);
                    break;
                case "deposit":
                    System.out.println("Wie lautet ihre Iban?");
                    String ibandeposit = sc.nextLine();
                    System.out.println("Wie viel möchten Sie einzahlen?");
                    double amountdeposit = Double.parseDouble(sc.nextLine());
                    Deposit(ibandeposit, amountdeposit);
                    break;
                case "showbalance":
                    System.out.println("Wie lautet ihre Iban?");
                    String ibanbalance = sc.nextLine();
                    System.out.println(Balance(ibanbalance));

                case "exit":
                    condition = false;
                    break;
                default:
                    System.out.println("Ihre Eingabe war falsch bitte versuchen Sie es mit den aufgeführten Befehlen erneut.");
                    break;
            }
        }
    }

    /**
     * Gibt das vorhandene Guthaben für das entsprechende Konto an und fängt einen Fehler, bei einer
     * falschen Iban, mit einem String ab.
     *
     * @param iban Iban für die Identifizierung des Kontos.
     * @return String Wird ausgegeben wenn eine falsche Iban angegeben wird.
     */
    public String Balance(String iban) {
        for (BankAccount account : accounts) {
            if (account.iban.equals(iban)) {
                return String.valueOf(account.balance);
            }
        }
        return "Iban existiert nicht.";
    }

    /**
     * Überträgt mithilfe der jewiligen Ibans einen gewünschten Betrag von einem Konto auf das andere.
     *
     * @param iban1 Iban des Kontos von dem abgehoben werden soll.
     * @param iban2 Iban des Kontos auf das überwiesen werden soll.
     * @param amount zu überweisender Betrag.
     */
    public void Transfer(String iban1, String iban2, double amount) {
        for (BankAccount account : accounts) {
            if (account.iban.equals(iban1)) {
                for (BankAccount account2 : accounts) {
                    if (account2.iban.equals(iban2)) {
                        account.balance -= amount;
                        account2.balance += amount;

                    }
                }

            }

        }

    }

    /**
     * Hebt einen gewünschten Betrag von einem, über die Iban identifizierten, Konto ab.
     *
     * @param iban Iban des Kontos von dem abgehoben werden soll.
     * @param amount Betrag der vom Konto abgehoben werden soll.
     */
    public void Withdraw(String iban, double amount) {
        for (BankAccount account : accounts) {
            if (account.iban.equals(iban)) {
                account.balance -= amount;
            }
        }
    }

    /**
     * Zahlt den eingebenen Betrag auf das mithilfe der Iban identifizierte Konto ein.
     *
     * @param iban Iban des Kontos auf das eingezahlt werden soll.
     * @param amount einzuzahlender Betrag.
     */
    public void Deposit(String iban, double amount) {
        for (BankAccount account : accounts) {
            if (account.iban.equals(iban)) {
                account.balance += amount;
            }
        }
    }

    /**
     * Erstellt ein neues Konto mit gewünschtem Namen, Iban und Startguthaben.
     *
     * @param name Name des Besitzers vom Konto.
     * @param iban gewünschte Iban für das neue Konto.
     * @param balance gewünschtes Startguthaben für das neue Konto.
     */
    public void CreateAccount(String name, String iban, double balance) {
        BankAccount account = new BankAccount(name, iban, balance);
        accounts.add(account);
    }
}
