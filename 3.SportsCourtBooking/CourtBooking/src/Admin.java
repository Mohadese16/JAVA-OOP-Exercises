import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Court> courts;

    public Admin() {
        this.courts = new ArrayList<>();
    }

    // اضافه کردن زمین به سیستم
    public void addCourt(Court court) {
        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court.");
    }

    // حذف زمین از سیستم
    public void removeCourt(Court court) {
        if (court.isAvailable()) {
            courts.remove(court);
            System.out.println("Removed " + court.getSportType() + " court from the system.");
        } else {
            System.out.println("Cannot remove " + court.getSportType() + " court, it is currently booked.");
        }
    }

    // نمایش زمین‌های آزاد
    public void showAvailableCourts() {
        System.out.println("\n=== Available Courts ===");
        for (Court court : courts) {
            if (court.isAvailable()) {
                System.out.println("- " + court.getSportType() + " court is available.");
            }
        }
    }

    public List<Court> getCourts() {
        return courts;
    }
}
