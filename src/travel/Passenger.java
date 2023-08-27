package travel;

public class Passenger {
	private String name;
    private int number;
    private Type type;
    private double balance;

    public enum Type {
        STANDARD,
        GOLD,
        PREMIUM
    }

    public Passenger(String name, int number, Type type, double balance) {
        this.name = name;
        this.number = number;
        this.type = type;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public Type getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double newBalance) {
        balance = newBalance;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", type=" + type +
                ", balance=" + balance +
                '}';
    }
}