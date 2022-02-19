package FarmingMonitoringSystem;

import java.util.*;

public class LivestockFeeding {

	private int[] amount;
	private int[] x = new int[1000];
	private int[] y = new int[1000];
	private int[] z = new int[1000];

	// shared to all object for static
	private static String animal;
	private java.util.Date datecreated;
	private String foodType;
	private int coordinate;

	public LivestockFeeding() {
		// set date created to the current time as its date and time.
		this.datecreated = new java.util.Date();

	}

	public void setCoordinate() {
		// input stream
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the amount of coordinate you wish to enter : ");

		// get array size from user
		int arraysize = input.nextInt();

		this.amount = new int[arraysize];

		for (int i = 1; i <= amount.length; i++) {

			System.out.println("Enter the coordinate range for the " + i + ". X : ");

			coordinate = input.nextInt();

			this.x[i] = coordinate;

			System.out.println("Enter the coordinate range for the " + i + ". Y : ");

			coordinate = input.nextInt();

			this.y[i] = coordinate;

			System.out.println("Enter the coordinate range for the " + i + ". Z : ");

			coordinate = input.nextInt();

			this.z[i] = coordinate;

		}

		System.out.println("\nEnter the food type: \n 1.Fooder  2.Seeds  3.Grain");

		int setterfood = input.nextInt();

		if (setterfood == 1)

			foodType = "fooder";

		else if (setterfood == 2)

			foodType = "seeds";

		else if (setterfood == 3)
			foodType = "grain";

	}

	public void SetAnimal(int choice) {

		// create new object
		TestFarmingSystem RETURN = new TestFarmingSystem();

		Scanner input = new Scanner(System.in);

		if (choice == 1)

			this.animal = "Cow";

		else if (choice == 2)

			this.animal = "Sheep";

		else if (choice == 3)

			this.animal = "Chicken";

		else if (choice == -1)
			RETURN.decision();
		// return to main method, main menu

	}

	public void messageFeed() {

		for (int i = 1; i <= amount.length; i++)

		{
			System.out.println(animal + " pen at coordinate X:" + x[i] + " Y:" + y[i] + " Z:" + z[i]
					+ " have been feed with " + foodType + " on " + datecreated);
		}

	}

}
