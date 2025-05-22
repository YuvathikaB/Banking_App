package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Bank {
    protected String bankName;
    protected String branchName;
    protected static final String BANK_CODE_PREFIX = "BANK-";
    private static int bankCounter = 0;
    protected List<Account> accounts;

    public Bank(String bankName, String branchName) {
        this.bankName = bankName;
        this.branchName = branchName;
        this.accounts = new ArrayList<>();
        bankCounter++;
    }

    public abstract void openAccount(Account account);
    public abstract void displayBankInfo();

    public String generateBankCode() {
        return BANK_CODE_PREFIX + String.format("%03d", bankCounter);
    }

    public String getBankName() {
        return bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
