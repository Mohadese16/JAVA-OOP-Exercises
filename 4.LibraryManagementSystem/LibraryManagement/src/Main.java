import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // ایجاد کتابخانه و مدیر
        Library library = new Library();
        Admin admin = new Admin(library);

        // ایجاد چند کتاب و اضافه کردن آن‌ها به کتابخانه
        Book book1 = new Book("5050", "Lee");
        Book book2 = new Book("2020", "Mike");
        Book book3 = new Book("4030", "Sara");
        admin.addBook(book1);
        admin.addBook(book2);
        admin.addBook(book3);

        // ایجاد کاربر
        User user = new User("Tina");

        // رابط کاربری ساده برای تعامل
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. List Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Admin - Add Book");
            System.out.println("5. Admin - Remove Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // clear the buffer

            switch (choice) {
                case 1:
                    admin.listBooks();
                    break;
                case 2:
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    user.borrowBook(library, borrowTitle);
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    user.returnBook(library, returnTitle);
                    break;
                case 4:
                    System.out.print("Enter book title to add: ");
                    String addTitle = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String addAuthor = scanner.nextLine();
                    Book newBook = new Book(addTitle, addAuthor);
                    admin.addBook(newBook);
                    break;
                case 5:
                    System.out.print("Enter book title to remove: ");
                    String removeTitle = scanner.nextLine();
                    Book bookToRemove = library.findBookByTitle(removeTitle);
                    if (bookToRemove != null) {
                        admin.removeBook(bookToRemove);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
