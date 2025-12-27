package day3;
import java.util.Scanner;

public class Gradebook {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter number of students: ");
        int n;
        
        try {
            n = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input. Exiting...");
            return;
        }

        if (n <= 0) {
            System.out.println("Invalid number of students.");
            return;
        }

        String[] names = new String[n];
        int[] grades = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name for student " + (i + 1) + ": ");
            String name = sc.nextLine();
            while (name.trim().isEmpty()) {
                System.out.print("Name cannot be empty. Re-enter: ");
                name = sc.nextLine();
            }
            names[i] = name;

            System.out.print("Enter grade for " + names[i] + ": ");
            int grade = Integer.parseInt(sc.nextLine());
            while (grade < 0 || grade > 100) {
                System.out.print("Invalid grade (0-100). Re-enter: ");
                grade = Integer.parseInt(sc.nextLine());
            }
            grades[i] = grade;
        }

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1) Print all");
            System.out.println("2) Print topper");
            System.out.println("3) Class average");
            System.out.println("4) Search by name");
            System.out.println("5) Curve grades (+5)");
            System.out.println("6) Exit");
            System.out.print("Choice: ");

            String choice = sc.nextLine();

            if (choice.equals("1")) {
                printAll(names, grades);
            } else if (choice.equals("2")) {
                printTopper(names, grades);
            } else if (choice.equals("3")) {
                printAverage(grades);
            } else if (choice.equals("4")) {
                searchStudent(names, grades);
            } else if (choice.equals("5")) {
                applyCurve(grades);
            } else if (choice.equals("6")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
                continue;
            }
        }
    }

    public static void printAll(String[] names, int[] grades) {
        System.out.print("All: ");
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + "(" + grades[i] + ")" + (i == names.length - 1 ? "" : ", "));
        }
        System.out.println();
    }

    public static void printTopper(String[] names, int[] grades) {
        int maxIndex = 0;
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > grades[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println("Topper: " + names[maxIndex] + "(" + grades[maxIndex] + ")");
    }

    public static void printAverage(int[] grades) {
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        double avg = sum / grades.length;
        System.out.printf("Average: %.2f\n", avg);
    }
    
    public static void searchStudent(String[] names, int[] grades) {
        System.out.print("Enter name to search: ");
        String query = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(query)) {
                String upperName = Character.toUpperCase(names[i].charAt(0)) + names[i].substring(1);
                System.out.println("Found: " + upperName + "(" + grades[i] + ")");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Student not found.");
    }
    
    public static void applyCurve(int[] grades) {
        for (int i = 0; i < grades.length; i++) {
            grades[i] = (grades[i] + 5 > 100) ? 100 : grades[i] + 5;
        }
        System.out.println("Grades curved by +5.");
    }
}