package day4;
public class MathUtil {
    public static int max(int a, int b) {
        return (a >= b) ? a : b;
    }

    
    public static int clamp(int v, int min, int max) {
        if (v < min) {
            return min;
        } else if (v > max) {
            return max;
        } else {
            return v;
        }
    }


    public static void main(String[] args) {
        System.out.println("Max of 7 and 3: " + MathUtil.max(7, 3));      

        
        System.out.println("Clamp 15 to [0, 10]: " + MathUtil.clamp(15, 0, 10));  
        
        System.out.println("Clamp -3 to [-2, 5]: " + MathUtil.clamp(-3, -2, 5)); 
        
        System.out.println("Clamp 4 to [0, 10]: " + MathUtil.clamp(4, 0, 10));    
    }   
} 