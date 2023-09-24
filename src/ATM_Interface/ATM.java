package ATM_Interface;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Successfully withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Successfully deposited: $" + amount);
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }



    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(1000);
        ATM atm = new ATM(myAccount);

        Scanner scanner = new Scanner(System.in);
        int choice;
        double amount;

        while (true) {
            System.out.println("ATM Options:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    amount = scanner.nextDouble();
                    if (amount > 0) {
                        atm.withdraw(amount);
                    } else {
                        System.out.println("Please enter a valid amount.");
                    }
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    amount = scanner.nextDouble();
                    if (amount > 0) {
                        atm.deposit(amount);
                    } else {
                        System.out.println("Please enter a valid amount.");
                    }
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}