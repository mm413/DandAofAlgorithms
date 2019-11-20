//Dear Professor,
//I cannot figure out how to correctly implement the divide and conquer method.
//My code is close and I believe runs in the correct amount of time,
//the problem is that the base cases return what they find (the min and max) 
//from the list of two that they are given. I believe the issue may be somewhere
//in comparing the difference between two seperate lists to get a new min and max.
//Situationally, this function works (which really makes debugging hard).

package dAndC;

import java.util.*;
import MainStuff.Day;

public class DivideAndConquer {
	ArrayList<Day> days;
	int n;


	/**
	 * @param days - takes an ArrayList of Day objects
	 * constructor makes a divide and conquer object
	 */
	public DivideAndConquer(ArrayList<Day> days) {
		this.n = days.remove(0).getPrice();
		this.days = days;
	}
	
		
	/**
	 * @param min - the current day to buy on
	 * @param max - the current day to sell on 
	 * @param dayList - the list of day objects
	 * @return - an arrayList of 2 Day objects 
	 * solve uses divide and conquer to find the optimal days to buy/sell
	 */
	public ArrayList<Day> solve(Day min, Day max, List<Day> dayList) {
		//for list size 1
		if (dayList.size() == 1) {
			Day single = dayList.get(0);
			if (single.getPrice() > max.getPrice() && single.getDayNumber() > min.getDayNumber()){
				max = single;
			}
			if (single.getPrice() < min.getPrice() && single.getDayNumber() < max.getDayNumber()) {
				min = single;
			}
			ArrayList<Day> d = new ArrayList<Day>();
			d.add(min);
			d.add(max);
			return d;
		}
		//for list size 2
		if (dayList.size() <= 2){
			Day smaller;
			Day bigger;
			if (dayList.get(0).getPrice() <= dayList.get(1).getPrice()) {
				smaller = dayList.get(0);
				bigger = dayList.get(1);
			}else {
				smaller = dayList.get(1);
				bigger = dayList.get(0);
			}
			if (bigger.getPrice() > max.getPrice() && bigger.getDayNumber() > min.getDayNumber()){
				max = bigger;
			}
			if (smaller.getPrice() < min.getPrice() && smaller.getDayNumber() < max.getDayNumber()) {
				min = smaller;
			}
			ArrayList<Day> d = new ArrayList<Day>();
			d.add(min);
			d.add(max);
			return d;
		}
		//split in half
		List<Day> firstHalfList = dayList.subList(0, dayList.size()/2);
		List<Day> backHalfList = dayList.subList(dayList.size()/2, dayList.size());
		ArrayList<Day> frontSolutions = solve(min, max, firstHalfList);
		ArrayList<Day> backSolutions = solve(min, max, backHalfList);
		
		
		int frontDiff = frontSolutions.get(1).getPrice() - frontSolutions.get(0).getPrice();
		int backDiff = backSolutions.get(1).getPrice() - backSolutions.get(0).getPrice();
		//scan through front front solutions, find min
		//scan through back solutions, find max
		//use that difference as frontbackdiff
		
		Day frontMin = firstHalfList.get(0);
		Day backMax = backHalfList.get(0);
		for (Day d: firstHalfList) {
			if (d.getPrice() < frontMin.getPrice()){
				frontMin = d;
			}
		}
		for (Day d: backHalfList) {
			if (d.getPrice() > backMax.getPrice()){
				backMax = d;
			}
		}
		
		int frontBackDiff = backMax.getPrice() - frontMin.getPrice();
		ArrayList<Day> d = new ArrayList<Day>();
		if (frontDiff >= backDiff && frontDiff >= frontBackDiff) {
			//frontDiff wins
			//System.out.println("frontDiff wins");
			d.add(frontSolutions.get(0));
			d.add(frontSolutions.get(1));
			return d;
		} else if (backDiff >= frontDiff && backDiff >= frontBackDiff) {
			//backwins
			//System.out.println("backDiff wins");
			d.add(backSolutions.get(0));
			d.add(backSolutions.get(1));
			return d;
		} else if (frontBackDiff >= frontDiff && frontBackDiff >= backDiff) {
			//frontback wins
			//System.out.println("fronback wins");
			d.add(frontMin);
			d.add(backMax);
			return d;
		}
		d.add(min);
		d.add(max);
		return d;		
	}

}
