package day2;
import java.util.*;

public class ReverseWords {

    public static String reverse(String input){
        StringBuilder st = new StringBuilder(input);
        int i = 0;
        int j = input.length()-1;

        while(i < j){
            char a = input.charAt(i);
            char b = input.charAt(j);

            st.setCharAt(i, b);
            st.setCharAt(j, a);

            i++;
            j--;
        }
        return st.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        String ans = "";

        int i = 0; 
        int j = i;

        while(i < n){
            while(i < n && str.charAt(i) == ' '){
                ans += " ";
                i++;
            }

            j = i;
            while(j < n && str.charAt(j) != ' '){
                j++;
            }
            if(i < j){
                ans = ans + reverse(str.substring(i, j));
                i = j;
            }
        }

        System.out.println(ans);
        sc.close();
    }
}
