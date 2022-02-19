package FarmingMonitoringSystem;

//Inheritance. inherit from Environment class
public class MoistureSoil extends Environment {

	private double MoistureReading = getReading();

	MoistureSoil() {

	}

	// Overriding Environment.getMessage
	public void getMessage() {

		if (MoistureReading < 30) {

			System.out.println("The soil moisture reading shows that the soil is very dry");

		} else if (MoistureReading >= 30 && MoistureReading <= 50)

			System.out.println("The soil moisture reading shows that the soil is in perfect condition");

		else

			System.out.println(
					"The soil moisture reading shows that the soil is very moist and not ideal, might want take some precautions.");

	}

	// Overriding Environment.gettools
	public void gettools(int option) {

		if (option == 1)

			System.out.println(
					"Sprinkler has been turned on,and the soil has been watered to the right amount " + toString());

		else if (option == 0)

			System.out.println("Sprinkler is not turned on,and the soil is very dry");

	}

}