import java.util.Scanner;

public class ATM {
    private BankAccount currentAccount;
    private Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to the ATM Interface");
        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();
        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        // Dummy authentication
        if (userId.equals("user123") && pin.equals("1234")) {
            currentAccount = new BankAccount("user123");
            showMenu();
        } else {
            System.out.println("Invalid credentials. Exiting...");
        }
    }

    private void showMenu() {
        while (true) {
            System.out.println("\nATM MENU:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
            
                case 1:
    System.out.println("Current history size: " + currentAccount.getTransactionHistorySize());
    currentAccount.showTransactionHistory();
    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    currentAccount.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    currentAccount.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient ID: ");
                    sc.nextLine(); 
                    String recipient = sc.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = sc.nextDouble();
                    currentAccount.transfer(recipient, transferAmount);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}