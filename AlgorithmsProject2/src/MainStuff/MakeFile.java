package MainStuff;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class MakeFile {

	/**
	 * @param FileSize - the first number in the array, and the len of array
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 * builds a file of fileSize length with random numbers on each line between 1 and fileSize
	 */
	public MakeFile(int FileSize, int maxSize) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("test2.txt", "UTF-8");
		Random rand = new Random();
		writer.println(FileSize);
		for (int i = 0; i < FileSize; i++) {
			writer.println(rand.nextInt( maxSize)+1);
		}
		writer.close();
	}

}
