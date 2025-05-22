package model;

public class SavingsAccount extends Account implements AccountOperations {

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void showAccountType() {
        System.out.println("Account Type: Savings Account");
    }

    @Override
    public void withdraw(double amount) {
        double MIN_BALANCE = 500;
        if (this.balance - amount < MIN_BALANCE) {
            System.out.println("Withdrawal failed: Minimum balance of ₹" + MIN_BALANCE + " must be maintained.");
        } else {
            super.withdraw(amount);
        }
    }
}
