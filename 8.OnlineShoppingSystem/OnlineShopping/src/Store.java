import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> inventory;

    public Store() {
        this.inventory = new ArrayList<>();
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public List<Product> getProducts() {
        return inventory;
    }

    public void displayProducts() {
        System.out.println("\n=== Available Products ===");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.println(i + ": " + p.getName() + " - $" + p.getPrice() + " (Stock: " + p.getStock() + ")");
        }
    }
}
