package day4;
public class Temperature {
    private final double celsius;
    
    public Temperature(double celsius) {
        this.celsius = celsius;
    }
    
    public double toFahrenheit() {
        return (this.celsius * 9.0 / 5.0) + 32;
    }

    public Temperature withCelsius(double c) {
        return new Temperature(c);
    }

    public double getCelsius() {
        return celsius;
    }
    
    public static void main(String[] args) {
        Temperature t = new Temperature(25.0);

        System.out.println(t.toFahrenheit()); 

        Temperature t2 = t.withCelsius(30.0);
        
        System.out.println(t.getCelsius());  
        System.out.println(t2.getCelsius()); 
    }
}