package day4;

public class user {
	
	public String name;
	public final int id;
	
	public user(String name) {
		IDGenerator IDGenerator = new IDGenerator();
		this.name = name;
		this.id = IDGenerator.nextId();
	}
	
	public int getId() {
		return id;
	}

	public static void main(String[] args) {
		user u1 = new user("A");
		user u2 = new user("B");
		user u3 = new user("C");
		user u4 = new user("D");
		System.out.println(u1.getId()); 
		System.out.println(u2.getId());
		System.out.println(u3.getId()); 
		System.out.println(u4.getId());
	}
}
