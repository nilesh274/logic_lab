package day4;
public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }


    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Error: Insufficient funds or invalid amount.");
        }
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    protected void applyFee(double fee) {
        if (fee > 0 && fee <= balance) {
            balance -= fee;
            System.out.println("Fee applied: " + fee);
        }
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Sarthak", 1000.0);

        System.out.println("Owner: " + acc.getOwner());
        System.out.println("Initial Balance: " + acc.getBalance());

        acc.deposit(500);       
        acc.withdraw(300);      
        acc.withdraw(5000);     

       
        acc.applyFee(10.0);

        System.out.println("Final Balance: " + acc.getBalance()); 
    }
}