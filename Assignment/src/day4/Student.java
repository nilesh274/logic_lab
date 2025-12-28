package day4;
public class Student {
    private final int id;
    private String name;

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Student s = new Student(101);
        
        s.setName("Alice");
        System.out.println("Student Name: " + s.getName());
        System.out.println("Student ID: " + s.getId());

        
        s.setName("Alice Smith"); 
        System.out.println("Updated Name: " + s.getName());
    }   
}