package day3;
import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String user = sc.nextLine();

        System.out.print("Password: ");
        String pwd = sc.nextLine();

        if (isValid(pwd, user)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Invalid Password. \nFeedback:\n" + feedback(pwd, user));
        }

        sc.close();
    }

    public static boolean isValid(String pwd, String user) {
        if (pwd.length() < 8 || pwd.length() > 20) return false;
        if (pwd.toLowerCase().contains(user.toLowerCase())) return false;
        
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        for (char c : pwd.toCharArray()) {
            if (c == ' ') return false;
            
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }else if (Character.isLowerCase(c)) {
                hasLower = true;
            }else if (Character.isDigit(c)) {
                hasDigit = true;
            }else if ("!@#$%^&*".indexOf(c) != -1) {
                hasSpecial = true;
            }
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public static String feedback(String pwd, String user) {
        StringBuilder sb = new StringBuilder();
        if (pwd.length() < 8) sb.append("- Too short (min 8 chars)\n");
        if (pwd.toLowerCase().contains(user.toLowerCase())) sb.append("- Must not contain username\n");
        
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        
        for (char c : pwd.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }

            if (Character.isLowerCase(c)) {
                hasLower = true;
            }

            if (Character.isDigit(c)) {
            hasDigit = true;
            }

            if ("!@#$%^&*".indexOf(c) != -1) {
                hasSpecial = true;
            }
        }
        if (!hasUpper) sb.append("- Add an uppercase letter\n");
        if (!hasDigit) sb.append("- Add a digit\n");
        if (!hasSpecial) sb.append("- Add a special character (!@#$%^&*)\n");
        return sb.toString();
    }
}