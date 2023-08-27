package travel;

/**
 * Sign ups represent relationship between passengers and activities
 */
public class SignUp {
	 private String activityName;
	    private int passengerNumber;

	    public SignUp(String activityName, int passengerNumber) {
	        this.activityName = activityName;
	        this.passengerNumber = passengerNumber;
	    }

	    public String getActivityName() {
	        return activityName;
	    }

	    public int getPassengerNumber() {
	        return passengerNumber;
	    }

	    @Override
	    public String toString() {
	        return "SignUp{" +
	                "activityName='" + activityName + '\'' +
	                ", passengerNumber=" + passengerNumber +
	                '}';
	    }
}
