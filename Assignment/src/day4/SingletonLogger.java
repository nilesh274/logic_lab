package day4;
public class SingletonLogger {
    private static SingletonLogger instance;
    private static final String PREFIX = "[APP] ";

    private SingletonLogger() {
        System.out.println("-> Singleton Instance Created (This should only happen once)");
    }

    public static SingletonLogger getInstance() {
        if (instance == null) {
            instance = new SingletonLogger();
        }
        return instance;
    }

    public void log(String msg) {
        System.out.println(PREFIX + msg);
    }

    public static void main(String[] args) {
        System.out.println("--- 1. Fetching First Reference ---");
        SingletonLogger l1 = SingletonLogger.getInstance();
        l1.log("System initialization started.");

        System.out.println("\n--- 2. Fetching Second Reference ---");
        SingletonLogger l2 = SingletonLogger.getInstance();
        l2.log("User logged in.");

        System.out.println("\n--- 3. Verifying Singleton Property ---");
        if (l1 == l2) {
            System.out.println("SUCCESS: l1 and l2 are the SAME object reference.");
        } else {
            System.out.println("FAILURE: Different objects were created.");
        }
    }
}