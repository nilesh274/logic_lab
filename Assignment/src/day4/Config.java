package day4;
public class Config {
    public static final String APP_NAME = "MySuperApp";
    public static final String VERSION = "1.0.2";
    
    public static final int MAX_USERS = 5000;
    
    public static void main(String[] args) {
        System.out.println("Starting " + Config.APP_NAME);
        System.out.println("Version: " + Config.VERSION);
        System.out.println("User Limit: " + Config.MAX_USERS);
    }
}