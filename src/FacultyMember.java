package src;

public class FacultyMember extends LibraryMember {
    private static final int MAX_BORROW_LIMIT = 10;

    public FacultyMember(String memberID, String name, String email) {
        super(memberID, name, email);
    }

    @Override
    public void borrowBook(Book book) {
        if (getBorrowedBooks().size() >= MAX_BORROW_LIMIT) {
            try {
                throw new BorrowLimitExceededException(
                        "Faculty borrow limit exceeded (Max " + MAX_BORROW_LIMIT + " books)");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return;
        }

        if (book.getAvailableCopies() <= 0) {
            System.out.println("No copies of the book: " + book.getTitle() + " available");
            return;
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        this.addBorrowedBook(book);

        System.out.println(this.getName() + " (Faculty) borrowed the book: " + book.getTitle());
    }

}
