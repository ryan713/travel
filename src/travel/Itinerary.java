package travel;

/**
 * Itinerary represents relationship between destination and package
 */
public class Itinerary {
    private String packageName;
    private String destinationName;

    public Itinerary(String packageName, String destinationName) {
        this.packageName = packageName;
        this.destinationName = destinationName;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    @Override
    public String toString() {
        return "Itinerary{" +
                "packageName='" + packageName + '\'' +
                ", destinationName='" + destinationName + '\'' +
                '}';
    }
}
