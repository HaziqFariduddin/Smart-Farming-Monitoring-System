package FarmingMonitoringSystem;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class DisplayInventory {

	public void display() {

		// set text from a character-input stream
		BufferedReader in = null;

		// create list to store input
		List<String> myList = new ArrayList<String>();

		try {
			// set text from file
			in = new BufferedReader(new FileReader("Inventory.txt"));
			String str;
			while ((str = in.readLine()) != null) {
				myList.add(str);

			}

		} catch (FileNotFoundException notfound) {
			notfound.printStackTrace();

		}

		catch (IOException IOexception) {
			IOexception.printStackTrace();

		}

		finally {

			if (in != null) {

				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("\nID/NAME/AMOUNT\n========================");

		System.out.println(myList.stream().map(Object::toString).collect(Collectors.joining("\n")));
	}
}