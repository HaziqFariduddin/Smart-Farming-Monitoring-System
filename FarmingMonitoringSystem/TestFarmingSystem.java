package FarmingMonitoringSystem;

import java.io.*;
import java.util.*;
import java.io.IOException;

public class TestFarmingSystem {

	// Main method
	public static void main(String[] args) {

		TestFarmingSystem myobj = new TestFarmingSystem();
		myobj.decision();

	}

	public void decision() {

		// create new object
		PurchaseStock purchase = new PurchaseStock();

		Displaystock displayS = new Displaystock();

		DisplayInventory displayI = new DisplayInventory();

		UpdateInventory updateinventory = new UpdateInventory();

		Updatestock updatestock = new Updatestock();

		LivestockFeeding feed = new LivestockFeeding();

		RegisterStock stock = new RegisterStock();

		RegisterInventory inventory = new RegisterInventory();

		// Polymorphism, create new object (upcasting)
		Environment moisture = new MoistureSoil();
		Environment HumidTemp = new HumidityandTemperature();

		// input scanner
		Scanner input = new Scanner(System.in);

		// display message
		System.out.println("\t\tWelcome to the farming and monitoring system");
		System.out.println(
				"\nPlease enter you choice\n\n 1.Soil Moisture\n 2.Temperature and Humidity\n 3.Livestock Feeding\n 4.Iventory and Stock\n 5.Purchase Stock\n 6.Update or Delete Stock and Inventory \n 7.Display Stock and Inventory \n 8.Exit");

		int decision = input.nextInt();

		switch (decision) {

		case 1:

			System.out.println("\n\n\n\n\n\n\n\t\t   Soil Moisture  \n\t========================================\n");

			moisture.turnon();

			moisture.getMessage();

			if (moisture.getReading() < 30) {
				int option = 3;

				while (option != 1 && option != 0) {

					System.out.println("\nDo you wish to turn on the sprinkler\n 0.No\n 1.Yes");

					option = input.nextInt();

					moisture.gettools(option);
				}

			}

			System.out.println("\n\n\t Press anything to continue");
			try {
				System.in.read();
			} catch (IOException e) {

				e.printStackTrace();
			}

			decision();

			break;

		case 2:
			System.out.println(
					"\n\n\n\n\n\n\n\t\t   Temperature and Humidity  \n\t========================================\n");

			HumidTemp.turnon();

			HumidTemp.getMessage();

			System.out.println("\n\n\t Press anything to continue");

			try {
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}

			decision();

			break;

		case 3:

			System.out
					.println("\n\n\n\n\n\n\n\t\t   Livestock Feeding  \n\t========================================\n");

			System.out.println(
					"Enter the type of animal you wish to feed: \n 1.cow       2.sheep \t 3.chicken  \t (-1 return to main menu)");

			try {

				int choice = input.nextInt();

				while (choice != 1 && choice != 2 && choice != 3 && choice != -1) {

					System.out.println("Enter a valid choice (-1 to exit): ");

					choice = input.nextInt();

					if (choice == -1)

						decision();

				}

				feed.SetAnimal(choice);

			}

			catch (Exception inputmismatch)

			{

				System.out.println("Please enter a valid input!\n\n\tPress enter to return to main menu");

				try {

					System.in.read();
				}

				catch (IOException e) {

					e.printStackTrace();
				}

				decision();
			}

			feed.setCoordinate();

			feed.messageFeed();

			System.out.println("\nFeeding successfull!\n\n\tPress enter to return to main menu");

			try {
				System.in.read();
			}

			catch (IOException e) {

				e.printStackTrace();
			}

			decision();

			break;

		case 4:

			System.out.println(
					"\n\n\n\n\n\n\n\t\t   Inventory and Stock  \n\t========================================\n");

			System.out.println(" 1.Register inventory \n 2.Register stock\n 3.Return to main menu");

			int option = 0;

			option = input.nextInt();

			switch (option) {

			case 1:

				System.out.println(
						"\n\n\n\n\n\n\n\t\t   Register inventory  \n\t========================================\n");

				inventory.append();

				System.out.println(" \nData successfully saved! \n\n\t Press anything to continue");

				try {
					System.in.read();
				}

				catch (IOException e) {
					e.printStackTrace();
				}

				decision();

				break;

			case 2:

				System.out
						.println("\n\n\n\n\n\n\n\t\t   Register stock  \n\t========================================\n");

				stock.append();

				System.out.println(" \nData successfully saved! \n\n\t Press anything to continue");

				try {
					System.in.read();
				}

				catch (IOException e) {
					e.printStackTrace();
				}

				decision();

				break;

			case 3:

				decision();

				break;

			default:
				decision();
				break;

			}

		case 5:
			purchase.GetStock();

			break;

		case 6:

			System.out.println(
					"\n\n\n\n\n\n\n           Update or Delete Stock Inventory  \n\t========================================\n");

			System.out.println("1.Update or Delete Stock\t 2.Update or Delete Inventory\t (-1 to return to main menu)");

			System.out.println("\n Enter you choice: ");

			int choice;

			choice = input.nextInt();

			boolean fileRead;

			if (choice == 1) {
				fileRead = updatestock.readFile();

				if (fileRead) {// if the read file was successfull

					updatestock.replacement();// call method to get text to replace, replacement text and output
												// replaced String buffer

					updatestock.writeToFile();
				}
			} else if (choice == 2) {

				fileRead = UpdateInventory.readFile();

				if (fileRead) {// if the read file was successfull

					UpdateInventory.replacement();// call method to get text to replace, replacement text and output
													// replaced String buffer

					UpdateInventory.writeToFile();
				}

			} else if (choice == -1)

				decision();

			else {
				decision();
			}

			break;

		case 7:

			System.out.println(
					"\n\n\n\n\n\n\n           Display Stock and Inventory  \n\t========================================\n");

			System.out.println("1.Display Stock \t 2. Display Inventory");

			System.out.println("\nEnter your choice: ");

			choice = input.nextInt();

			if (choice == 1)

				displayS.display();

			else if (choice == 2)

				displayI.display();

			else {
				decision();
			}
			System.out.println("\nPress enter to return to main menu");

			try {
				System.in.read();
			}

			catch (IOException e) {
				e.printStackTrace();
			}
			decision();
			break;
		case 8:

			System.out.println("\nProgram has been terminate!");

			try {
				System.in.read();
			}

			catch (IOException e) {
				e.printStackTrace();
			}
			System.exit(1);
			break;

		default:
			System.out.println("\nEnter valid input!, press anyting to continue");

			try {
				System.in.read();
			}

			catch (IOException e) {
				e.printStackTrace();
			}
			decision();
			break;
		}

	}
}
