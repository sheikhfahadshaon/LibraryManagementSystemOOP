package src;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private static Library instance;

    private Map<String, Book> books;
    private Map<String, LibraryMember> members;

    private Library() {
        books = new HashMap<>();
        members = new HashMap<>();
    }

    public static Library getInstance() {
        if (instance == null)
            instance = new Library();

        return instance;
    }

    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            System.out.println("Book already exists");
        } else {
            books.put(book.getIsbn(), book);
            System.out.println("Book added successfully");
        }
    }

    public void addMember(LibraryMember member) {
        if (members.containsKey(member.getMemberId())) {
            System.out.println("Member already exists with this ID");
        } else {
            members.put(member.getMemberId(), member);
            System.out.println("Member create successfully !!");
        }
    }

    public List<Book> searchBooksByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Book> searchBooksByAuthor(String author) {
        return books.values().stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void borrowBook(String memberId, String isbn) {
        LibraryMember member = members.get(memberId);
        Book book = books.get(isbn);

        if (member == null) {
            System.out.println("Memeber not found: " + memberId);
            return;
        }

        if (book == null) {
            System.out.println("Book not found: " + isbn);
            return;
        }

        member.borrowBook(book);
    }

    public void returnBook(String memberId, String isbn) {
        LibraryMember member = members.get(memberId);
        Book book = books.get(isbn);

        if (member == null) {
            System.out.println("Memeber not found: " + memberId);
            return;
        }

        if (book == null) {
            System.out.println("Book not found: " + isbn);
            return;
        }

        if (!member.getBorrowedBooks().contains(book)) {
            System.out.println(member.getName() + " has not borrowed this book");
            return;
        }

        book.setAvailableCopies(book.getAvailableCopies() + 1);
        member.removeBorrowedBook(book);

        System.out.println(member.getName() + " has returned the book" + book.getTitle());
    }

    private class Statistics {
        public void printStatistics() {
            int totalBooks = books.size();
            int totalBorrowedBooks = members.values().stream()
                    .mapToInt(member -> member.getBorrowedBooks().size())
                    .sum();

            int totalMembers = members.size();

            System.out.println("----- Library Statistics -----");
            System.out.println("Total books in library: " + totalBooks);
            System.out.println("Total borrowed books: " + totalBorrowedBooks);
            System.out.println("Total members: " + totalMembers);
            System.out.println("--------------------------------");

        }
    }

    public void showStatistics() {
        Statistics stat = new Statistics();
        stat.printStatistics();
    }
}
