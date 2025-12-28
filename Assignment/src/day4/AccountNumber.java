package day4;
public class AccountNumber {
    private final String digits;

    public static boolean isValid(String s) {
        return s != null && s.matches("\\d{12}");
    }

    public AccountNumber(String s) {
        if (isValid(s)) {
            this.digits = s;
        } else {
            System.out.println("Invalid account number: '" + s + "'. Using default.");
            this.digits = "000000000000";
        }
    }

    public String getDigits() {
        return digits;
    }

    @Override
    public String toString() {
        return "Account Number: " + digits;
    }

    public static void main(String[] args) {
        
        System.out.println("--- Creating Valid Account ---");
        AccountNumber a = new AccountNumber("123456789012");
        System.out.println(a);
   
        System.out.println("\n--- Creating Invalid Account (Letters) ---");
        AccountNumber b = new AccountNumber("ABC");
        System.out.println(b);

        System.out.println("\n--- Creating Invalid Account (Length) ---");
        AccountNumber c = new AccountNumber("12345"); 
        System.out.println(c);
        
        System.out.println("\n--- Static Check Utility ---");
        System.out.println("Is '999999999999' valid? " + AccountNumber.isValid("999999999999"));
    }
}