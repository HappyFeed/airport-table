package model;

import java.util.ArrayList;
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
	
	public void sortByFlight() {
		Comparator<Flight> flightComparator = new FlightComparator();
		
		Collections.sort(flights,flightComparator);
	}
	
	public void sortByAirline() {
		Collections.sort(flights);
	}
	
	public Flight binarySort(String parameter, String value){
		int high = flights.size()-1;
		int low = 0;
		int mid = -1;
		boolean out = false;
		Flight f=null;
		switch (parameter) {
	   
		case "Date":
			
			for (int i = 0; i < flights.size() && out == false ; i++) {
				mid = (low+high)/2;
				if(flights.get(mid).getDate().toString().equalsIgnoreCase(value)) {
					out = true;
				}else if(flights.get(mid).getDate().toString().compareTo(value)>0) {
					high = mid-1;
				}else if(flights.get(mid).getDate().toString().compareTo(value)<0) {
					low = mid+1;
				}
			}
			break;
			
		case "Airline":
			sortByAirline();
			for (int i = 0; i < flights.size() && out == false ; i++) {
				mid = (low+high)/2;
				if(flights.get(mid).getAirline().equalsIgnoreCase(value)) {
					out = true;
				}else if(flights.get(mid).getAirline().compareTo(value)>0) {
					high = mid-1;
				}else if(flights.get(mid).getAirline().compareTo(value)<0) {
					low = mid+1;
				}
			}
			break;
			
		case "Flight":
			sortByFlight();
			for (int i = 0; i < flights.size() && out == false ; i++) {
				mid = (low+high)/2;
				if(flights.get(mid).getNumFlight().equalsIgnoreCase(value)) {
					out = true;
				}else if(flights.get(mid).getNumFlight().compareTo(value)>0) {
					high = mid-1;
				}else if(flights.get(mid).getNumFlight().compareTo(value)<0) {
					low = mid+1;
				}
			}
			break;
			
		case "Destiny":
			sortByDestiny();
			for (int i = 0; i < flights.size() && out == false ; i++) {
				mid = (low+high)/2;
				if(flights.get(mid).getDestiny().equalsIgnoreCase(value)) {
					out = true;
				}else if(flights.get(mid).getDestiny().compareTo(value)>0) {
					high = mid-1;
				}else if(flights.get(mid).getDestiny().compareTo(value)<0) {
					low = mid+1;
				}
			}
			break;
			
		case "Gate":
			sortByGate();
			for (int i = 0; i < flights.size() && out == false ; i++) {
				mid = (low+high)/2;
				if(flights.get(mid).getGate().equalsIgnoreCase(value)) {
					out = true;
				}else if(flights.get(mid).getGate().compareTo(value)>0) {
					high = mid-1;
				}else if(flights.get(mid).getGate().compareTo(value)<0) {
					low = mid+1;
				}
			}
			break;
			
		default:
			mid = -1; 
			break;
		}
		if(out==true) {
			 f =  flights.get(mid);
		}

		return f;
	}
    

    public Flight linealSort(String parameter, String value){
	     Flight f=null;
	     switch (parameter) {
   
	    case "Date":

		break;
		
	    case "Airline":
		sortByAirline();
		for (int i = 0; i < flights.size()  ; i++) {
            String gateS=flights.get(i).getAirline();
			if(gateS.equalsIgnoreCase(value)) {
				f =  flights.get(i);
            }
		}
		break;
		
	  case "Flight":
		sortByFlight();
		for (int i = 0; i < flights.size()  ; i++) {
            String gateS=flights.get(i).getNumFlight();
			if(gateS.equalsIgnoreCase(value)) {
				f =  flights.get(i);
            }
		}
		break;
		
	case "Destiny":
		sortByDestiny();
		for (int i = 0; i < flights.size()  ; i++) {
            String gateS=flights.get(i).getDestiny();
			if(gateS.equalsIgnoreCase(value)) {
				f =  flights.get(i);
            }
		}
		break;
		
	case "Gate":
		sortByGate();
		for (int i = 0; i < flights.size()  ; i++) {
            String gateS=flights.get(i).getGate();
			if(gateS.equalsIgnoreCase(value)) {
				f =  flights.get(i);
            }
		}
		break;
		
	default:
		break;
	}

	return f;
    }
}
