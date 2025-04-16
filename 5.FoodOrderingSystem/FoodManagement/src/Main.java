import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        Customer customer = new Customer(name);

        System.out.println("\nWelcome to the Restaurant, " + customer.getName() + "!");
        System.out.println("Here is the menu:");

        for (int i = 0; i < restaurant.getMenu().size(); i++) {
            System.out.println((i + 1) + ". " + restaurant.getMenu().get(i));
        }

        Order order = new Order();
        String choice;
        do {
            System.out.print("\nEnter item number to add to your order (or 'done' to finish): ");
            choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("done")) {
                try {
                    int itemIndex = Integer.parseInt(choice) - 1;
                    if (itemIndex >= 0 && itemIndex < restaurant.getMenu().size()) {
                        MenuItem item = restaurant.getMenu().get(itemIndex);
                        order.addItem(item);
                        System.out.println(item.getName() + " added to your order.");
                    } else {
                        System.out.println("Invalid item number.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }
        } while (!choice.equalsIgnoreCase("done"));

        if (order.getItems().isEmpty()) {
            System.out.println("No items in order. Exiting.");
            return;
        }

        System.out.println("\nOrder Summary:");
        for (MenuItem item : order.getItems()) {
            System.out.println("- " + item);
        }
        System.out.println("Total: $" + order.calculateTotal());

        restaurant.receiveOrder(order);

        System.out.print("\nEnter new order status (e.g. In Progress, Completed): ");
        String status = scanner.nextLine();
        restaurant.updateOrderStatus(order, status);

        System.out.println("\nFinal Order Status: " + order.getStatus());
        scanner.close();
    }
}