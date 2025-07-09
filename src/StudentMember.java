package src;

public class StudentMember extends LibraryMember {
    private static final int MAX_BORROW_LIMIT = 3;

    public StudentMember(String memberId, String name, String email) {
        super(memberId, name, email);
    }

    @Override
    public void borrowBook(Book book) {
        if (getBorrowedBooks().size() > MAX_BORROW_LIMIT) {
            try {
                throw new BorrowLimitExceededException(
                        "Student borrow limit exceeded (Max " + MAX_BORROW_LIMIT + " books)");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        if (book.getAvailableCopies() <= 0) {
            System.out.println("No copies of the book: " + book.getTitle() + " available");
            return;
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        this.addBorrowedBook(book);

        System.out.println(this.getName() + " (Student) borrowed the book: " + book.getTitle());
    }
}
