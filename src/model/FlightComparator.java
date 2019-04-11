package model;

import java.util.Comparator;

public class FlightComparator implements Comparator<Flight>{
    
	@Override
	public int compare(Flight flg1,Flight flg2){
		int compare;
		String flight1=flg1.getNumFlight();
		String flight2=flg2.getNumFlight();
		
		if(flight1.compareTo(flight2)>0) {
			compare = 1;
		}else if(flight1.compareTo(flight2)<0) {
			compare = -1;
		}else {
			compare = 0;
		}
		return compare;
	}
}
