public class Court {
    private String sportType;
    private boolean isAvailable;
    private String bookedBy; // برای ذخیره اسم بازیکنی که زمین رو رزرو کرده

    public Court(String sportType) {
        this.sportType = sportType;
        this.isAvailable = true;
        this.bookedBy = null;
    }

    // رزرو زمین توسط بازیکن
    public boolean bookCourt(Player player) {
        if (isAvailable) {
            isAvailable = false;
            bookedBy = player.getName();
            System.out.println(player.getName() + " successfully booked a " + sportType + " court.");
            return true;
        }
        System.out.println("Court is already booked by " + bookedBy + "!");
        return false;
    }

    // آزاد کردن زمین
    public void releaseCourt() {
        isAvailable = true;
        bookedBy = null;
        System.out.println(sportType + " court has been released and is now available.");
    }

    public String getSportType() {
        return sportType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getBookedBy() {
        return bookedBy;
    }
}
