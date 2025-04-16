public class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public void decreaseStock() {
        if (stock > 0) {
            stock--;
        }
    }
}
