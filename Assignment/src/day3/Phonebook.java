package day3;
import java.util.Scanner;

public class Phonebook {
    static String[] names = new String[100];
    static String[] phones = new String[100];
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String line = sc.nextLine();
            
            if (line.trim().isEmpty()) continue;
            
            String[] parts = line.split(" ");
            String cmd = parts[0].toUpperCase();

            if (cmd.equals("EXIT")) break;
            
            switch (cmd) {
                case "ADD":
                    if (parts.length >= 3 && isValidPhone(parts[2])) {
                        names[count] = parts[1];
                        phones[count++] = parts[2];
                        System.out.println("Contact Added.");
                    } else {
                        System.out.println("Invalid Phone (must be 10 digits).");
                    }

                    break;
                case "LIST":
                    for (int i = 0; i < count; i++) {
                        System.out.println(names[i] + "(" + phones[i] + ")");
                    }

                    break;
                case "FIND":
                    if (parts.length < 2) continue;
                    for (int i = 0; i < count; i++) {
                        if (names[i].toLowerCase().contains(parts[1].toLowerCase())) {
                            System.out.println("Found: " + names[i] + "(" + phones[i] + ")");
                        }
                    }

                    break;
                case "DEL":
                    for (int i = 0; i < count; i++) {
                        if (names[i].equalsIgnoreCase(parts[1])) {
                            for (int j = i; j < count - 1; j++) {
                                names[j] = names[j+1]; phones[j] = phones[j+1];
                            }
                            count--;
                            System.out.println("Deleted.");
                            break;
                        }
                    }
                    
                    break;
            }
            sc.close();
        }
    }

    public static boolean isValidPhone(String p) {
        if (p.length() != 10) return false;
        for (char c : p.toCharArray()) if (!Character.isDigit(c)) return false;
        return true;
    }
}