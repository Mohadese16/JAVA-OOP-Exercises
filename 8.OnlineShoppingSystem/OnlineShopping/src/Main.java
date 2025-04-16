import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();

        store.addProduct(new Product("Laptop", 432.98, 3));
        store.addProduct(new Product("phone", 498.97, 6));
        store.addProduct(new Product("mouse", 73.67, 10));

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        Customer customer = new Customer(name);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. View products");
            System.out.println("2. Add product to cart");
            System.out.println("3. Checkout");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    store.displayProducts();
                    break;
                case 2:
                    store.displayProducts();
                    System.out.print("Enter product number to add to cart: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < store.getProducts().size()) {
                        customer.addToCart(store.getProducts().get(index));
                    } else {
                        System.out.println("Invalid product number.");
                    }
                    break;
                case 3:
                    customer.placeOrder();
                    break;
                case 0:
                    System.out.println("Thanks for visiting our shop. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
