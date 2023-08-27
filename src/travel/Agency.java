package travel;

import java.util.ArrayList;
import java.util.List;
import travel.Passenger.Type;

/**
 * Here we combine all classes to answer user queries
 */
public class Agency {
    private List<Package> packages;
    private List<Booking> bookings;
    private List<SignUp> signUps;
    private List<Destination> destinations;
    private List<Activity> activities;
    private List<Itinerary> itineraries;
    private List<Passenger> passengers;

    public Agency() {
        packages = new ArrayList<>();
        bookings = new ArrayList<>();
        signUps = new ArrayList<>();
        destinations = new ArrayList<>();
        activities = new ArrayList<>();
        itineraries = new ArrayList<>();
        passengers = new ArrayList<>();
    }

    public void addPackage(Package travelPackage) {
        packages.add(travelPackage);
    }

    public void addBooking(Booking booking) {
    	Package travelPackage = packages.stream()
    			.filter(p -> p.getName() == booking.getPackageName())
    			.findFirst().get();
    	
    	if (travelPackage.getCapacity() == 0) {
    		System.out.println("Insifficient capacity");    		
    		return;
    	}
    	
        bookings.add(booking);
    }

    public void addSignUp(SignUp signUp) {
    	Passenger passenger = passengers.stream()
    			.filter(p -> p.getNumber() == signUp.getPassengerNumber())
    			.findFirst().get();
    	
    	Activity activity = activities.stream()
    			.filter(a -> a.getName() == signUp.getActivityName())
    			.findFirst().get();
    	
    	
    	if (passenger.getType() != Type.PREMIUM && passenger.getBalance() < activity.getCost()) {
    		System.out.println("Insifficient balance");    		
    		return;
    	}
    	
    	if (activity.getCapacity() == 0) {
    		System.out.println("Insifficient capacity");    		
    		return;
    	}
    		
    	
    	if (passenger.getType() == Type.STANDARD)
    		passenger.setBalance(passenger.getBalance() - activity.getCost());
    	
    	if (passenger.getType() == Type.GOLD)
    		passenger.setBalance(passenger.getBalance() - 0.9 * activity.getCost());
    	
    	activity.setCapacity(activity.getCapacity() - 1);

        signUps.add(signUp);
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void addItinerary(Itinerary itinerary) {
        itineraries.add(itinerary);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public List<Package> getPackages() {
        return packages;
    }
    
    public List<Passenger> getPassengers() {
        return passengers;
    }
    
    public List<Activity> getActivities() {
        return activities;
    }

    public List<Booking> getBookingsByPackage(String travelPackageName) {
        return bookings.stream().filter(b -> b.getPackageName() == travelPackageName).toList();
    }

    public List<SignUp> getSignUpsByActivity(String activityName) {
        return signUps.stream().filter(s -> s.getActivityName() == activityName).toList();
    }
    
    public List<SignUp> getSignUpsByPassenger(int passengerNumber) {
    	return signUps.stream().filter(s -> s.getPassengerNumber() == passengerNumber).toList();
    }

    public List<Activity> getActivitiesByDestination(String destinationName) {
        return activities.stream().filter(a -> a.getDestination().getName() == destinationName).toList();
    }

    public List<Itinerary> getItinerariesByPackage(String travelPackageName) {
        return itineraries.stream().filter(i -> i.getPackageName() == travelPackageName).toList();
    }
    
    public List<Itinerary> getItinerariesByDestination(String destinationName) {
        return itineraries.stream().filter(i -> i.getDestinationName() == destinationName).toList();
    }

    public static void main(String[] args) {
        Agency agency = new Agency();

        Package package1 = new Package("Beach Getaway", 50);
        agency.addPackage(package1);

        Package package2 = new Package("Mountain Retreat", 30);
        agency.addPackage(package2);

        Destination destination1 = new Destination("Beach Resort");
        agency.addDestination(destination1);

        Destination destination2 = new Destination("Mountain Lodge");
        agency.addDestination(destination2);
        
        Destination destination3 = new Destination("Rishikesh");
        agency.addDestination(destination3);

        Activity activity1 = new Activity("Snorkeling", "Explore underwater life", 50.0, 5, destination1);
        agency.addActivity(activity1);

        Activity activity2 = new Activity("Hiking", "Scenic mountain trail", 30.0, 10, destination2);
        agency.addActivity(activity2);
        
        Activity activity3 = new Activity("Rafting", "River rafting", 20.0, 10, destination3);
        agency.addActivity(activity2);

        Itinerary itinerary1 = new Itinerary("Beach Getaway", "Beach Resort");
        agency.addItinerary(itinerary1);

        Itinerary itinerary2 = new Itinerary("Mountain Retreat", "Mountain Lodge");
        agency.addItinerary(itinerary2);
        
        Itinerary itinerary3 = new Itinerary("Mountain Retreat", "Rishikesh");
        agency.addItinerary(itinerary3);

        Passenger passenger1 = new Passenger("John Doe", 101, Passenger.Type.GOLD, 500.0);
        agency.addPassenger(passenger1);

        Passenger passenger2 = new Passenger("Jane Smith", 102, Passenger.Type.PREMIUM, 1000.0);
        agency.addPassenger(passenger2);
        
        Booking booking1 = new Booking("John Doe", "Beach Getaway");
        agency.addBooking(booking1);

        Booking booking2 = new Booking("Jane Smith", "Mountain Retreat");
        agency.addBooking(booking2);
        
        Booking booking3 = new Booking("Ryan Bansal", "Mountain Retreat");
        agency.addBooking(booking2);

        SignUp signUp1 = new SignUp("Snorkeling", 101);
        agency.addSignUp(signUp1);

        SignUp signUp2 = new SignUp("Hiking", 102);
        agency.addSignUp(signUp2);
        
        // 1. Print itineraries
        System.out.println("1. Iternaries\n");
        List<Itinerary> packageItineraries = agency.getItinerariesByPackage(package2.getName());
        
        List<Activity> packageActivities = new ArrayList<>();
        packageItineraries.stream().forEach(i -> packageActivities.addAll(agency.getActivitiesByDestination(i.getDestinationName())));
        
        System.out.println(packageItineraries);
        System.out.println(packageActivities);
        
        // 2. Print bookings
        System.out.println("\n\n\n 2. Bookings\n");
        List<Booking> packageBookings = agency.getBookingsByPackage(package2.getName());
        System.out.println(package2);
        System.out.println(packageBookings);
        
        // 3. Print sign ups
        System.out.println("\n\n\n 3. Passengers and Sign Ups\n");
        List<Passenger> passengers = agency.getPassengers();
        List<SignUp> activitySignUps = new ArrayList<>(); 
        		passengers.stream().forEach(p -> activitySignUps.addAll(agency.getSignUpsByPassenger(p.getNumber())));
        
        System.out.println(passengers);
        System.out.println(activitySignUps);
        
        // 4. Available activities
        System.out.println("\n\n 4. Available Activites\n");
        System.out.println(agency.getActivities().stream().filter(a -> a.getCapacity() > 0).toList());
    }
}