package day3;
import java.util.Scanner;

public class RLESystem {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- RLE COMPRESSOR ---");
            System.out.println("1) Compress\n2) Decompress\n3) Exit");

            System.out.print("Choice: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter string to compress: ");
                String input = sc.nextLine();

                if (isAlpha(input)) {
                    System.out.println("Result: " + compress(input));
                } else {
                    System.out.println("Error: Use letters only.");
                }

            } else if (choice.equals("2")) {
                System.out.print("Enter string to decompress: ");
                String input = sc.nextLine();

                if (isValidEncoded(input)) {
                    System.out.println("Result: " + decompress(input));
                } else {
                    System.out.println("Error: Invalid format (e.g., a3b1).");
                }

            } else if (choice.equals("3")) {
                break;

            } else {
                continue;

            }
        }
    }

    public static String compress(String s) {
        if (s.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(s.charAt(i)).append(count);
        }
        return sb.toString();
    }

    public static String decompress(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            StringBuilder numStr = new StringBuilder();
            i++; 
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                numStr.append(s.charAt(i++));
            }
            i--;  
            
            int count = Integer.parseInt(numStr.toString());
            for (int j = 0; j < count; j++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static boolean isValidEncoded(String s) {
        if (s.length() < 2 || Character.isDigit(s.charAt(0))) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
             
            if (Character.isLetter(c)) {
                if (i + 1 >= s.length() || !Character.isDigit(s.charAt(i + 1))) return false;
            }
        }
        return true;
    }

    private static boolean isAlpha(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isLetter(c)) return false;
        }
        return !s.isEmpty();
    }
}