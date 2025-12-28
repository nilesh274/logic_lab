package day4;

public class AccessDemoTest {
	public static void main(String[] args) {
        AccessDemo demo = new AccessDemo();

        demo.publicMethod();      
        demo.protectedMethod();   
        demo.defaultMethod();     

//        demo.privateMethod();  
    }
}
