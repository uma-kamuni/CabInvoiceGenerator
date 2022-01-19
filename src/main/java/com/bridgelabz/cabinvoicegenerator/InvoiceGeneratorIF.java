package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;

public interface InvoiceGeneratorIF {
	
	public double calculateFare(double distance, int time);
	public double calculateFare(Ride[] rides);
	public InvoiceSummary calculateFareReturnObject(ArrayList<Ride> rides);
	
}