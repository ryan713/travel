package travel;

/**
 * Booking represent relationship between passengers and packages
 */
public class Booking {
    private String passengerName;
    private String packageName;

    public Booking(String passengerName, String packageName) {
        this.passengerName = passengerName;
        this.packageName = packageName;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getPackageName() {
        return packageName;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "passengerName='" + passengerName + '\'' +
                ", packageName='" + packageName + '\'' +
                '}';
    }
}
