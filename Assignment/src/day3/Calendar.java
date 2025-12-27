package day3;
import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter date (dd mm yyyy):");
        try {
            int d = sc.nextInt();
            int m = sc.nextInt();
            int y = sc.nextInt();

            if (isValidDate(d, m, y)) {
                System.out.println(dayOfWeek(d, m, y));
            } else {
                System.out.println("Invalid date entered.");
            }
        } catch (Exception e) {
            System.out.println("Error: Please enter integers only.");
        }

        sc.close();
    }

    public static String dayOfWeek(int d, int m, int y) {
        if (m < 3) {
            m += 12;
            y -= 1;
        }

        int q = d;              
        int K = y % 100;         
        int J = y / 100;         

        int h = (q + (13 * (m + 1) / 5) + K + (K / 4) + (J / 4) - (2 * J)) % 7;

        int index = (h + 7) % 7;

        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        
        return days[index];
    }

    public static boolean isValidDate(int d, int m, int y) {
        if (y < 1 || m < 1 || m > 12 || d < 1) return false;

        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if ((y % 400 == 0) || (y % 4 == 0 && y % 100 != 0)) {
            daysInMonth[2] = 29;
        }
        return d <= daysInMonth[m];
    }

}
