package travel;

public class Package {
    private String name;
    private int capacity;

    public Package(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Package{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
