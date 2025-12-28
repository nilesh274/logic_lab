package day4;
public class LibraryBook {
    private String title;
    private String author;
    private boolean issued;

    public static int totalBooks = 0;

    public LibraryBook(String title, String author) {
        this.title = title;
        this.author = author;
        this.issued = false; 
        totalBooks++;        
    }

    public void issue() {
        if (issued) {
            System.out.println("Error: The book '" + title + "' is already issued.");
        } else {
            issued = true;
            System.out.println("Success: You have issued '" + title + "'.");
        }
    }

    public void returnBook() {
        if (!issued) {
            System.out.println("Error: The book '" + title + "' is not currently issued.");
        } else {
            issued = false;
            System.out.println("Success: You have returned '" + title + "'.");
        }
    }

    public boolean isIssued() {
        return issued;
    }

    public static void main(String[] args) {
        System.out.println("--- Library System Started ---");
        
        LibraryBook b1 = new LibraryBook("1984", "George Orwell");
        System.out.println("Total Books in Library: " + LibraryBook.totalBooks); 

        LibraryBook b2 = new LibraryBook("The Hobbit", "J.R.R. Tolkien");
        System.out.println("Total Books in Library: " + LibraryBook.totalBooks); 

        System.out.println("\n--- Testing Issue/Return Logic on '1984' ---");
        b1.issue();      
        b1.issue();      
        b1.returnBook(); 
        b1.returnBook(); 
    }
}