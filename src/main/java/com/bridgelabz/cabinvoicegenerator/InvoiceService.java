package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InvoiceService {
	
	Map<String, ArrayList<Ride>> rideMap;
	
	public InvoiceService() {
		this.rideMap= new HashMap<>();
	}
	
	public void addRide(String id, ArrayList<Ride> rides) {
		if(id != null)
			rideMap.put(id, rides);
	}
	public ArrayList<Ride> getRides(String id){
		if(rideMap.containsKey(id))
			return rideMap.get(id);
		return null;
	}
}