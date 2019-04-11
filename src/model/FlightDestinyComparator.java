package model;

import java.util.Comparator;

public class FlightDestinyComparator implements Comparator<Flight>{
    
	@Override
	public int compare(Flight flg1,Flight flg2){
		int compare;
		String destinyFlight1=flg1.getDestiny();
		String destinyFlight2=flg2.getDestiny();
		
		if(destinyFlight1.compareTo(destinyFlight2)>0) {
			compare = 1;
		}else if(destinyFlight1.compareTo(destinyFlight2)<0) {
			compare = -1;
		}else {
			compare = 0;
		}
		return compare;
	}
}
