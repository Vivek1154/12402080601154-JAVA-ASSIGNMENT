import java.util.Scanner;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class Program8 {
    
    public static void processWithdrawal(double balance, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Available balance: $" + balance);
        }
        double newBalance = balance - amount;
        System.out.println("Success! Withdrew $" + amount + ". New balance: $" + newBalance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double accountBalance = 1000.00;

        System.out.println("Current Account Balance: $" + accountBalance);
        System.out.print("Enter the amount you wish to withdraw: ");

        try {
            double withdrawalAmount = scanner.nextDouble();
            processWithdrawal(accountBalance, withdrawalAmount);
        } catch (InsufficientFundsException e) {
            System.out.println("Declined: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please run the program again and enter a valid number.");
        } finally {
            System.out.println("Session closed.");
            scanner.close();
        }
    }
}

