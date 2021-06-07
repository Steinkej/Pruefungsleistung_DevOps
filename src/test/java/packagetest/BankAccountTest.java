package packagetest;

import org.junit.Assert;
import org.junit.Test;
import packagePL.*;

import java.sql.SQLOutput;
import java.util.ArrayList;


public class BankAccountTest {



    @Test
    public void testCreateAccount() {
        Application app = new Application();
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        app.CreateAccount("test", "1234", 200);
        Assert.assertEquals("200.0",(app.Balance("1234")));
        System.out.println("Create Account hat geklappt.");
    }

    @Test
    public void testWithdraw() {
        Application app = new Application();
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        app.CreateAccount("test", "1234", 200);
        app.Withdraw("1234",100);
        Assert.assertEquals("100.0",(app.Balance("1234")));
        System.out.println("Withdraw hat geklappt.");
    }

    @Test
    public void testDeposit() {
        Application app = new Application();
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        app.CreateAccount("test", "1234", 200);
        app.Deposit("1234",100);
        Assert.assertEquals("300.0",(app.Balance("1234")));
        System.out.println("Deposit hat geklappt.");
    }

    @Test
    public void testTransfer() {
        Application app = new Application();
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        app.CreateAccount("test", "1234", 200);
        app.CreateAccount("test1", "1235", 200);
        app.Transfer("1234","1235",100);
        Assert.assertEquals("100.0",(app.Balance("1234")));
        System.out.println("Transfer 1 hat geklappt.");
        Assert.assertEquals("300.0",(app.Balance("1235")));
        System.out.println("Transfer 2 hat geklappt.");
    }


}

