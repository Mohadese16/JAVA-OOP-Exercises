public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void borrowBook(Library library, String title) {
        Book book = library.findBookByTitle(title);
        if (book != null && book.isAvailable()) {
            book.borrowBook();
            System.out.println(name + " borrowed: " + book.getTitle());
        } else {
            System.out.println("Book not available.");
        }
    }

    public void returnBook(Library library, String title) {
        Book book = library.findBookByTitle(title);
        if (book != null) {
            book.returnBook();
            System.out.println(name + " returned: " + book.getTitle());
        } else {
            System.out.println("Book not found.");
        }
    }
}
