package packagePL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Calendar;

/**
 * Test
 * @author Jon
 */

public class Application {

    public ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
    public double bankGuthaben;

    public void Action() {

        Scanner sc = new Scanner(System.in);
        boolean condition = true;
        while (condition) {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            System.out.println("|    Sie können die folgenden Befehle benutzen:                                                                              |");
            System.out.println("|    transfer <sourceaccount> <targetaccount> <amount>       |Überweist <amount von <sourceaccount> auf <targetaccount>      |");
            System.out.println("|    deposit <amount> <account>                              |Zahlt <amount> auf <account>                                   |");
            System.out.println("|    withdraw <amount> <account>                             |Hebt <amount> von <account> ab                                 |");
            System.out.println("|    createaccount <name>                                    |Erzeugt ein neues Konto und gibt den Namen des Kontos zurück   |");
            System.out.println("|    exit                                                    |Um das Programm zu beenden                                     |");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

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
                case "show balance":
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

    public String Balance(String iban) {
        for (BankAccount account : accounts) {
            if (account.iban.equals(iban)) {
                return String.valueOf(account.balance);
            }
        }
        return "Iban existiert nicht.";
    }

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

    public void Withdraw(String iban, double amount) {
        for (BankAccount account : accounts) {
            if (account.iban.equals(iban)) {
                account.balance -= amount;
            }
        }
    }

    public void Deposit(String iban, double amount) {
        for (BankAccount account : accounts) {
            if (account.iban.equals(iban)) {
                account.balance += amount;
            }
        }
    }

    public void CreateAccount(String name, String iban, double balance) {
        BankAccount account = new BankAccount(name, iban, balance);
        accounts.add(account);
    }
    public void CreateKredit(String iban, double amount, String faelligkeitsDatum, double zinssatz){
        for (BankAccount account : accounts) {
            if (account.iban.equals(iban)) {
                account.kredite.add(new Kredit(Calendar.getInstance().toString(), faelligkeitsDatum, amount, zinssatz));
                bankGuthaben -= amount;
            }
        }
    }

    public void PayOldestKreditMitZins(String iban){
        for (BankAccount account : accounts) {
            if (account.iban.equals(iban)) {
                account.balance -= account.kredite.get(0).betrag + (account.kredite.get(0).betrag * account.kredite.get(0).zinssatz);
                bankGuthaben += account.kredite.get(0).betrag;
                account.kredite.remove(0);
            }
        }
    }
    public void zinsBegleichung(){
        for (BankAccount account : accounts) {
            for (Kredit kredit : account.kredite) {
                account.balance -= kredit.betrag * kredit.zinssatz;
                bankGuthaben += kredit.betrag * kredit.zinssatz;
            }
        }
    }
}
