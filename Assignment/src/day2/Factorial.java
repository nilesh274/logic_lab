package day2;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if (n < 0) {
            System.out.println("Factorial is not possible");
        } else {
            long result = factorial(n);
            System.out.println(result);
        }

        sc.close();
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        
        return n * factorial(n - 1);
    }
}