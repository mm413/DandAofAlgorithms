package MainStuff;

public class Day {
	int dayNumber;
	int price;
	
	/**
	 * @param dayNumber
	 * @param price
	 * creates a day object with 2 attributes.
	 */
	public Day(int dayNumber, int price) {
		this.dayNumber = dayNumber;
		this.price = price;
	}
	
	/**
	 * @return int day number
	 */
	public int getDayNumber() {
		return dayNumber;
	}
	
	/**
	 * @return int day's price
	 */
	public int getPrice() {
		return this.price;
	}
	
	/**
	 *@return the string value of the day object
	 */
	public String toString() {
		return ("Day Number:" + dayNumber + " at price: " + price);
	}

}
