package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ScreenFlights {
	
	List<Flight> flights;
	
	public ScreenFlights() {
		flights = new ArrayList<Flight>();
	}
	
	public ArrayList<Flight> getFlight() {
		return (ArrayList<Flight>) flights;
	}
	
	public String getRandomAirline() {
		String este = "";
		Random rnd = new Random();
		int value = rnd.nextInt(8);
		for (int i = 0; i < Airlines.values().length; i++) {
			if(value == i) {
				este = Airlines.values()[i].name();
			}
		}
		return este;
	}
	
	public String getRandomDestiny() {
		String este = "";
		Random rnd = new Random();
		int value = rnd.nextInt(8);
		for (int i = 0; i < Destinies.values().length; i++) {
			if(value == i) {
				este = Destinies.values()[i].getName();
			}
		}
		return este;
	}
	
	public String randomChar() {
		char este = 'a';
		String todo =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		este = todo.charAt(rnd.nextInt(26));
		todo = ""+este;
		return todo;
	}
	
	public String getRandomCode() {
		String este = "";
		Random rnd = new Random();
		este = randomChar();
		int num = rnd.nextInt(999);
		if(num<99) {
			este += "0"+ num;
		}else if(num<9) {
			este += "00"+num;		
		}else {
			este += num;
		}
		
		return este;
	}
	
	public Date getRandomDate() {
		Random rnd = new Random();
		int days = rnd.nextInt();
		Calendar date = Calendar.getInstance();
		date.add(Calendar.YEAR, days);
	
		return date.getTime();
	}

	public void insertionSort() {
    	
    	for (int i = 0; i < flights.size()-1; i++) {
			String minAirline = flights.get(i).getAirline();
			int minpos = i;
			for (int j = i+1; j < flights.size(); j++) {
				String currentAirline = flights.get(j).getNumFlight();
				if(currentAirline.compareTo(minAirline)<0) {
					minAirline = currentAirline;
					minpos = j;
				}
			}
			Flight temp = flights.get(minpos);
			flights.set(minpos, flights.get(i));
			flights.set(i, temp);
		}
	
    }
    public void bubbleSort() {
		for (int i = 0; i < flights.size()-1; i++) {
			for (int j = i-1; j < flights.size(); j++) {
				String este = flights.get(i).getNumFlight();
				String siguiente = flights.get(i+1).getNumFlight();
				if(este.compareTo(siguiente)<0) {
					Flight temp = flights.get(i);
					flights.set(i, flights.get(i+1));
					flights.set(i+1, temp);
				}
				
			}
			
		}
	}
	public void selectionSort() {
		for(int i=0;i<flights.size()-1;i++) {
			int min=1;
			for(int j=0; j<flights.size();j++) {
				min=j;
			}
			Flight aux=flights.get(i);
			flights.set(i, flights.get(min));
			flights.set(min, aux);
		}
		
	}
	public void sortByGate() {
		Comparator<Flight> gateComparator = new FlightGateComparator();
		
		Collections.sort(flights,gateComparator);
	}
	
	public void sortByDestiny() {
		Comparator<Flight> destinyComparator = new FlightDestinyComparator();
		
		Collections.sort(flights,destinyComparator);
	}
	
	public void sortByAirline() {
		Collections.sort(flights);
	}
}
