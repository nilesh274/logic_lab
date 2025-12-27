package day2;
import java.util.*;

public class CntFreqWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();

        HashMap<String, Integer> map = new HashMap<>();

        int i = 0; 
        int j = i;

        while(i < n){
            while(i < n && str.charAt(i) == ' '){
                i++;
            }

            j = i;

            while(j < n && str.charAt(j) != ' '){
                j++;
            }

            if(i < j){
                String subStr = str.substring(i, j);
                map.put(subStr, map.getOrDefault(subStr, 0) + 1);
            }
            i = j;
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        sc.close();
    }    
}
