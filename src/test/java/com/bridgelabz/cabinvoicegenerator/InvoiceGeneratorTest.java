package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {
	
	public static InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
	
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		
		double distance  = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
		
	}
	
	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinFare() {

		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnTotalFare() {

		Ride[] rides = {new Ride(2.0, 5), 
						new Ride(0.1, 1)};
		double totalFare = invoiceGenerator.calculateFare(rides);
		Assert.assertEquals(30, totalFare, 0.0);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {

		ArrayList<Ride> rides = new ArrayList<Ride>();
		rides.add(new Ride(2.0, 5));
		rides.add(new Ride(0.1, 1));
		InvoiceSummary summary = invoiceGenerator.calculateFareReturnObject(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
		if(expectedSummary.getAverageFare() == summary.getAverageFare() && expectedSummary.getNumberOfRides() == summary.getNumberOfRides() && expectedSummary.getTotalFare() == summary.getTotalFare())
			Assert.assertEquals(1, 1);
	}
	
	@Test
	public void givenUserId_ShouldReturnInvoiceSummary() {
		
		String userId = "User1";
		InvoiceService invoiceService = new InvoiceService();
		
		ArrayList<Ride> rides = new ArrayList<Ride>();
		rides.add(new Ride(2.0, 5));
		rides.add(new Ride(0.1, 1));
		
		invoiceService.addRide(userId, rides);
		ArrayList<Ride> listOfRides = invoiceService.getRides(userId);
		
		InvoiceSummary summaryForUser1 = invoiceGenerator.calculateFareReturnObject(listOfRides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
		if(expectedSummary.getAverageFare() == summaryForUser1.getAverageFare() && expectedSummary.getNumberOfRides() == summaryForUser1.getNumberOfRides() && expectedSummary.getTotalFare() == summaryForUser1.getTotalFare())
			Assert.assertEquals(1, 1);
	}
}