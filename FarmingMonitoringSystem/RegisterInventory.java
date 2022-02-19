package FarmingMonitoringSystem;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.nio.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RegisterInventory {

	public static void append() {

		// declare and initialize objects to a text-output stream.
		PrintWriter output = null;

		// declare text from a character-input stream
		BufferedWriter bufWriter;

		try {
			// open file for append and write
			bufWriter = Files.newBufferedWriter(Paths.get("Inventory.txt"), Charset.forName("UTF8"),
					StandardOpenOption.WRITE, StandardOpenOption.APPEND, StandardOpenOption.CREATE);

			output = new PrintWriter(bufWriter, true);

		} catch (IOException e) {
			// Oh, no! Failed to create PrintWriter
		}

		// After successful creation of PrintWriter
		int counter = 2;

		int sentinel = 0;

		Scanner input = new Scanner(System.in);

		while (sentinel != -1) {
			try {
				// write to file format
				System.out.println("Enter crops or produce ID: ");

				output.format("%s ", input.next());

				System.out.println("Enter crops or produce name: ");

				output.format("%s ", input.next());

				System.out.println("Enter amount: ");

				output.format("%d %n", input.nextInt());

			}

			catch (FormatterClosedException formatterClosedException)

			{

				System.err.println("Error writing to file. Terminating.");

				break;
			}

			catch (NoSuchElementException elementException)

			{

				System.err.println("Invalid input. Please try again. ");

				input.nextLine();
			}

			System.out.println("\n Do you wish to continue (Enter -1 to end and any integer to continue): ");

			sentinel = input.nextInt();

			if (sentinel != -1) {

				System.out.print(counter++ + ". ");

			}

		}

		// close file
		output.close();
	}
}
