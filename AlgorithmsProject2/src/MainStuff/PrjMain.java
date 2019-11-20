// Mark Meade
// 10/14/19
// Algorithms Assignment #2
// The main function to run all other created functions from a central place



package MainStuff;
import java.io.*;
import java.util.*;

import bruteForce.BruteForceMethod;
import dAndC.DivideAndConquer;


public class PrjMain {
	/**
	 * @param args
	 * @throws FileNotFoundException - for opening the file 
	 * @throws UnsupportedEncodingException - for creating the file in UTF-8 format
	 */
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		int FileSize =200000;  //specify the file size here (number of days)
		int maxLength =1000; //specify the max value for each day
		MakeFile filemade = new MakeFile(FileSize, maxLength);
		File fileName = new File("test2.txt");
		Scanner file = new Scanner(fileName);
		String line;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Day> daysList = new ArrayList<Day>();
			
		while (file.hasNext()) {
			line = file.nextLine();
			nums.add(Integer.parseInt(line));
		}
		
		for (int i = 0; i < nums.size(); i++) {
			Day d = new Day(i, nums.get(i));
			daysList.add(d);
		}
		
		BruteForceMethod bf = new BruteForceMethod(nums);
		DivideAndConquer dac = new DivideAndConquer(daysList);
		Day dummyMax = new Day(10000, 0);
		Day dummyMin = new Day(0, 100000);
		long startbfTime = System.nanoTime();
		//System.out.println(bf.solve());
		long endbfTime = System.nanoTime();
		long elapsedbfTime = endbfTime - startbfTime;
		//System.out.println("execution time of brute force in nanoseconds = " + elapsedbfTime);
		
		long startdacTime = System.nanoTime();
		ArrayList<Day> dayz= dac.solve( dummyMin, dummyMax, daysList);
		//System.out.println(dayz);
		long enddacTime = System.nanoTime();
		long elapseddacTime = enddacTime - startdacTime;
		System.out.println("execution time of divide and conquer in nanoseconds = " + elapseddacTime);
	}
}


