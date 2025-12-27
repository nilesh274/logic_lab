package day2;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int i = 0;
        int j = str.length()-1;

        while(i < j){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }else{
                System.out.println("Not Palindrome");
                return;
            }
        }
        System.out.println("Palindrome");

        sc.close();
    }    
}
