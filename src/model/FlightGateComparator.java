package model;

import java.util.Comparator;

public class FlightGateComparator implements Comparator<Flight>{
    
	@Override
	public int compare(Flight flg1,Flight flg2){
		int compare;
		String gateFlight1=flg1.getGate();
		String gateFlight2=flg2.getGate();
		
		if(gateFlight1.compareTo(gateFlight2)>0) {
			compare = 1;
		}else if(gateFlight1.compareTo(gateFlight2)<0) {
			compare = -1;
		}else {
			compare = 0;
		}
		return compare;
	}
}
