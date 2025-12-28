package day4;
public class Counter {
    private int value;
    public static int instances = 0;

    public Counter() {
        this.value = 0; 
        instances++;    
    }

    public void increment() {
        value++;
    }

    public void decrement() {
        value--;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        Counter a = new Counter();
        Counter b = new Counter();
        Counter c = new Counter();

        a.increment();
        a.increment();

        System.out.println("Counter A value: " + a.getValue()); 
        System.out.println("Counter B value: " + b.getValue()); 
        
        System.out.println("Total instances created: " + Counter.instances); 
    }
}