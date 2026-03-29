import java.util.Scanner;

class BankAccount {
    private int accNo;
    private String name;
    private double balance;

    BankAccount(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else if (amount <= 0) {
            System.out.println("Invalid withdraw amount!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    void showBalance() {
        System.out.println("Current Balance: " + balance);
    }

    void display() {
        System.out.println("\nAccount Details:");
        System.out.println("Account No: " + accNo);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}

public class Program4 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

        // Create account
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Name: ");
        sc.nextLine(); // clear buffer
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount acc = new BankAccount(accNo, name, balance);

        int choice;

        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Inquiry");
            System.out.println("4. Display Account");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter withdraw amount: ");
                    double wit = sc.nextDouble();
                    acc.withdraw(wit);
                    break;

                case 3:
                    acc.showBalance();
                    break;

                case 4:
                    acc.display();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
        } // end try
    }
}
