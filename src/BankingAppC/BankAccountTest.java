package BankingAppC;
import static org.junit.Assert.*;
import org.junit.Test;



public class BankAccountTest {
    String[] args = new String[2];


    @Test
    public void testCreate() {
        BankApp.main(args);
        new Application();
        Application bank = new Application();
        bank.CreateAccount("test", "1234", 200);
        assertEquals("200.0", bank.Balance("1234"));
    }

    @Test
    public void testWithdraw() {
        BankApp.main(args);
        new Application();
        Application bank = new Application();
        bank.CreateAccount("test", "1234", 200);
        bank.Withdraw("1234", 100);
        assertEquals("100.0", bank.Balance("1234"));
    }

    @Test
    public void testDeposit() {
        BankApp.main(args);
        new Application();
        Application bank = new Application();
        bank.CreateAccount("test", "1234", 200);
        bank.Deposit("1234", 100);
        assertEquals("300.0", bank.Balance("1234"));
    }

    @Test
    public void testTransfer() {
        BankApp.main(args);
        new Application();
        Application bank = new Application();
        bank.CreateAccount("test", "1234", 200);
        bank.CreateAccount("test1", "1235", 200);
        bank.Transfer("1234","1235",100);
        assertEquals("100.0", bank.Balance("1234"));
        assertEquals("300.0", bank.Balance("1235"));
    }


}

