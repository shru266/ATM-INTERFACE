import javax.swing.*;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            JOptionPane.showMessageDialog(null, "Deposit successful. New balance: $" + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            JOptionPane.showMessageDialog(null, "Withdrawal successful. New balance: $" + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid withdrawal amount or insufficient funds.");
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        String menu = "ATM Menu:\n" +
                "1. Withdraw\n" +
                "2. Deposit\n" +
                "3. Check Balance\n" +
                "4. Exit";
        JOptionPane.showMessageDialog(null, menu);
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                double withdrawAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter withdrawal amount: $"));
                bankAccount.withdraw(withdrawAmount);
                break;
            case 2:
                double depositAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter deposit amount: $"));
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Current balance: $" + bankAccount.getBalance());
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid option. Please choose a valid option.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); 
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();

            int option = Integer.parseInt(JOptionPane.showInputDialog("Choose an option (1-4):"));
            atm.processOption(option);
        }
    }
}
