package FarmingMonitoringSystem;

public class Environment {

	private double EnvironmentReading = (int) (Math.random() * 101);

	private boolean on;

	private java.util.Date datecreated;

	public Environment() {

		// set date created to the current time as its date and time.
		this.datecreated = new java.util.Date();
	}

	public void turnon() {

		on = true;

		System.out.println("The sensor has been turned on\n");
	}

	public void turnoff() {

		on = false;

		System.out.println("The sensor has been turned off\n");
	}

	public double getReading() {

		return EnvironmentReading;
	}

	public void getMessage() {

		getReading();

		if (EnvironmentReading < 30)

			System.out.println("The environtment is bad");

		else if (EnvironmentReading >= 30 && EnvironmentReading <= 50)

			System.out.println("The environtment is perfect");

		else

			System.out.println("The environtment is perfect");

	}

	public void gettools(int option) {

		System.out.println("Tools has been turned on");

	}

	@Override
	public String toString() {

		return "done on " + datecreated;
	}

}
