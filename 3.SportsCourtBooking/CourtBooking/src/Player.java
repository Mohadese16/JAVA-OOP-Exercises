public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    // رزرو زمین توسط بازیکن
    public boolean bookCourt(Court court) {
        if (court.bookCourt(this)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    // لغو رزرو زمین
    public void cancelBooking(Court court) {
        if (!court.isAvailable()) {
            court.releaseCourt();
            System.out.println(name + " has canceled the booking of " + court.getSportType() + " court.");
        } else {
            System.out.println("No booking to cancel for " + court.getSportType() + " court.");
        }
    }
}
