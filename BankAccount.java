import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String userId;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String userId) {
        this.userId = userId;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    public void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: INR " + amount);
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: INR " + amount);
        System.out.println("Deposit successful.");
    }

    public void transfer(String toUser, double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Transferred INR " + amount + " to " + toUser);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    public int getTransactionHistorySize()
    {
        return transactionHistory.size();
    }
}