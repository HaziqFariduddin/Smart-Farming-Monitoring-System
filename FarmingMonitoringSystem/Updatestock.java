package FarmingMonitoringSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

public class Updatestock {

	static StringBuffer stringBufferOfData = new StringBuffer();

	static String filename = null;

	static Scanner sc = new Scanner(System.in);// initialize scanner to get user input

	public static boolean readFile() {

		filename = "Stock.txt";// read in the file name

		Scanner fileToRead = null;

		try {
			fileToRead = new Scanner(new File(filename)); // point the scanner method to a file

			for (String line; fileToRead.hasNextLine() && (line = fileToRead.nextLine()) != null;) {

				System.out.println(line);// print each line

				stringBufferOfData.append(line).append("\r\n");// append all text read in from the file
			}
			fileToRead.close();

			return true;

		} catch (FileNotFoundException ex) {//  exception will be thrown

			System.out.println("The file " + filename + " could not be found! " + ex.getMessage());

			return false;

		} 
		finally {

			fileToRead.close();

			return true;
		}

	}

	public static void writeToFile() {
		try {

			BufferedWriter bufwriter = new BufferedWriter(new FileWriter(filename));

			bufwriter.write(stringBufferOfData.toString());// writes the edited string buffer to the new file

			bufwriter.close();// closes file

		} catch (Exception e) {

			System.out.println("Error occured while attempting to write to file: " + e.getMessage());
		}
	}

	public static void replacement() {
		System.out.println("Please enter the contents of a line you would like to edit: ");// enter the line file
																							

		String lineToEdit = sc.nextLine();// read the line to edit

		System.out.println("Please enter the new replacement line content: ");// enter line in file to replace

		String replacementText = sc.nextLine();// read the line to replace

		int startIndex = stringBufferOfData.indexOf(lineToEdit);// get the starting point of the text to edit

		int endIndex = startIndex + lineToEdit.length();// add the staring index of the text with text length to get the end index
														

		stringBufferOfData.replace(startIndex, endIndex, replacementText);// replacement of the text

		System.out.println("The new updated file is :\n" + stringBufferOfData); // check the string was replaced
	}

}
