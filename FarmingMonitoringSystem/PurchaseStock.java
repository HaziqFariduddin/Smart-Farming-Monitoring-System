package FarmingMonitoringSystem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class PurchaseStock {

	private int decision;
	private java.util.Date datecreated;
	private int amount;
	private int totalprice;
	private String address;
	private int sentinel;
	private final static int HOE = 8;
	private final static int Shovel = 9;
	private final static int Chickenseeds = 5;
	private final static int Fooder = 20;
	private final static int HOSE = 12;
	private final static int WATERINGCAN = 6;
	private final static int SPRINKLER = 50;
	private final static int RAKE = 11;
	private String name;
	private String ID;

	public PurchaseStock() {
		// set date created to the current time as its date and time.
		datecreated = new java.util.Date();
	}

	public void GetStock() {

		// declare and initialize objects to a text-output stream.
		PrintWriter output = null;

		// declare text from a character-input stream
		BufferedWriter bufWriter;

		// input Scanner
		Scanner input = new Scanner(System.in);

		TestFarmingSystem RETURN = new TestFarmingSystem();

		do {

			do {

				System.out.println(
						"1.Hoe---[RM 8] \n 2.Shovel---[RM 9] \n 3.Chicken seeds---[RM 5] \n 4.Fooder---[RM 20] \n 5.Hose---[RM 12] \n 6.Watering can---[RM 6] \n 7.Sprinkler---[RM 50]  \n 8.Rake---[RM 11] \n\n\t -1.To return to main menu\n");

				System.out.println("Enter your option");

				decision = input.nextInt();

				address = input.nextLine();

//If sentinel then go to main menu
				if (decision == -1)

					RETURN.decision();

//continue if not sentinel
				System.out.println("Enter your address: ");

				address = input.nextLine();

				System.out.println("Enter your amount: ");

				amount = input.nextInt();

				if (decision != 1 && decision != 2 && decision != 3 && decision != 4 && decision != 5 && decision != 6
						&& decision != 7 && decision != 8)

				{
					System.err.println("\nYou've enter invalid value, press enter to continue ");

					try {

						System.in.read();
					}

					catch (IOException e) {

						e.printStackTrace();
					}
				}

			} while (decision != 1 && decision != 2 && decision != 3 && decision != 4 && decision != 5 && decision != 6
					&& decision != 7 && decision != 8);

			if (decision == 1)

			{
				totalprice = HOE * amount;

				name = "Hoe";

				ID = "D001";
			}

			else if (decision == 2)

			{
				totalprice = Shovel * amount;

				name = "Shovel";

				ID = "D002";

			}

			else if (decision == 3)

			{
				totalprice = Chickenseeds * amount;

				name = "Chicken seeds";

				ID = "D003";
			}

			else if (decision == 4)

			{
				totalprice = Fooder * amount;

				name = "Fooder";

				ID = "D004";
			}

			else if (decision == 5)

			{

				totalprice = HOSE * amount;

				name = "Hose";

				ID = "D005";
			}

			else if (decision == 6)

			{
				totalprice = WATERINGCAN * amount;

				name = "Watering can";

				ID = "D006";
			}

			else if (decision == 7)

			{
				totalprice = SPRINKLER * amount;

				name = "Sprinkler";

				ID = "D007";
			}

			else if (decision == 8)

			{
				totalprice = RAKE * amount;

				name = "Rake";

				ID = "D008";
			}

//Display receipt
			System.out.println(
					"\n============================================================================ \n\t\t Receipt\n"
							+ name + "\namount is: " + amount + "\nTotal price: RM " + totalprice
							+ "\n\n Purchased on: " + datecreated + "\n Delivered to: " + address
							+ "\n\n============================================================================");

			System.out.println("\n\n do you wish to make purchase (press -1 to stop and key to continue");

			try {

				// open file for append and write
				bufWriter = Files.newBufferedWriter(Paths.get("Stock.txt"), Charset.forName("UTF8"),
						StandardOpenOption.WRITE, StandardOpenOption.APPEND, StandardOpenOption.CREATE);

				output = new PrintWriter(bufWriter, true);

			} catch (IOException e) {

				System.out.println("Please restart the program again");

			}
//After successful creation of PrintWriter
			try

			{
				// output to file format
				output.format("%s ", ID);

				output.format("%s ", name);

				output.format("%d %n", amount);
			}

			catch (FormatterClosedException formatterClosedException) {
				System.err.println("Error writing to file. Terminating.");

				break;
			} catch (NoSuchElementException elementException) {
				System.err.println("Invalid input and nothing was saved. Please try again. ");

				input.nextLine();

			}

			// close file
			output.close();

			try {

				sentinel = input.nextInt();
			}

			catch (Exception inputmismatch) {

				System.err.println(
						"You've enter invalid value please try again after this message, press anything to continue ");

				try {

					System.in.read();

					GetStock();
				}

				catch (IOException e) {

					e.printStackTrace();

				}

			}
		} while (sentinel != -1);

		RETURN.decision();

	}
}