package model;

public class CurrentAccount extends Account implements AccountOperations {

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void showAccountType() {
        System.out.println("Account Type: Current Account");
    }

    @Override
    public void withdraw(double amount) {
        double OVERDRAFT_LIMIT = 10000;
        if (this.balance - amount < -OVERDRAFT_LIMIT) {
            System.out.println("Withdrawal failed: Exceeds overdraft limit of ₹" + OVERDRAFT_LIMIT + ".");
        } else {
            super.withdraw(amount);
        }
    }
}
