package model;

public abstract class Account implements AccountOperations {
    protected String accountNumber;
    protected String holderName;
    protected double balance;

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public abstract void showAccountType();


    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: ₹" + amount + " to account " + accountNumber + ". New balance: ₹" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if (this.balance >= amount) {
                this.balance -= amount;
                System.out.println("Withdrew: ₹" + amount + " from account " + accountNumber + ". New balance: ₹" + balance);
            } else {
                System.out.println("Insufficient balance for withdrawal from account " + accountNumber + ".");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
}
