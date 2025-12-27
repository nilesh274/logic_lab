package day1;
import java.util.Scanner;

public class reverseAStringII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int i = 0;
        int j = input.length()-1;

        StringBuilder st = new StringBuilder(input);

        while (i < j) {
            char a = input.charAt(i);
            char b = input.charAt(j);

            if (!Character.isLetter(a)) {
                i++;
            } 
            else if (!Character.isLetter(b)) {
                j--;
            } 
            else {
                st.setCharAt(i, b);
                st.setCharAt(j, a);
                i++;
                j--;
            }
        }

        System.out.print(st.toString());
        sc.close();
    }
}
