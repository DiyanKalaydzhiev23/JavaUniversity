package test;

import bank.BankAccount;
import bank.BankAccountService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class BankAccountServiceTest {

    @Test
    public void testWithdrawSufficientFunds() {
        BankAccount bankAccount = new BankAccount("123456789", new BigDecimal("1000.00"));
        BankAccountService bankAccountService = new BankAccountService(bankAccount);

        BigDecimal withdrawnAmount = bankAccountService.withdraw(new BigDecimal("500.00"));

        assertEquals(new BigDecimal("500.00"), withdrawnAmount);
        assertEquals(new BigDecimal("500.00"), bankAccount.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        BankAccount bankAccount = new BankAccount("123456789", new BigDecimal("1000.00"));
        BankAccountService bankAccountService = new BankAccountService(bankAccount);

        BigDecimal withdrawnAmount = bankAccountService.withdraw(new BigDecimal("1500.00"));

        assertEquals(new BigDecimal("1000.00"), withdrawnAmount);
        assertEquals(new BigDecimal("1000.00"), bankAccount.getBalance());
    }

    @Test
    public void testWithdrawNegativeAmount() {
        BankAccount bankAccount = new BankAccount("123456789", new BigDecimal("1000.00"));
        BankAccountService bankAccountService = new BankAccountService(bankAccount);

        BigDecimal withdrawnAmount = bankAccountService.withdraw(new BigDecimal("-500.00"));

        assertEquals(new BigDecimal("1000.00"), withdrawnAmount);
        assertEquals(new BigDecimal("1000.00"), bankAccount.getBalance());
    }

    @Test
    public void testAccumulateInterestNegativePercentage() {
        BankAccount bankAccount = new BankAccount("123456789", new BigDecimal("1000.00"));
        BankAccountService bankAccountService = new BankAccountService(bankAccount);

        BigDecimal accumulatedInterest = bankAccountService.accumulateInterest(new BigDecimal("-5.00"));

        assertEquals(BigDecimal.ZERO, accumulatedInterest);
        assertEquals(new BigDecimal("1000.00"), bankAccount.getBalance());
    }

    @Test
    public void testAccumulateInterestValidPercentage() {
        BankAccount bankAccount = new BankAccount("123456789", new BigDecimal("1000.00"));
        BankAccountService bankAccountService = new BankAccountService(bankAccount);

        BigDecimal accumulatedInterest = bankAccountService.accumulateInterest(new BigDecimal("5.00"));

        assertEquals(new BigDecimal("50.0000"), accumulatedInterest);
        assertEquals(new BigDecimal("1050.0000"), bankAccount.getBalance());
    }

    @Test
    public void testAccumulateInterestPercentageGreaterThan100() {
        BankAccount bankAccount = new BankAccount("123456789", new BigDecimal("1000.00"));
        BankAccountService bankAccountService = new BankAccountService(bankAccount);

        BigDecimal accumulatedInterest = bankAccountService.accumulateInterest(new BigDecimal("150.00"));

        assertEquals(BigDecimal.ZERO, accumulatedInterest);
        assertEquals(new BigDecimal("1000.00"), bankAccount.getBalance());
    }
}
