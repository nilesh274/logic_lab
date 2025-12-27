package day3;
import java.util.*;

public class StreamAggregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Enter numbers (-999 to stop):");
        while (true) {
            if (!sc.hasNextInt()) {
                sc.next(); 
                continue;
            }
            int n = sc.nextInt();
            if (n == -999) break;
            list.add(n);
        }

        if (list.isEmpty()) return;

        int[] arr = list.stream().mapToInt(i -> i).toArray();
        Arrays.sort(arr);

        System.out.printf("Count=%d, Sum=%d, Min=%d, Max=%d, Avg=%.2f, Median=%.2f, Mode=%d\n",
            arr.length, getSum(arr), arr[0], arr[arr.length - 1], 
            getAverage(arr), getMedian(arr), getMode(arr));
    }

    public static int getSum(int[] a) {
        int s = 0; for (int x : a) s += x; return s;
    }

    public static double getAverage(int[] a) {
        return (double) getSum(a) / a.length;
    }

    public static double getMedian(int[] a) {
        int mid = a.length / 2;
        if (a.length % 2 == 0) {
            return (a[mid - 1] + a[mid]) / 2.0;
        }
        return a[mid];
    }

    public static int getMode(int[] a) {
        int mode = a[0], maxCount = 0;
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[j] == a[i]) {
                    count++;
                }
            }
            
            if (count > maxCount) { 
                maxCount = count; mode = a[i]; 
            }
        }
        return mode;
    }
}