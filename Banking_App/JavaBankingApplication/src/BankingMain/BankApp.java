package BankingMain;

import model.*;
import java.util.Scanner;

public class BankApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        NationalizedBank sbiBank = new NationalizedBank("SBI", "CG");
        CooperativeBank axisCoopBank = new CooperativeBank("Axis Cooperative Bank", "Delhi NCR");

        int choice;
        do {
            System.out.println("\n--- Welcome to the Banking Application ---");
            System.out.println("1. Open an Account");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Display Bank and Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    openAccount(sbiBank, axisCoopBank);
                    break;
                case 2:
                    performTransaction(sbiBank, axisCoopBank, "deposit");
                    break;
                case 3:
                    performTransaction(sbiBank, axisCoopBank, "withdraw");
                    break;
                case 4:
                    displayBankAndAccountDetails(sbiBank, axisCoopBank);
                    break;
                case 5:
                    System.out.println("Exiting Banking Application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void openAccount(NationalizedBank sbiBank, CooperativeBank axisCoopBank) {
        System.out.println("\n--- Open an Account ---");
        System.out.println("Select Bank:");
        System.out.println("1. SBI (Nationalized Bank)");
        System.out.println("2. Axis Cooperative Bank (Cooperative Bank)");
        System.out.print("Enter bank choice (1 or 2): ");
        int bankChoice = scanner.nextInt();
        scanner.nextLine();

        Bank selectedBank = null;
        if (bankChoice == 1) {
            selectedBank = sbiBank;
        } else if (bankChoice == 2) {
            selectedBank = axisCoopBank;
        } else {
            System.out.println("Invalid bank choice.");
            return;
        }

        System.out.println("Select Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.println("3. Loan Account");
        System.out.print("Enter account type choice (1, 2, or 3): ");
        int accountTypeChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String holderName = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine();

        String accountNumber = generateUniqueAccountNumber(selectedBank);
        Account newAccount = null;

        switch (accountTypeChoice) {
            case 1:
                newAccount = new SavingsAccount(accountNumber, holderName, initialBalance);
                break;
            case 2:
                newAccount = new CurrentAccount(accountNumber, holderName, initialBalance);
                break;
            case 3:
                newAccount = new LoanAccount(accountNumber, holderName, initialBalance);
                break;
            default:
                System.out.println("Invalid account type choice.");
                return;
        }

        if (newAccount != null) {
            selectedBank.openAccount(newAccount);
        }
    }

    private static String generateUniqueAccountNumber(Bank bank) {
        int accountCount = bank.getAccounts().size() + 1;
        return "ACC" + String.format("%03d", accountCount);
    }

    private static void performTransaction(NationalizedBank sbiBank, CooperativeBank axisCoopBank, String type) {
        System.out.println("\n--- " + (type.equals("deposit") ? "Deposit" : "Withdraw") + " Amount ---");
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.nextLine();

        Account targetAccount = null;
        targetAccount = sbiBank.findAccount(accNumber);
        if (targetAccount == null) {
            targetAccount = axisCoopBank.findAccount(accNumber);
        }

        if (targetAccount == null) {
            System.out.println("Account not found with number: " + accNumber);
            return;
        }

        System.out.print("Enter Amount to " + type + ": ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (type.equals("deposit")) {
            targetAccount.deposit(amount);
        } else {
            targetAccount.withdraw(amount);
        }
    }

    private static void displayBankAndAccountDetails(NationalizedBank sbiBank, CooperativeBank axisCoopBank) {
        System.out.println("\n--- Display Bank and Account Details ---");

        sbiBank.displayBankInfo();
        if (!sbiBank.getAccounts().isEmpty()) {
            System.out.println("\n--- Accounts in " + sbiBank.getBankName() + " ---");
            for (Account account : sbiBank.getAccounts()) {
                System.out.println("\n--- Account Details ---");
                account.showAccountType();
                System.out.println("Holder: " + account.getHolderName());
                System.out.println("Account Number: " + account.getAccountNumber());
                System.out.println("Balance: ₹" + String.format("%.2f", account.getBalance()));
            }
        } else {
            System.out.println("No accounts opened in " + sbiBank.getBankName() + " yet.");
        }

        axisCoopBank.displayBankInfo();
        if (!axisCoopBank.getAccounts().isEmpty()) {
            System.out.println("\n--- Accounts in " + axisCoopBank.getBankName() + " ---");
            for (Account account : axisCoopBank.getAccounts()) {
                System.out.println("\n--- Account Details ---");
                account.showAccountType(); // [cite: 9]
                System.out.println("Holder: " + account.getHolderName());
                System.out.println("Account Number: " + account.getAccountNumber());
                System.out.println("Balance: ₹" + String.format("%.2f", account.getBalance()));
            }
        } else {
            System.out.println("No accounts opened in " + axisCoopBank.getBankName() + " yet.");
        }
    }
}
