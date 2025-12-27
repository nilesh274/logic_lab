package day2;
import java.util.*;

public class FindSecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(largest < arr[i]){
                secondLargest = largest;
                largest = arr[i];

            }else if(secondLargest < arr[i] && largest > arr[i]){
                secondLargest = arr[i];
            }
        }

        System.out.println(secondLargest);
        sc.close();
    }   
}