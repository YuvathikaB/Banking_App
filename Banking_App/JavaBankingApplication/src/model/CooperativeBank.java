package model;

public class CooperativeBank extends Bank {

    public CooperativeBank(String bankName, String branchName) {
        super(bankName, branchName);
    }

    @Override
    public void openAccount(Account account) {
        if (account != null) {
            accounts.add(account);
            System.out.println("\nAccount opened successfully at " + bankName + ".");
            System.out.println("Account Number: " + account.getAccountNumber() + ", Holder: " + account.getHolderName());
            account.showAccountType();
        } else {
            System.out.println("Failed to open account: Account object is null.");
        }
    }

    @Override
    public void displayBankInfo() {
        System.out.println("\n--- Bank Details ---");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Branch: " + branchName);
        System.out.println("Bank Code: " + generateBankCode());
    }
}
