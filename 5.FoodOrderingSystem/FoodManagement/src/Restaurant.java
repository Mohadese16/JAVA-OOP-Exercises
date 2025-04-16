import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Order> orders;
    private List<MenuItem> menu;

    public Restaurant() {
        this.orders = new ArrayList<>();
        this.menu = new ArrayList<>();
        menu.add(new MenuItem("Burger", 6.97));
        menu.add(new MenuItem("Pizza", 7.99));
        menu.add(new MenuItem("Fries", 3.98));
        menu.add(new MenuItem("Soda", 1.59));
    }

    public void receiveOrder(Order order) {
        orders.add(order);
        System.out.println("New order received. Status: " + order.getStatus());
    }

    public void updateOrderStatus(Order order, String status) {
        order.updateStatus(status);
        System.out.println("Order status updated to: " + status);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }
}