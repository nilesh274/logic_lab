package day1;
import java.util.*;

public class primeORNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if(input < 2) {
            System.out.println(input + " " + "is not Prime Number");
            return;
        }

        for(int i = 2; i <= Math.sqrt(input); i++){
            if(input % i == 0) {
                System.out.println(input + " " + "is not Prime Number");
                return;
            }
        }

        System.out.println(input + " " + "is an Prime Number");
        sc.close();
    }    
}
