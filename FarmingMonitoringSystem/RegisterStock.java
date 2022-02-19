package FarmingMonitoringSystem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.*;

public class RegisterStock {

	public static void append() {

		// declare and initialize objects to a text-output stream.
		PrintWriter output = null;

		// declare text from a character-input stream
		BufferedWriter bufWriter;

		try {
			// open file for append and write
			bufWriter = Files.newBufferedWriter(Paths.get("Stock.txt"), Charset.forName("UTF8"),
					StandardOpenOption.WRITE, StandardOpenOption.APPEND, StandardOpenOption.CREATE);

			output = new PrintWriter(bufWriter, true);

		} catch (IOException e) {

			System.out.println("Please restart the program again");
		}

		// After successful creation of PrintWriter

		int counter = 2;

		String ID, name;

		int amount;

		int sentinel = 0;

		Scanner input = new Scanner(System.in);

		while (sentinel != -1) {

			try

			{
				System.out.println("Enter stock ID: ");

				ID = input.next();

				System.out.println("Enter stock name: ");

				name = input.next();

				System.out.println("Enter amount: ");

				amount = input.nextInt();

				// write to file format
				output.format("%s ", ID);

				output.format("%s ", name);

				output.format("%d %n", amount);
			}

			catch (FormatterClosedException formatterClosedException)

			{

				System.err.println("Error writing to file. Terminating.");

				break;
			}

			catch (NoSuchElementException elementException)

			{
				System.err.println("Invalid input and nothing was saved. Please try again. ");

				input.nextLine();

			}

			System.out.println("\n Do you wish to continue (Enter -1 to end and any integer to continue): ");

			try {

				sentinel = input.nextInt();

			}

			catch (InputMismatchException inputException) {

				System.err.println(
						"Sorry an error occured please try again after this message, press anything to continue ");

				try {

					System.in.read();

				}

				catch (IOException e) {

					e.printStackTrace();

				}
				append();

			}

			if (sentinel != -1)

			{

				System.out.print(counter++ + ". ");

			}

		}

		// close file
		output.close();
	}

}
