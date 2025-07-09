package src;
/*
Create abstract class LibraryMember:
-> memberId (String)
-> name (String)
-> email (String)
-> borrowedBooks (List<Book>)

=> Abstract method: borrowBook(Book book)
=> Constructor
=> Getters and setters
=> toString()
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class LibraryMember {
    private String memberId;
    private String name;
    private String email;
    private List<Book> borrowedBooks = new ArrayList<>();

    public LibraryMember(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
    }

    public abstract void borrowBook(Book book);

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableList(borrowedBooks);
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "LibraryMember [memberId=" + memberId + ", name=" + name + ", email=" + email + ", borrowedBooks="
                + borrowedBooks + "]";
    }
}
