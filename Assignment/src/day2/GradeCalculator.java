package day2;
import java.util.*;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for(int i = 0; i < 5; i++){
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for(int i = 0; i < 5; i++){
            sum += arr[i];
        }

        double percentage = ( (double) sum / 500.0) * 100;
        System.out.println("Percentage : " + percentage);
        
        if(percentage >= 90){
            System.out.println("Grade : " + " A");
        }else if (percentage >= 75){
            System.out.println("Grade : " + " B");
        }else if (percentage >= 60){
            System.out.println("Grade : " + " C");
        }else if (percentage >= 40){
            System.out.println("Grade : " + " D");
        }else if (percentage < 40){
            System.out.println("Grade : " + " F");
        }

        sc.close();
    }
}
