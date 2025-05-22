package model;

public class LoanAccount extends Account implements AccountOperations {

    public LoanAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void showAccountType() {
        System.out.println("Account Type: Loan Account");
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Loan Repayment: ₹" + amount + " to account " + accountNumber + ". New loan balance: ₹" + balance);
        } else {
            System.out.println("Repayment amount must be positive.");
        }
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawal not applicable for Loan Accounts. Please consider taking a new loan or disbursal.");
    }
}
