package game.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Utils class contains methods that make parsing through files 
 * easier, and more available (so we don't have to type them up every time)
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public class Utils {

	/**
	 * Using the passed in file path this method parses through the file
	 * appending its contents into a string and returning that string for
	 * future use
	 * @param path
	 * 	The file path of the txt file
	 * @return
	 * 	A string containing the everything that is in the given file
	 */
	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line + "\n");
			
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	/**
	 * Given a number in string format, this method converts it into an
	 * integer value if the value was not a number it returns zero
	 * @param number
	 * 	A number in string format
	 * @return
	 * 	The same number that was passed in, but in integer format,
	 * 	or zero if it wasn't a number in the first place
	 */
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
