package day3;
import java.util.Scanner;

public class MiniATM {
    static double balance = 0.0;
    static int pin = 1234;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MINI ATM ---");
            System.out.println("1) Deposit\n2) Withdraw\n3) Check Balance\n4) Change PIN\n5) Exit");
            System.out.print("Enter option: ");
            
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                deposit();
            } else if (choice.equals("2")) {
                withdraw();
            } else if (choice.equals("3")) {
                printBalance();
            } else if (choice.equals("4")) {
                changePin();
            } else if (choice.equals("5")) {
                System.out.println("Exiting. Thank you!");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
                continue;
            }
        }
    }

    public static void deposit() {
        System.out.print("Amount: ");
        double amount = Double.parseDouble(sc.nextLine());
        if (amount > 0) {
            balance += amount; 
            System.out.printf("Deposited. Balance: %.2f\n", balance);
        } else {
            System.out.println("Error: Cannot deposit negative or zero amounts.");
        }
    }

    public static void withdraw() {
        if (!verifyPin()) return;

        System.out.print("Amount: ");
        double amount = Double.parseDouble(sc.nextLine());

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrawn. Balance: %.2f\n", balance);
        } else if (amount > balance) {
            System.out.println("Error: Insufficient funds.");
        } else {
            System.out.println("Error: Invalid withdrawal amount.");
        }
    }

    public static void printBalance() {
        System.out.printf("Current Balance: %.2f\n", balance);
    }

    public static void changePin() {
        if (!verifyPin()) return;

        System.out.print("Enter new 4-digit PIN: ");
        int newPin = Integer.parseInt(sc.nextLine());
        
        if (newPin >= 1000 && newPin <= 9999) {
            pin = newPin;
            System.out.println("PIN successfully updated.");
        } else {
            System.out.println("Error: PIN must be 4 digits.");
        }
    }

    public static boolean verifyPin() {
        System.out.print("Enter PIN: ");
        int entry = Integer.parseInt(sc.nextLine());
        if (entry == pin) {
            return true;
        } else {
            System.out.println("Error: Incorrect PIN.");
            return false;
        }
    }
}