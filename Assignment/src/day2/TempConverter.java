package day2;
import java.util.*;

public class TempConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Temperature Converter");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter your choice (1 or 2): ");
        
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter temperature in Celsius: ");
            double tempCel = sc.nextDouble();
            double tempFah = (tempCel * 9 / 5) + 32;
            System.out.println("Result: " + tempFah + "°F");
            
        } else if (choice == 2) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double tempFah1 = sc.nextDouble();
            double tempCel1 = (tempFah1 - 32) * 5 / 9;
            System.out.println("Result: " + tempCel1 + "°C");
            
        } else {
            System.out.println("Invalid choice! Please restart and enter 1 or 2.");
        }

        sc.close();
    }    
}
