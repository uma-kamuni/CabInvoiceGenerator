package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;

public class InvoiceGenerator implements InvoiceGeneratorIF{
	
	private static final double MINIMUM_COST_PER_KILOMETER = 10;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;

	@Override
	public double calculateFare(double distance, int time) {
		
		double totalFare = distance*MINIMUM_COST_PER_KILOMETER + time*COST_PER_TIME;
		return Math.max(totalFare, MINIMUM_FARE);
	}
	
	@Override
	public double calculateFare(Ride[] rides) {
		
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare = totalFare + this.calculateFare(ride.distance, ride.time);
		}
		return totalFare;
	}
	
	@Override
	public InvoiceSummary calculateFareReturnObject(ArrayList<Ride> rides) {
		
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare = totalFare + this.calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.size(), totalFare);
	}
}