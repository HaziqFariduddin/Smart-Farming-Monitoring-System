package FarmingMonitoringSystem;

//Inheritance. inherit from Environment class
public class HumidityandTemperature extends Environment {

	// get reading from Environment class
	private double humidity = getReading();
	// set temperature
	private double temperature = (int) (Math.random() * 101);

	public HumidityandTemperature() {

	}

	// Overriding Environment.getMessage
	public void getMessage() {

		if (humidity >= 30 && humidity <= 50)

			System.out.println("Humidity level is average " + humidity + "%, good for farming" + ", The temperature is "
					+ temperature + "° Fahrenheit");

		else if (humidity > 50)

			System.out.println("Humidity level is high " + humidity + "%, not good for farming"
					+ ", The temperature is " + temperature + "° Fahrenheit");
		else

			System.out.println("Humidity level is low " + humidity + "%, ideal for farming" + ", The temperature is "
					+ temperature + "° Fahrenheit");
	}

}
