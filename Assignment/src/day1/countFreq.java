package day1;
import java.util.*;

public class countFreq {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        	
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(Character.isLetter(ch)){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }

        for(HashMap.Entry<Character, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        
        sc.close();
    }
}