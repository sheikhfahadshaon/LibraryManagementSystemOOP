import java.util.List;

import src.Book;
import src.Library;
import src.LibraryMember;
import src.LibraryMemberFactory;

public class Main {
    public static void main(String[] args) {
        // Get the singleton Library instance
        Library library = Library.getInstance();

        // --- Add Books ---
        Book book1 = new Book("ISBN001", "Java Programming", "John Doe", 2020, 5);
        Book book2 = new Book("ISBN002", "Data Structures", "Alice Smith", 2018, 3);
        Book book3 = new Book("ISBN003", "Algorithms Unlocked", "Thomas Cormen", 2016, 2);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println();

        // --- Add Members using Factory ---
        LibraryMember member1 = LibraryMemberFactory.createMember("student", "S01", "Sam Student", "sam@student.com");
        LibraryMember member2 = LibraryMemberFactory.createMember("faculty", "F01", "Fiona Faculty",
                "fiona@faculty.com");

        library.addMember(member1);
        library.addMember(member2);

        System.out.println();

        // --- Borrow Books ---
        library.borrowBook("S01", "ISBN001");
        library.borrowBook("S01", "ISBN002");
        library.borrowBook("S01", "ISBN003");
        library.borrowBook("S01", "ISBN002"); // Should exceed limit

        System.out.println();

        library.borrowBook("F01", "ISBN001");
        library.borrowBook("F01", "ISBN002");

        System.out.println();

        // --- Search Books ---
        System.out.println("Searching for books with 'Java':");
        List<Book> javaBooks = library.searchBooksByTitle("Java");
        javaBooks.forEach(Book::displayInfo);

        System.out.println();

        System.out.println("Searching for books by 'Alice':");
        List<Book> aliceBooks = library.searchBooksByAuthor("Alice");
        aliceBooks.forEach(Book::displayInfo);

        System.out.println();

        // --- Return Books ---
        library.returnBook("S01", "ISBN002");
        library.returnBook("F01", "ISBN001");

        System.out.println();

        // --- Show Library Statistics ---
        library.showStatistics();

        System.out.println();

        // Print all members for verification
        System.out.println("All Members:");
        System.out.println(member1);
        System.out.println(member2);
    }
}
