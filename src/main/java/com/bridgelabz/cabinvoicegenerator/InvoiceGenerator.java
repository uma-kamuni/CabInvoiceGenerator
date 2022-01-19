package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;

public class InvoiceGenerator implements InvoiceGeneratorIF{
	
	private static final double MINIMUM_COST_PER_KILOMETER_NORMAL = 10;
	private static final int COST_PER_TIME_NORMAL = 1;
	private static final double MINIMUM_FARE_NORMAL = 5;
	public static final double MINIMUM_COST_PER_KILOMETER_PREMIUM = 15;
	public static final double COST_PER_TIME_PREMIUM = 2;
	public static final double MINIMUM_FARE_PREMIUM = 20;

	@Override
	public double calculateFare(double distance, int time, String type) {
		
		if(type.equalsIgnoreCase("Normal")) {
			double totalFare = distance*MINIMUM_COST_PER_KILOMETER_NORMAL + time*COST_PER_TIME_NORMAL;
			return Math.max(totalFare, MINIMUM_FARE_NORMAL);
		}
		else if(type.equalsIgnoreCase("Premium")) {
			double totalFare = distance*MINIMUM_COST_PER_KILOMETER_PREMIUM + time*COST_PER_TIME_PREMIUM;
			return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
		}
		else {
			System.out.println("Please Enter Proper Customer Type");
			return 0.0;
		}
	}
	
	@Override
	public double calculateFare(Ride[] rides, String type) {
		
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare = totalFare + this.calculateFare(ride.distance, ride.time, type);
		}
		return totalFare;
	}
	
	@Override
	public InvoiceSummary calculateFareReturnObject(ArrayList<Ride> rides, String type) {
		
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare = totalFare + this.calculateFare(ride.distance, ride.time, type);
		}
		return new InvoiceSummary(rides.size(), totalFare);
	}
}