package FarmingMonitoringSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Displaystock {

	public void display() {

		// set text from a character-input stream
		BufferedReader in = null;

		// create list to store input
		List<String> myList = new ArrayList<String>();

		try {
			// set text from a file
			in = new BufferedReader(new FileReader("Stock.txt"));

			String str;

			while ((str = in.readLine()) != null) {

				myList.add(str);
			}

		}

		catch (FileNotFoundException notfound) {

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
