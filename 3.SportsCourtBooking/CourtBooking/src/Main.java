import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Admin admin = new Admin();

    public static void main(String[] args) {
        initializeCourts();
        displayMenu();
    }

    // ابتدای برنامه: اضافه کردن زمین‌ها
    private static void initializeCourts() {
        Court basketballCourt = new Court("Basketball");
        Court tennisCourt = new Court("Tennis");
        Court footballCourt = new Court("Football");

        admin.addCourt(basketballCourt);
        admin.addCourt(tennisCourt);
        admin.addCourt(footballCourt);
    }

    // منوی اصلی که تمامی گزینه‌ها را نمایش می‌دهد
    private static void displayMenu() {
        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. View available courts");
            System.out.println("2. Book a court");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Admin - Add a court");
            System.out.println("5. Admin - Remove a court");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    admin.showAvailableCourts(); // نمایش زمین‌های موجود
                    break;

                case 2:
                    bookCourt(); // رزرو زمین
                    break;

                case 3:
                    cancelBooking(); // لغو رزرو زمین
                    break;

                case 4:
                    addCourt(); // اضافه کردن زمین جدید
                    break;

                case 5:
                    removeCourt(); // حذف زمین موجود
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // رزرو زمین توسط بازیکن
    private static void bookCourt() {
        System.out.print("\nEnter court type to book (Basketball, Tennis, Football): ");
        String courtType = scanner.nextLine();
        Court selectedCourt = findCourt(courtType);

        if (selectedCourt != null) {
            System.out.print("Enter your name: ");
            String playerName = scanner.nextLine();
            Player player = new Player(playerName);
            player.bookCourt(selectedCourt);
        } else {
            System.out.println("Invalid court type.");
        }
    }

    // لغو رزرو زمین توسط بازیکن
    private static void cancelBooking() {
        System.out.print("\nEnter court type to cancel reservation (Basketball, Tennis, Football): ");
        String cancelCourtType = scanner.nextLine();
        Court cancelCourt = findCourt(cancelCourtType);

        if (cancelCourt != null) {
            System.out.print("Enter your name to cancel reservation: ");
            String cancelPlayerName = scanner.nextLine();
            Player cancelPlayer = new Player(cancelPlayerName);
            cancelPlayer.cancelBooking(cancelCourt);
        } else {
            System.out.println("Invalid court type.");
        }
    }

    // اضافه کردن زمین جدید به سیستم
    private static void addCourt() {
        System.out.print("\nEnter court type to add (Basketball, Tennis, Football): ");
        String addCourtType = scanner.nextLine();
        Court newCourt = new Court(addCourtType);
        admin.addCourt(newCourt);
    }

    // حذف زمین موجود از سیستم
    private static void removeCourt() {
        System.out.print("\nEnter court type to remove (Basketball, Tennis, Football): ");
        String removeCourtType = scanner.nextLine();
        Court removeCourt = findCourt(removeCourtType);

        if (removeCourt != null) {
            admin.removeCourt(removeCourt);
        } else {
            System.out.println("Invalid court type.");
        }
    }

    // جستجوی زمین از طریق نام
    private static Court findCourt(String courtType) {
        for (Court court : admin.getCourts()) {
            if (court.getSportType().equalsIgnoreCase(courtType)) {
                return court;
            }
        }
        return null; // اگر زمین یافت نشد
    }
}
