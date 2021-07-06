package packagetest;

import org.junit.Assert;
import org.junit.Test;
import packagePL.*;
import java.util.ArrayList;

/**
 * Klasse, die die Funktionalitäten der im Banking-Service verwendeten Methoden mithilfe von
 * junit-Tests(assertEquals) testet.
 *
 * @author Gruppe3
 * @version 1.0
 * @see java.util.ArrayList
 * @see org.junit.Test
 * @see org.junit.Assert
 */
public class BankAccountTest {

    /**
     * Überprüft die Funktionalität der Methode Createaccount mithilfe von Balance und gibt ein String aus,
     * wenn die Funktionalität gegeben ist.
     */
    @Test
    public void testCreateAccount() {
        Application app = new Application();
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        app.CreateAccount("test", "1234", 200);
        Assert.assertEquals("200.0", (app.Balance("1234")));
        System.out.println("Create Account hat geklappt.");
    }

    /**
     * Überprüft die Funktionalität der Methode Withdraw mithilfe von Balance und gibt ein String aus,
     * wenn die Funktionalität gegeben ist.
     */
    @Test
    public void testWithdraw() {
        Application app = new Application();
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        app.CreateAccount("test", "1234", 200);
        app.Withdraw("1234", 100);
        Assert.assertEquals("100.0", (app.Balance("1234")));
        System.out.println("Withdraw hat geklappt.");
    }

    /**
     * Überprüft die Funktionalität der Methode Deposit mithilfe von Balance und gibt ein String aus,
     * wenn die Funktionalität gegeben ist.
     */
    @Test
    public void testDeposit() {
        Application app = new Application();
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        app.CreateAccount("test", "1234", 200);
        app.Deposit("1234", 100);
        Assert.assertEquals("300.0", (app.Balance("1234")));
        System.out.println("Deposit hat geklappt.");
    }

    /**
     * Überprüft die Funktionalität der Methode Transfer mithilfe von Balance und gibt ein String aus,
     * wenn die Funktionalität des ersten Transfers gegeben ist und einen weiteren String,
     * falls der 2. Transfer ebenfalls fehlerfrei ist.
     */
    @Test
    public void testTransfer() {
        Application app = new Application();
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        app.CreateAccount("test", "1234", 200);
        app.CreateAccount("test1", "1235", 200);
        app.Transfer("1234", "1235", 100);
        Assert.assertEquals("100.0", (app.Balance("1234")));
        System.out.println("Transfer 1 hat geklappt.");
        Assert.assertEquals("300.0", (app.Balance("1235")));
        System.out.println("Transfer 2 hat geklappt.");
    }


}

