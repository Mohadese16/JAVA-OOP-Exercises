public class Admin {
    private Library library;

    public Admin(Library library) {
        this.library = library;
    }

    public void addBook(Book book) {
        library.addBook(book);
    }

    public void removeBook(Book book) {
        library.removeBook(book);
    }

    public void listBooks() {
        library.listBooks();
    }
}
