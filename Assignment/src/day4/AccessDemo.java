package day4;
public class AccessDemo {
    
    public void publicMethod() {
        System.out.println("Public method called.");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called.");
    }

    void defaultMethod() {
        System.out.println("Default method called.");
    }

    private void privateMethod() {
        System.out.println("Private method called.");
    }
}