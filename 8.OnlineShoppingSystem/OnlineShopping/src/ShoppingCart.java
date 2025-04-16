import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        if (product.isAvailable()) {
            items.add(product);
            product.decreaseStock();
            System.out.println(product.getName() + " added to cart.");
        } else {
            System.out.println("Sorry, " + product.getName() + " is out of stock.");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void displayCartSummary() {
        System.out.println("\n--- Order Summary ---");
        for (Product item : items) {
            System.out.println("- " + item.getName() + " ($" + item.getPrice() + ")");
        }
        System.out.println("Total: $" + calculateTotal());
        System.out.println("Order placed successfully!\n");
    }

    public void clearCart() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
