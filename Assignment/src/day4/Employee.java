package day4;
public class Employee {
    private String name;
    private double salary;

    
    public Employee() {
        this.name = "Unknown";
        this.salary = 10000; 
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid input: Name cannot be empty.");
        } else {
            this.name = name;
            System.out.println("Name set to: " + this.name);
        }
    }

    public void setSalary(double s) {
        if (s >= 10000 && s <= 500000) {
            this.salary = s;
            System.out.println("Salary set to: " + this.salary);
        } else {
            System.out.println("Invalid input: Salary must be between 10,000 and 500,000.");
        }
    }

    public void raise(double percent) {
        if (percent > 0 && percent <= 100) {
            double increase = salary * (percent / 100);
            this.salary += increase;
            System.out.println("Raise of " + percent + "% applied. New Salary: " + this.salary);
        } else {
            System.out.println("Invalid input: Raise percentage must be between 0 and 100.");
        }
    }
    
    public double getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        Employee e = new Employee();

        System.out.println("--- Testing Name Validation ---");
        e.setName("");           
        e.setName("Alice");      

        System.out.println("\n--- Testing Salary Validation ---");
        e.setSalary(9000);       
        e.setSalary(600000);     
        e.setSalary(120000);     

        System.out.println("\n--- Testing Raise Logic ---");
        e.raise(10);             
        e.raise(200);            
        e.raise(-5);             
    }
}